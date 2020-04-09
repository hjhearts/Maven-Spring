package com.spring.work01.member.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public interface MemberController {
    public ModelAndView listMembers();
    public ModelAndView addMember(@RequestParam Map<String, String> map);
    public ModelAndView addMemberForm();
}
