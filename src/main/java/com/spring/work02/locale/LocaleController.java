package com.spring.work02.locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("localeController")
public class LocaleController {
    @RequestMapping(value = "/test/locale.do", method = RequestMethod.GET)
    public String locale(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "loctest/locale";
    }
}
