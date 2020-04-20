package com.spring.work01.board.controller;

import com.spring.work01.board.service.BoardService;
import com.spring.work01.board.vo.ArticleVO;
import com.spring.work01.board.vo.ImageVO;
import com.spring.work01.member.vo.MemberVO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private ArticleVO articleVO;

    private static final String ARTICLE_IMAGE_REPO = "c:/spring/image_repo";

    @Override
    @RequestMapping(value = "/board/listArticles.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response){
        String viewName = (String)request.getAttribute("viewName");
        List<ArticleVO> listArticles = boardService.listArticles();
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("articlesList", listArticles);
        return mav;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/board/addArticle.do", method = RequestMethod.POST)
    public ResponseEntity<String> addNewArticle(MultipartHttpServletRequest multipartRequest,
                                        HttpServletResponse response) throws Exception{
        multipartRequest.setCharacterEncoding("utf-8");
        HttpSession httpSession = multipartRequest.getSession();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "text/html;charset=utf-8");
        if(httpSession.getAttribute("isLogon")==null || !((boolean) httpSession.getAttribute("isLogon"))){
            httpSession.setAttribute("action", "/board/articleForm.do");
            return new ResponseEntity<>("<script>alert('로그인 먼저 해주세요');" +
                    "location.href='"+ multipartRequest.getContextPath()+"/member/loginForm.do';</script>", httpHeaders, HttpStatus.FORBIDDEN);
        }
        Map<String, Object> articleMap = new HashMap<>();
        Enumeration enu = multipartRequest.getParameterNames();
        while(enu.hasMoreElements()){
            String parameterName = (String)enu.nextElement();
            String parameterValue = multipartRequest.getParameter(parameterName);
            System.out.println(parameterName + ":" + parameterValue);
            articleMap.put(parameterName, parameterValue);
        }
        List<String> fileList = upload(multipartRequest);
        List<ImageVO> imageFileList = new ArrayList<>();
        if(fileList.size() != 0) {
            for (String fileName : fileList) {
                ImageVO imageVO = new ImageVO();
                imageVO.setImageFileName(fileName);
                imageFileList.add(imageVO);
            }
            articleMap.put("imageFileName", imageFileList);
        }
        MemberVO memberVO = (MemberVO)httpSession.getAttribute("member");
        String id = memberVO.getId();
        articleMap.put("id", id);
        articleMap.put("imageFileList", imageFileList);
        String message;
        ResponseEntity responseEntity;
        try{
            int articleNO = boardService.addArticle(articleMap);
            if(imageFileList.size() != 0){
                for(ImageVO imageVO : imageFileList){
                    String imageFileName = imageVO.getImageFileName();
                    File srcFile = new File(ARTICLE_IMAGE_REPO + "/temp/" + imageFileName);
                    File destDir = new File(ARTICLE_IMAGE_REPO + "/" + articleNO);
                    FileUtils.moveFileToDirectory(srcFile, destDir, true);
                }
            }
            message = "<script>";
            message += "alert('새글을 추가했습니다.');";
            message += "location.href='" + multipartRequest.getContextPath() + "/board/listArticles.do';";
            message += "</script>";
            responseEntity = new ResponseEntity(message, httpHeaders, HttpStatus.CREATED);
        }catch(Exception e){
            if(imageFileList.size() != 0){
                for(ImageVO imageVO : imageFileList){
                    String imageFileName = imageVO.getImageFileName();
                    File srcFile = new File(ARTICLE_IMAGE_REPO + "/temp/" + imageFileName);
                    srcFile.delete();
                }
            }
            message = "<script>";
            message += "alert('오류가 발생했습니다.')";
            message += "location.href='" + multipartRequest.getContextPath() + "/board/articleForm.do';";
            responseEntity = new ResponseEntity(message, httpHeaders, HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "/board/*Form.do", method = RequestMethod.GET)
    private ModelAndView form(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView((String)request.getAttribute("viewName"));
    }

    private List<String> upload(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        List<String> imageFileList = new ArrayList<>();
        String imageFileName = null;
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        while(fileNames.hasNext()){
            String fileName = fileNames.next();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            imageFileName = multipartFile.getOriginalFilename();
            imageFileList.add(imageFileName);
            File file = new File(ARTICLE_IMAGE_REPO + "/" + fileName);
            if(multipartFile.getSize() != 0){
                if(! file.exists()){
                    if(file.getParentFile().mkdirs()){
                        file.createNewFile();
                    }
                }
                multipartFile.transferTo(new File(ARTICLE_IMAGE_REPO + "/temp/" + imageFileName));
            }

        }
        return imageFileList;
    }
    @RequestMapping(value = "/board/viewArticle.do", method = RequestMethod.GET)
    public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws Exception{
        String viewName = (String)request.getAttribute("viewName");
        articleVO = boardService.viewArticle(articleNO);
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("article", articleVO);
        return mav;
    }

    @RequestMapping(value = "/board/modArticle.do", method = RequestMethod.POST)
    public ResponseEntity<String> modArticle(HttpServletRequest request,
                                   @ModelAttribute ArticleVO vo,
                                   HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        boardService.modArticle(vo);
        return new ResponseEntity<>("<script>" +
                "alert('수정 완료');location.href='" + request.getContextPath() +"/board/listArticles.do';" +
                "</script>", HttpStatus.CREATED);
    }
    @RequestMapping(value = "/board/delArticle.do/{articleNO}")
    public ResponseEntity<String> delArticle(@PathVariable("articleNO") int articleNO,
                                             HttpServletRequest request,
                                             HttpServletResponse response){
        boardService.delArticle(articleNO);
        return new ResponseEntity<>("<script>" +
                "alert('삭제완료');" +
                "location.href='" + request.getContextPath() + "/board/listArticles.do';" +
                "</script>", HttpStatus.OK);
    }
}
