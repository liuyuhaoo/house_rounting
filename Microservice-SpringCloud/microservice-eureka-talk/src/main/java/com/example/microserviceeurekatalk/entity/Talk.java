package com.example.microserviceeurekatalk.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="聊天")
public class Talk {
    @TableId
    @ApiModelProperty(value="主键")
    private String id;
    @TableField("postId")
    @ApiModelProperty(value="发送人id")
    private String postId;
    @TableField("getId")
    @ApiModelProperty(value="接收id")
    private String getId;
    @TableField("context")
    @ApiModelProperty(value="内容")
    private String context;
    @TableField("time")
    @ApiModelProperty(value="时间")
    private Date time;
    public Talk(){
    }
    public Talk(String getId, String postId){
        this.getId = getId;
        this.postId = postId;
    }
    public Talk(String getId, String postId, String context){
        this.getId = getId;
        this.postId = postId;
        this.context = context;
    }

}
