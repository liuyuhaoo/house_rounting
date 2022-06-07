package com.example.microserviceeurekatalk.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="聊天")
public class TalkVO {
    @TableField("context")
    @ApiModelProperty(value="内容")
    private String context;
    @TableField("name")
    @ApiModelProperty(value="作者")
    private String name;
    @TableField("time")
    @ApiModelProperty(value="时间")
    private String time;
    public TalkVO(){
    }

}
