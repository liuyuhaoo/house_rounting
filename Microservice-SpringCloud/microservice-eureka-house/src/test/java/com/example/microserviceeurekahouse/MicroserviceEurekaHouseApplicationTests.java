package com.example.microserviceeurekahouse;

import com.example.microserviceeurekahouse.controller.HouseInfoController;
import com.example.microserviceeurekahouse.entity.HouseInfo;
import com.example.microserviceeurekahouse.entity.HouseInfoVO;
import com.example.microserviceeurekahouse.mapper.HouseInfoMapper;
import com.example.microserviceeurekahouse.vo.HouseInfoQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroserviceEurekaHouseApplicationTests {
    @Autowired
    HouseInfoController houseInfoController;
    @Test
    void contextLoads() {
    }
    HouseInfoVO houseInfoVO = new HouseInfoVO("66", "测试租房", "测试地点", 300.00, "1", "admin", 0);
    @Test
    void Ccreate(){
        houseInfoController.create(houseInfoVO);
        System.out.println(houseInfoVO);
    }
    @Test
    void Dupdate(){
        houseInfoVO.setTitle("更新标题之后");
        houseInfoController.update(new HouseInfo(houseInfoVO));
        //查询
        System.out.println(houseInfoController.query(houseInfoVO.getHouseId()).getData().toString());
    }
    @Test
    void Adetele(){
        houseInfoController.deleteById(houseInfoVO.getHouseId());
        if(houseInfoController.query(houseInfoVO.getHouseId()).getData()==null){
            System.out.println("删除成功");
        }
    }
    @Test
    void Blist() throws InterruptedException {
        System.out.println(houseInfoController.list("","").getData().toString());
    }
}

