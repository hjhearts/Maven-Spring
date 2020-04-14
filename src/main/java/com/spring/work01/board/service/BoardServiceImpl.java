package com.spring.work01.board.service;

import com.spring.work01.board.dao.BoardDAO;
import com.spring.work01.board.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO boardDAO;
    @Override
    public List<ArticleVO> listArticles() {
        return boardDAO.selectAllArticles();
    }

    @Override
    public int addArticle(Map<String, Object> articleMap) {
        return boardDAO.insertArticle(articleMap);
    }

    @Override
    public ArticleVO viewArticle(int articleNO) {
        return boardDAO.selectArticle(articleNO);
    }
}
