package com.spring.work01.member.service;

import com.spring.work01.member.vo.MemberVO;

import java.util.List;

public interface MemberService {
    public List<MemberVO> listMembers();
    public int addMember(MemberVO memberVO);
    MemberVO login(MemberVO loginVO);
}
