package com.example.microserviceeurekauserhouserelation.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value="用户和租房关系")
public class UserHouseRelation {
    @TableId
    @ApiModelProperty(value="主键")
    private String id;
    @TableField("userId")
    @ApiModelProperty(value="用户id")
    private String userId;
    @TableField("houseId")
    @ApiModelProperty(value="租房id")
    private String houseId;


    public UserHouseRelation(){
    }
    public UserHouseRelation(String userId, String houseId){
        this.userId = userId;
        this.houseId = houseId;
    }


}
