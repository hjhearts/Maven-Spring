package com.spring.work01.member.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface MemberController {
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response);
    public ModelAndView addMember(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response);
    public ModelAndView addMemberForm();
}
