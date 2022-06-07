package com.example.microserviceeurekatalk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.microserviceeurekatalk.entity.Result;
import com.example.microserviceeurekatalk.entity.Talk;
import com.example.microserviceeurekatalk.mapper.TalkMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class TalkController {
    @Autowired
    TalkMapper talkMapper;

    /**
     * 新增聊天
     * @param getId
     * @param postId
     * @param context
     * @return
     */
    @ApiOperation(value="创建聊天", notes="创建聊天")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestParam String getId,
                           @RequestParam String postId,
                           @RequestParam String context){
        if(context.length() < 1 || getId.length() < 1
                || postId.length() < 1){
            return new Result("输入不能为空") ;
        }
        Talk talk = new Talk(getId, postId, context);
        talk.setTime(new Date());
        talkMapper.insert(talk);
        Result result = new Result(talk);
        result.setMsg("创建成功");
        return result;
    }

    /**
     * 查看聊天
     * @param id
     * @return
     */
    @ApiOperation(value="查看聊天", notes="查看聊天")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result query(@RequestParam String id){
        Talk talk = talkMapper.selectById(id);
        return new Result(talk);
    }

    /**
     * 更新聊天
     * @param talk
     * @return
     */
    @ApiOperation(value="更新聊天信息", notes="更新聊天信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Talk talk){
        talkMapper.updateById(talk);
        return new Result("修改成功");
    }

    /**
     * 删除聊天
     * @param id
     * @return
     */
    @ApiOperation(value="删除聊天", notes="删除聊天")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteById(@RequestParam String id){
        talkMapper.deleteById(id);
        return new Result("删除成功");
    }

    /**
     * 获取聊天
     * @return
     */
    @ApiOperation(value="获取聊天", notes="获取聊天")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam String getId,
                       @RequestParam String postId){
        Talk talk = new Talk(getId, postId);
        List<Talk> list = talkMapper.queryTalk(talk);
        return new Result(list);
    }

}
