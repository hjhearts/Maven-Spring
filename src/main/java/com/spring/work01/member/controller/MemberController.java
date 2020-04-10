package com.spring.work01.member.controller;

import com.spring.work01.member.vo.MemberVO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface MemberController {
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response);
    public ModelAndView addMember(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response);
    public ModelAndView login(@ModelAttribute MemberVO memberVO, RedirectAttributes rAttr,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
