package com.example.microserviceeurekauser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.microserviceeurekauser.entity.Result;
import com.example.microserviceeurekauser.entity.UserInfo;
import com.example.microserviceeurekauser.mapper.UserInfoMapper;
import com.example.microserviceeurekauser.vo.UserInfoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class UserInfoController {
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @ApiOperation(value="用户登录", notes="用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result login(@RequestParam String name,
                        @RequestParam String password){
        Result result = new Result(null);
        if(name.length() < 1 || password.length() < 1){
            result.setMsg("输入不能为空");
            return result;
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", name);
        UserInfo userInfoTrue = userInfoMapper.selectOne(queryWrapper);
        if(userInfoTrue == null){
            result.setMsg("用户名不存在");
            return result;
        }
        UserInfoVO userInfoVO = new UserInfoVO(userInfoTrue);
        if(userInfoTrue.getPassword().equals(password)){
            result.setData(userInfoVO);
            result.setMsg("登录成功");
            return result;
        }
        else{
            result.setMsg("密码错误");
            return result;
        }
    }

    /**
     * 注册
     * @param name
     * @param password
     * @return
     */
    @ApiOperation(value="用户注册", notes="用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestParam String name,
                           @RequestParam String password,
                           @RequestParam int type){
        Result result = new Result(null);
        if(name.length() < 1 || password.length() < 1){
            result.setMsg("输入不能为空");
            return result;
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", name);
        UserInfo userInfoTrue = userInfoMapper.selectOne(queryWrapper);
        if(userInfoTrue != null){
            result.setMsg("用户名已存在");
            return result;
        }
        UserInfo userInfo = new UserInfo(name, password, type);
        userInfoMapper.insert(userInfo);
        UserInfoVO userInfoVO = new UserInfoVO(userInfo);
        result.setMsg("注册成功");
        result.setData(userInfoVO);
        return result;
    }

    /**
     * 查看用户信息
     * @param id
     * @return
     */
    @ApiOperation(value="查看用户信息", notes="查看用户信息")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result query(@RequestParam String id){
        UserInfo userInfo = userInfoMapper.selectById(id);
        UserInfoVO userInfoVO = new UserInfoVO(userInfo);
        return new Result(userInfoVO);
    }

    /**
     * 更新用户信息
     * @param userInfoVO
     * @return
     */
    @ApiOperation(value="更新用户信息", notes="更新用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody UserInfoVO userInfoVO){
        Result result = new Result(null);
        if(userInfoVO.getName().length() < 1 || userInfoVO.getEmail().length() < 1 || userInfoVO.getIdcard().length() < 1 || userInfoVO.getRealName().length() < 1 ||
         userInfoVO.getPhone().length() < 1){
            result.setMsg("输入不能为空");
            return result;
         }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", userInfoVO.getName());
        List<UserInfo> userInfoTrue = userInfoMapper.selectList(queryWrapper);
        if(userInfoTrue.size() > 1){
            result.setMsg("用户名已存在");
            return result;
        }
         UserInfo userInfo = new UserInfo(userInfoVO);
         userInfo.setPassword(userInfoMapper.selectById(userInfoVO.getId()).getPassword());
         userInfoMapper.updateById(userInfo);
         result.setMsg("修改成功");
         result.setData(userInfoVO);
         return result;
    }

    /**
     * 更新用户密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @ApiOperation(value="更新用户密码", notes="更新用户密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    public Result updatePassword(@RequestParam String id,
                                 @RequestParam String oldPassword,
                                 @RequestParam String newPassword){
        Result result = new Result(null);
        if(oldPassword.length() < 1 || newPassword.length() < 1) {
            result.setMsg("输入不能为空");
            return result;
        }
        UserInfo userInfoTrue = userInfoMapper.selectById(id);
        if(userInfoTrue.getPassword().equals(oldPassword)) {
            userInfoTrue.setPassword(newPassword);
            userInfoMapper.updateById(userInfoTrue);
            result.setMsg("修改成功，即将返回登录页面");
            return result;
        }
        else {
            result.setMsg("原密码输入错误");
            return result;
        }

    }
    /**
     * 获取所有用户信息
     * 获取所有用户信息
     * @return
     */
    @ApiOperation(value="获取所有用户信息", notes="获取所有用户信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(){
        List<UserInfo> list = userInfoMapper.selectList(null);
        return new Result(list);
    }

}
