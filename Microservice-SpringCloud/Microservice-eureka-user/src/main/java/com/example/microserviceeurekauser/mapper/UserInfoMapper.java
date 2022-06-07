package com.example.microserviceeurekauser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.microserviceeurekauser.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
