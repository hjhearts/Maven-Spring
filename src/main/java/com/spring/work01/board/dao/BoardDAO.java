package com.spring.work01.board.dao;

import com.spring.work01.board.vo.ArticleVO;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
    List<ArticleVO> selectAllArticles();
    int insertArticle(Map<String, Object> articleMap);
    ArticleVO selectArticle(int articleNO);
    void updateArticle(ArticleVO vo);
    void deleteArticle(int articleNO);
    void insertImage(Map<String, Object> articleMap);
}
