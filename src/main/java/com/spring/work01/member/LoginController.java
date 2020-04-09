package com.spring.work01.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller("loginController")
public class LoginController {
    @RequestMapping(value = {"/test/loginForm.do", "/test/loginForm2.do"}, method = RequestMethod.GET)
    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("login/loginForm");
    }

    @RequestMapping(value = "/test/login.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(/*@RequestParam(value = "id", required = true) String id,
                              @RequestParam(value = "pwd", required = true) String pwd,
                              */
                              @RequestParam Map<String, String> info,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView("login/result");
        mav.addObject("info", info);
        return mav;
    }
}
