package com.spring.work01.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public ModelAndView login(@ModelAttribute("info") LoginVO loginVO,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        return new ModelAndView("login/result");
    }
    @RequestMapping(value = "/test/login2.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String login2(Model model, HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        request.setCharacterEncoding("utf-8");
        model.addAttribute("userID", "hong");
        model.addAttribute("userName", "홍길동");
        return "login/result";
    }
}
