package com.example.microserviceeurekahouse.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="租房信息VO")
public class HouseInfoVO {
    @TableId
    @ApiModelProperty(value="主键")
    private String houseId;
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
    @TableField("userId")
    @ApiModelProperty(value="用户id")
    private String userId;
    @TableField("name")
    @ApiModelProperty(value="用户账号")
    private String name;
    @TableField("sale")
    @ApiModelProperty(value="销量")
    private int sale;
    @TableField("status")
    @ApiModelProperty(value="审核状态")
    private int status;
    public HouseInfoVO(){
    }
    public HouseInfoVO(String houseId, String title, String address, Double price, String userId, String name, int sale, int status){
        this.houseId = houseId;
        this.title = title;
        this.address = address;
        this.price = price;
        this.time = new Date();
        this.userId = userId;
        this.name = name;
        this.sale = sale;
        this.status = status;
    }


}
