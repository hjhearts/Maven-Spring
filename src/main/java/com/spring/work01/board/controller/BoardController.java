package com.spring.work01.board.controller;

import com.spring.work01.board.vo.ArticleVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardController {
    ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response);
    ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
}
