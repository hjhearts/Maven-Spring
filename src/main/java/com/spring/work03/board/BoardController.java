package com.spring.work03.board;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {
    static Logger logger = Logger.getLogger(BoardController.class);

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ArticleVO>> listArticles(){
        logger.info("listArticles 호출");
        List<ArticleVO> articleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArticleVO vo = new ArticleVO();
            vo.setArticleNO(i);
            vo.setWriter("Writer"+i);
            vo.setTitle("Title"+i);
            vo.setContent("Content"+i);
            articleList.add(vo);
        }
        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{articleNO}", method = RequestMethod.GET)
    public ResponseEntity<ArticleVO> findArticle(@PathVariable("articleNO") Integer articleNO){
        logger.info("findArticle 호출");
        ArticleVO vo = new ArticleVO();
        vo.setArticleNO(articleNO);
        vo.setWriter("Find Writer");
        vo.setTitle("Find Title");
        vo.setContent("Find Content");
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> addArticle(@RequestBody ArticleVO articleVO){
        ResponseEntity<String> resEntity;
        try {
            logger.info("addArticle 호출");
            logger.info(articleVO.toString());
            resEntity = new ResponseEntity<>("ADD_SUCCESS", HttpStatus.OK);
        }catch(Exception e){
            resEntity = new ResponseEntity<>("ADD_FAIL", HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }

    @RequestMapping(value = "/{articleNO}", method = RequestMethod.PUT)
    public ResponseEntity<String> modArticle(@PathVariable("articleNO") Integer articleNO,
                                             @RequestBody ArticleVO articleVO){
        ResponseEntity<String> resEntity;
        try{
            logger.info("modArticle 호출");
            logger.info(articleVO.toString());
            resEntity = new ResponseEntity<>("MOD_SUCCESS", HttpStatus.OK);
        }catch (Exception e){
            resEntity = new ResponseEntity<>("MOD_FAIL", HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }

    @RequestMapping(value = "/{articleNO}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeArticle(@PathVariable("articleNO") Integer articleNO){
        ResponseEntity<String> resEntity;
        try{
            logger.info("deleteArticle 호출");
            resEntity = new ResponseEntity<>("DELETE_SUCCESS", HttpStatus.OK);
        }catch(Exception e){
            resEntity = new ResponseEntity<>("DELETE_FAIL", HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }
}
