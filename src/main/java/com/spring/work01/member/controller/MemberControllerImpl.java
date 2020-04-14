package com.spring.work01.member.controller;


import com.spring.work01.member.service.MemberService;
import com.spring.work01.member.vo.MemberVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    private ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String viewName = (String)request.getAttribute("viewName");
        return new ModelAndView(viewName);
    }

    @Override
    @RequestMapping(value = "/member/listMembers.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView((String)request.getAttribute("viewName"));
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
        return new ModelAndView("redirect:/member/listMembers.do");
    }

    @Override
    @RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute MemberVO loginVO,
                              RedirectAttributes rAttr,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        memberVO = memberService.login(loginVO);
        ModelAndView mav = new ModelAndView();
        if(memberVO != null){
            HttpSession session = request.getSession();
            String action = (String)session.getAttribute("action");
            session.setAttribute("member", memberVO);
            session.setAttribute("isLogon", true);
            if(action != null){
                mav.setViewName("redirect:" + action);
            }else{
                mav.setViewName("redirect:/member/listMembers.do");
            }
        }else{
            rAttr.addAttribute("result", "loginFailed");
            mav.setViewName("redirect:/member/loginForm.do");
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("member");
        session.removeAttribute("isLogon");
        return new ModelAndView("redirect:/member/listMembers.do");
    }

    @RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
    private ModelAndView form(@RequestParam(value = "result", required = false) String result,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception{
        String viewName = (String)request.getAttribute("viewName");
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", result);
        mav.setViewName(viewName);
        return mav;
    }


}
