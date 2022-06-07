package com.example.microserviceeurekahouse.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="租房信息")
public class HouseInfo {
    @TableId
    @ApiModelProperty(value="主键")
    private String id;
    @TableField("title")
    @ApiModelProperty(value="标题")
    private String title;
    @TableField("address")
    @ApiModelProperty(value="地址")
    private String address;
    @TableField("price")
    @ApiModelProperty(value="价格")
    private Double price;
    @TableField("time")
    @ApiModelProperty(value="创建时间")
    private Date time;
    @TableField("sale")
    @ApiModelProperty(value="销量")
    private int sale;
    @TableField("status")
    @ApiModelProperty(value="审核状态")
    private int status;
    public HouseInfo(){
    }
    public HouseInfo(HouseInfoVO houseInfoVO){
        this.title = houseInfoVO.getTitle();
        this.address = houseInfoVO.getAddress();
        this.price = houseInfoVO.getPrice();
        this.time = houseInfoVO.getTime();
        this.id = houseInfoVO.getHouseId();
        this.sale = houseInfoVO.getSale();
        this.status = houseInfoVO.getStatus();
    }
    public HouseInfo(String id, String title, String address, Double price, int sale, int status){
        this.id = id;
        this.title = title;
        this.address = address;
        this.price = price;
        this.time = new Date();
        this.sale = sale;
        this.status = status;
    }

}
