package com.spring.work01.member.controller;


import com.spring.work01.member.dao.MemberDAO;
import com.spring.work01.member.service.MemberService;
import com.spring.work01.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{
    @Autowired
    @Qualifier("memberService")
    private MemberService memberService;

    @Autowired
    @Qualifier("memberVO")
    private MemberVO memberVO;

    @Override
    @RequestMapping(value = "/member/listMembers.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listMembers() {
        ModelAndView mav = new ModelAndView("member/listMembers");
        List<MemberVO> membersList = memberService.listMembers();
        mav.addObject("membersList", membersList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
    public ModelAndView addMember(@RequestParam Map<String, String> paramMap) {
        memberVO.setId(paramMap.get("id"));
        memberVO.setPwd(paramMap.get("pwd"));
        memberVO.setName(paramMap.get("name"));
        memberVO.setEmail(paramMap.get("email"));
        int status = memberService.addMember(memberVO);
        System.out.println("STATUS : " + status);
        return listMembers();
    }
    @Override
    @RequestMapping(value = "/member/addMemberForm.do", method = RequestMethod.GET)
    public ModelAndView addMemberForm(){
        return new ModelAndView("member/addMemberForm");
    }
}
