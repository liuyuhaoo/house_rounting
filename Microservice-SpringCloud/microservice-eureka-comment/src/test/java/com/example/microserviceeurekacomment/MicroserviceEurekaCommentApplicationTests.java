package com.example.microserviceeurekacomment;

import com.example.microserviceeurekacomment.controller.CommentController;
import com.example.microserviceeurekacomment.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MicroserviceEurekaCommentApplicationTests {
    @Autowired
    CommentController commentController;
    @Test
    void contextLoads() {
    }
    Comment comment = new Comment("66", "admin", "1", "测试评论");
    @Test
    void Ccreate(){
        commentController.create(comment);
        System.out.println(comment);
    }
    @Test
    void Dupdate(){
        comment.setContext("更新评论之后");
        commentController.update(comment);
        //查询
        System.out.println(commentController.query(comment.getId()).getData().toString());
    }
    @Test
    void Adetele(){
        commentController.deleteById(comment.getId());
        if(commentController.query(comment.getId()).getData()==null){
            System.out.println("删除成功");
        }
    }
    @Test
    void Blist(){
        System.out.println(commentController.list("1").getData().toString());
    }
}
