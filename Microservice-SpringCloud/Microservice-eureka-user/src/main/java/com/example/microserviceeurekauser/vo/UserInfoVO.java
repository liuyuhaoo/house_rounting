package com.example.microserviceeurekauser.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.microserviceeurekauser.entity.UserInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoVO implements Serializable {
    @TableField("id")
    private String id;
    @TableField("name")
    private String name;
    @TableField("idcard")
    private String idcard;
    @TableField("phone")
    private String phone;
    @TableField("email")
    private String email;
    @TableField("realName")
    private String realName;

    public UserInfoVO(){
    }
    public UserInfoVO(UserInfo userInfo){
        this.id = userInfo.getId();
        this.name = userInfo.getName();
        this.email = userInfo.getEmail();
        this.idcard = userInfo.getIdcard();
        this.phone = userInfo.getPhone();
        this.realName = userInfo.getRealName();
    }
}
