package com.example.microserviceeurekahouse.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="租房信息查询VO")
public class HouseInfoQueryVO {
    @TableId
    @ApiModelProperty(value="主键")
    private String userId;
    @TableField("orderBy")
    @ApiModelProperty(value="排序")
    private String orderBy;
    @TableField("keyword")
    @ApiModelProperty(value="关键字")
    private String keyword;
    @TableField("status")
    @ApiModelProperty(value="审核状态")
    private int status;

    public HouseInfoQueryVO(){
    }

    public HouseInfoQueryVO(String userId, String orderBy, String keyword, int status){
        this.userId = userId;
        this.keyword = keyword;
        this.orderBy = orderBy;
        this.status = status;
    }

}
