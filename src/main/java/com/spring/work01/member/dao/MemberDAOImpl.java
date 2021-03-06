package com.spring.work01.member.dao;

import com.spring.work01.member.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

    @Override
    public List<MemberVO> selectAllMemberList() {
        return sqlSession.selectList("mapper.member.selectAllMemberList");
    }

    @Override
    public int insertMember(MemberVO memberVO) {
        return sqlSession.insert("mapper.member.insertMember", memberVO);
    }

    @Override
    public MemberVO selectMemberById(MemberVO loginVO) {
        return sqlSession.selectOne("mapper.member.login", loginVO);
    }
}
