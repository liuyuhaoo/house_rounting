package com.example.microserviceeurekauser;

import com.example.microserviceeurekauser.controller.UserInfoController;
import com.example.microserviceeurekauser.entity.UserInfo;
import com.example.microserviceeurekauser.mapper.UserInfoMapper;
import com.example.microserviceeurekauser.vo.UserInfoVO;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import java.util.List;

@SpringBootTest
class MicroserviceEurekaUserApplicationTests {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoController userInfoController;
    @Test
    void contextLoads() {
        List<UserInfo> userList = userInfoMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    void login() {
        System.out.println(userInfoController.login("admin", "123").getMsg());
        System.out.println(userInfoController.login("不存在的用户名", "123456").getMsg());
        System.out.println(userInfoController.login("admin", "密码错误").getMsg());
    }
    @Test
    void register() {
        System.out.println(userInfoController.register("admin", "123",1).getMsg());
        System.out.println(userInfoController.register("liuyuhao","123456",2).getMsg());
    }
    @Test
    void info() {
        UserInfo userInfo = new UserInfo();
        System.out.println(userInfoController.query("1").getData());
    }
    @Test
    void update() {
        UserInfoVO userInfoVO = (UserInfoVO) userInfoController.query("3").getData();
        System.out.println(userInfoVO);
        userInfoVO.setName("修改后");
        userInfoController.update(userInfoVO);
        System.out.println(userInfoController.query("3").getData());
        userInfoVO.setName("lyh");
        userInfoController.update(userInfoVO);
    }
}
