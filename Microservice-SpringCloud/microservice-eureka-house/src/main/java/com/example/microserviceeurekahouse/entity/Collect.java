package com.example.microserviceeurekahouse.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="租房信息")
public class Collect {
        @TableId
        @ApiModelProperty(value="主键")
        private String id;
        @TableField("userId")
        @ApiModelProperty(value="用户id")
        private String userId;
        @TableField("houseId")
        @ApiModelProperty(value="房屋id")
        private String houseId;
        public Collect(){
        }
        public Collect(String userId, String houseId){
                this.userId = userId;
                this.houseId = houseId;
        }


}
