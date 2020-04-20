package com.spring.work01.board.service;

import com.spring.work01.board.vo.ArticleVO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    List<ArticleVO> listArticles();
    int addArticle(Map<String, Object> articleMap);
    ArticleVO viewArticle(int articleNO);
    void modArticle(ArticleVO vo);
    void delArticle(int articleNO);
}
