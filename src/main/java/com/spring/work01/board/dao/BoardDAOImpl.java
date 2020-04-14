package com.spring.work01.board.dao;

import com.spring.work01.board.vo.ArticleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<ArticleVO> selectAllArticles() {
        return sqlSession.selectList("mapper.board.selectAllArticles");
    }

    @Override
    public int insertArticle(Map<String, Object> articleMap) {
        int nextRef = sqlSession.selectOne("mapper.board.selectRef");
        articleMap.put("ref", nextRef);
        int status = sqlSession.insert("mapper.board.insertArticle", articleMap);
        return nextRef;
    }

    @Override
    public ArticleVO selectArticle(int articleNO) {
        return sqlSession.selectOne("mapper.board.selectArticle", articleNO);
    }
}
