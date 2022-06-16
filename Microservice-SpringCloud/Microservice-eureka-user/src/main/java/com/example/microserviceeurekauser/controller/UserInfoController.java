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
                           @RequestParam(value="type",defaultValue = "0",required = false) int type){
        Result result = new Result(null);
       /*if(name.length() < 1 || password.length() < 1){
            result.setMsg("输入不能为空");
            return result;
        }*/
        //用户名限制
        if(!name.matches("[a-zA-Z0-9_]{6,9}")){
            result.setMsg("用户名长度必须位6~9个字符，并且只能由英文、数字、下划线组成！");
            return result;
        }
        //密码限制
        if(password.contains(" ") || !password.matches("[a-zA-Z0-9\\W]{6,15}")){
            result.setMsg("密码必须在6~15个字符内，由英文、数字、特殊符号(除了空格符号外)组成！");
            return result;
        }
        //用户类型限制
        if(type != 1 && type != 2){
            result.setMsg("请选择注册的类型！");
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
            result.setMsg("输入不能为空！");
            return result;
         }

        if(!userInfoVO.getIdcard().matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$")){
            result.setMsg("你输入的身份证号码有误！");
            return result;
        }

        if(!userInfoVO.getPhone().matches("^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\\d{8}$")){
            result.setMsg("你输入的手机号有误！");
            return result;
        }
        if(!userInfoVO.getEmail().matches("[1-9][0-9]{4,}@qq.com")){
            result.setMsg("你输入的E-mail有误！");
            return result;
        }
        if(!userInfoVO.getRealName().matches("^[\\u4e00-\\u9fa5]{2,16}$")){
            result.setMsg("你输入的真是姓名有误！");
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
        if(oldPassword.contains(" ") || !oldPassword.matches("[a-zA-Z0-9\\W]{6,15}")){
            result.setMsg("密码必须在6~15个字符内，由英文、数字、特殊符号(除了空格符号外)组成！");
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
