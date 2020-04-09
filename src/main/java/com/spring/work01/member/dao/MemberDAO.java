package com.spring.work01.member.dao;

import com.spring.work01.member.vo.MemberVO;

import java.util.List;

public interface MemberDAO {
    public List<MemberVO> selectAllMemberList();
}
