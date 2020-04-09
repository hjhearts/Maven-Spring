package com.spring.work01.member.service;

import com.spring.work01.member.dao.MemberDAO;
import com.spring.work01.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    @Qualifier("memberDAO")
    private MemberDAO memberDAO;

    @Override
    public List<MemberVO> listMembers() {
        return memberDAO.selectAllMemberList();
    }

    @Override
    public int addMember(MemberVO memberVO) {
        return memberDAO.insertMember(memberVO);
    }
}
