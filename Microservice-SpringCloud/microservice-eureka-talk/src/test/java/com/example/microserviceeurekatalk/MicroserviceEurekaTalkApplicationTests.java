package com.example.microserviceeurekatalk;

import com.example.microserviceeurekatalk.controller.TalkController;
import com.example.microserviceeurekatalk.entity.Talk;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroserviceEurekaTalkApplicationTests {
    @Autowired
    TalkController talkController;
    @Test
    void contextLoads() {
    }
    Talk talk = new Talk("66","2", "测试",2);
    @Test
    void Ccreate(){
        Talk talk = (Talk) talkController.create("66","2", "测试").getData();
        System.out.println(talkController.query(talk.getId()).getData().toString());
    }
    @Test
    void Dupdate(){
        talk.setId("1530213644498644993");
        talk.setContext("更新之后");
        talkController.update(talk);
        //查询
        System.out.println(talkController.query("1533344708582043649").getData().toString());
    }
    @Test
    void Adetele(){
        talkController.deleteById("1533344708582043649");
        if(talkController.query("1533344708582043649").getData()==null){
            System.out.println("删除成功");
        }
    }
    @Test
    void Blist() throws InterruptedException {
        System.out.println(talkController.list("1","3").getData().toString());
    }

}
