package com.example.microserviceeurekahouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.microserviceeurekahouse.entity.HouseInfo;
import com.example.microserviceeurekahouse.vo.HouseInfoQueryVO;
import com.example.microserviceeurekahouse.entity.HouseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseInfoMapper extends BaseMapper<HouseInfo> {
    HouseInfoVO queryHouseInfoVO(String houseId);
    List<HouseInfo> listByUserId(HouseInfoQueryVO houseInfoQueryVO);
    void addSale(String id);
    void pass(String id);
    void unpass(String id);
    List<HouseInfo> listByUserIdCollect(HouseInfoQueryVO houseInfoQueryVO);
}
