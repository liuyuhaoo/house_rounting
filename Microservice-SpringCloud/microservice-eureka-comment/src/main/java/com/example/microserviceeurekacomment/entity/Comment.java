package com.example.microserviceeurekacomment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="租房信息")
public class Comment {
    @TableId
    @ApiModelProperty(value="主键")
    private String id;
    @TableField("userName")
    @ApiModelProperty(value="用户名")
    private String userName;
    @TableField("houseId")
    @ApiModelProperty(value="房源id")
    private String houseId;
    @TableField("context")
    @ApiModelProperty(value="内容")
    private String context;
    @TableField("time")
    @ApiModelProperty(value="评论时间")
    private Date time;

    public Comment(){
    }
    public Comment(String id,String userName, String houseId, String context){
        this.id = id;
        this.userName = userName;
        this.houseId = houseId;
        this.context = context;
        this.time = new Date();
    }


}
