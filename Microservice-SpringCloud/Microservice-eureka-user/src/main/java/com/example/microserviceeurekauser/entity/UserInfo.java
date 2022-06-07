package com.example.microserviceeurekauser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.microserviceeurekauser.vo.UserInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="用户信息")
public class UserInfo {
    @TableId
    @ApiModelProperty(value="主键")
    private String id;
    @TableField("name")
    @ApiModelProperty(value="账号")
    private String name;
    @TableField("password")
    @ApiModelProperty(value="密码")
    private String password;
    @TableField("idcard")
    @ApiModelProperty(value="身份证")
    private String idcard;
    @TableField("phone")
    @ApiModelProperty(value="手机号")
    private String phone;
    @TableField("email")
    @ApiModelProperty(value="邮箱")
    private String email;
    @TableField("realName")
    @ApiModelProperty(value="姓名")
    private String realName;
    @TableField("time")
    @ApiModelProperty(value="创建时间")
    private Date time;

    public UserInfo(){
    }
    public UserInfo(String name,String password){
        this.name = name;
        this.password = password;
        this.time = new Date();
    }
    public UserInfo(UserInfoVO userInfoVO){
        this.id = userInfoVO.getId();
        this.name = userInfoVO.getName();
        this.idcard = userInfoVO.getIdcard();
        this.phone = userInfoVO.getPhone();
        this.email = userInfoVO.getEmail();
        this.realName = userInfoVO.getRealName();
    }

}
