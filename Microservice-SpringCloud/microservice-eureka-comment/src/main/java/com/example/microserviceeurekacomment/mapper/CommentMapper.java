package com.example.microserviceeurekacomment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.microserviceeurekacomment.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
