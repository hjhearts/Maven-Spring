package com.spring.work02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@Controller
public class FileUploadController {
    @RequestMapping(value = "/form")
    public String form(){
        return "file/uploadForm";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(MultipartHttpServletRequest multipartRequest,
                                     HttpServletResponse response) throws Exception{

        multipartRequest.setCharacterEncoding("utf-8");
        Map map = new HashMap<>();
        Enumeration enumeration = multipartRequest.getParameterNames();
        while(enumeration.hasMoreElements()){
            String name = (String)enumeration.nextElement();
            String value = multipartRequest.getParameter(name);
            map.put(name, value);
        }
        List<String> fileList = fileProcess(multipartRequest);
        map.put("fileList", fileList);
        ModelAndView mav = new ModelAndView("file/result");
        mav.addObject("map", map);
        return mav;
    }

    private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
        List<String> fileList = new ArrayList<>();
        Iterator<String> fileNames = multipartRequest.getFileNames();
        while (fileNames.hasNext()){
            String fileName = fileNames.next();
            MultipartFile mFile = multipartRequest.getFile(fileName);
            assert mFile != null;
            String originalFileName = mFile.getOriginalFilename();
            fileList.add(originalFileName);
            String CURR_IMAGE_FILE_REPO = "c:/spring/image_repo";
            File file = new File(CURR_IMAGE_FILE_REPO + "/" + fileName);
            if(mFile.getSize() != 0){
                if(! file.exists()){
                    if(file.getParentFile().mkdirs()){
                        file.createNewFile();
                    }
                }
                mFile.transferTo(new File(CURR_IMAGE_FILE_REPO + "/"  + originalFileName));
            }
        }
        return fileList;
    }
}
