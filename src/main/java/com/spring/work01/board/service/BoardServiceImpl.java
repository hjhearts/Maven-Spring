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
        int articleNO = boardDAO.insertArticle(articleMap);
        articleMap.put("articleNO", articleNO);
        boardDAO.insertImage(articleMap);
        return articleNO;
    }

    @Override
    public ArticleVO viewArticle(int articleNO) {
        return boardDAO.selectArticle(articleNO);
    }

    public void modArticle(ArticleVO vo){
        boardDAO.updateArticle(vo);
    }

    public void delArticle(int articleNO){
        boardDAO.deleteArticle(articleNO);
    }
}
