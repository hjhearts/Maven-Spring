package com.spring.work01.board.vo;

import org.springframework.stereotype.Component;

import java.sql.Date;
@Component("articleVO")
public class ArticleVO {
    private int articleNO;
    private String title;
    private String content;
    private int pos;
    private int ref;
    private int depth;
    private Date writeDate;
    private String id;
    private String imageFileName;

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public int getArticleNO() {
        return articleNO;
    }

    public void setArticleNO(int articleNO) {
        this.articleNO = articleNO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
