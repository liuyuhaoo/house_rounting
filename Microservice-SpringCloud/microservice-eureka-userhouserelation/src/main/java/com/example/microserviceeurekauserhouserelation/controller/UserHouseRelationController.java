package com.example.microserviceeurekauserhouserelation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.microserviceeurekauser.entity.Result;
import com.example.microserviceeurekauserhouserelation.entity.UserHouseRelation;
import com.example.microserviceeurekauserhouserelation.mapper.UserHouseRelationMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class UserHouseRelationController {
    @Autowired
    UserHouseRelationMapper userHouseRelationMapper;



    /**
     * 创建
     * @param houseId
     * @param userId
     * @return
     */
    @ApiOperation(value="创建关系", notes="创建关系")
    @RequestMapping(value = "/create")
    public void register(@RequestParam("houseId") String houseId,
                           @RequestParam("userId") String userId){
        UserHouseRelation userHouseRelation = new UserHouseRelation(userId,houseId);
        userHouseRelationMapper.insert(userHouseRelation);
    }

    /**
     * 根据用户id和租房id删除
     * @param userId
     * @param houseId
     * @return
     */
    @ApiOperation(value="根据用户id和租房id删除", notes="根据用户id和租房id删除")
    @RequestMapping(value = "/delelte", method = RequestMethod.DELETE)
    public Result delete(@RequestParam String userId,
                         @RequestParam String houseId){
        Result result = new Result(null);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("houseId", houseId);
        userHouseRelationMapper.delete(queryWrapper);
        result.setMsg("删除成功");
        return result;
    }

    /**
     * 根据用户id的所有租房信息
     * @param userId
     * @return
     */
    @ApiOperation(value="根据用户id和租房id删除", notes="根据用户id和租房id删除")
    @RequestMapping(value = "/delelteByUseId", method = RequestMethod.DELETE)
    public Result delelteByUseId(@RequestParam String userId){
        Result result = new Result(null);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", userId);
        userHouseRelationMapper.delete(queryWrapper);
        result.setMsg("删除成功");
        return result;
    }

    /**
     * 获取所有信息
     * @return
     */
    @ApiOperation(value="获取所有用户信息", notes="获取所有用户信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(){
        List<UserHouseRelation> list = userHouseRelationMapper.selectList(null);
        return new Result(list);
    }

}
