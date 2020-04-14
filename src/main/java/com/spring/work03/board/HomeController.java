package com.spring.work03.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class HomeController {
    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        return "JSONTest";
    }
}