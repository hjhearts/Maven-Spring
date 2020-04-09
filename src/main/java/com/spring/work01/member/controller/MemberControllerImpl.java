package com.spring.work01.member.controller;


import com.spring.work01.member.dao.MemberDAO;
import com.spring.work01.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{
    private MemberService memberService;

}
