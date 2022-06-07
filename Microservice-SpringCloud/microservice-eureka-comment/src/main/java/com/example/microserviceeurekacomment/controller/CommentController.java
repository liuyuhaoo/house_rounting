package com.example.microserviceeurekacomment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.microserviceeurekacomment.entity.Comment;
import com.example.microserviceeurekacomment.entity.Result;
import com.example.microserviceeurekacomment.mapper.CommentMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class CommentController {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @ApiOperation(value="创建评论", notes="创建评论")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody Comment comment){
        Result result = new Result(null);
        if(comment.getHouseId().length() < 1 || comment.getUserName().length() < 1
        || comment.getContext().length() < 1){
            result.setMsg("输入不能为空");
            return result;
        }
        comment.setTime(new Date());
        commentMapper.insert(comment);
        result.setMsg("创建成功");
        return result;
    }

    /**
     * 查看评论
     * @param id
     * @return
     */
    @ApiOperation(value="查看评论", notes="查看评论")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result query(@RequestParam String id){
        Comment comment = commentMapper.selectById(id);
        return new Result(comment);
    }

    /**
     * 更新评论
     * @param comment
     * @return
     */
    @ApiOperation(value="更新租房信息", notes="更新租房信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Comment comment){
        commentMapper.updateById(comment);
        return new Result("修改成功");
    }

    /**
     * 删除租房信息
     * @param id
     * @return
     */
    @ApiOperation(value="查看租房信息", notes="查看租房信息")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteById(@RequestParam String id){
        commentMapper.deleteById(id);
        return new Result("删除成功");
    }

    /**
     * 获取所有租房信息
     * @return
     */
    @ApiOperation(value="获取所有租房信息", notes="获取所有租房信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(String houseId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("houseId", houseId);
        List<Comment> list = commentMapper.selectList(queryWrapper);
        return new Result(list);
    }

}
