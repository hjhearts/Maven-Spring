package com.spring.work01.member.controller;


import com.spring.work01.member.service.MemberService;
import com.spring.work01.member.vo.MemberVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{
    private static final Logger logger = Logger.getLogger(MemberControllerImpl.class);
    @Autowired
    @Qualifier("memberService")
    private MemberService memberService;

    @Autowired
    @Qualifier("memberVO")
    private MemberVO memberVO;

    @Override
    @RequestMapping(value = "/member/listMembers.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("member/listMembers");
        logger.info("info 레벨 : viewName = " + getViewName(request));
        logger.debug("debug 레벨 : viewName = " + getViewName(request));
        List<MemberVO> membersList = memberService.listMembers();
        mav.addObject("membersList", membersList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
    public ModelAndView addMember(@RequestParam Map<String, String> paramMap,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        memberVO.setId(paramMap.get("id"));
        memberVO.setPwd(paramMap.get("pwd"));
        memberVO.setName(paramMap.get("name"));
        memberVO.setEmail(paramMap.get("email"));
        int status = memberService.addMember(memberVO);
        System.out.println("STATUS : " + status);
        return listMembers(request, response);
    }
    @Override
    @RequestMapping(value = "/member/addMemberForm.do", method = RequestMethod.GET)
    public ModelAndView addMemberForm(){
        return new ModelAndView("member/addMemberForm");
    }

    private String getViewName(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
        System.out.println(uri);
        if(uri == null || uri.trim().equals("")){
            uri = request.getRequestURI();
        }
        int begin = 0;
        if(!((contextPath == null) || ("".equals(contextPath)))){
            begin = contextPath.length();
        }
        int end;
        if(uri.contains(";")){
            end = uri.indexOf(";");
        }else if(uri.contains("?")){
            end = uri.indexOf("?");
        }else{
            end = uri.length();
        }
        String fileName = uri.substring(begin, end);
        if(fileName.contains(".")){
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        if(fileName.lastIndexOf("/") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        }
        System.out.println(fileName);
        return fileName;
    }
}
