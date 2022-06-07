package com.example.microserviceeurekatalk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.microserviceeurekatalk.entity.Talk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TalkMapper extends BaseMapper<Talk> {
    List<Talk> queryTalk(Talk talk);
}
