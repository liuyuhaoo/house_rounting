package com.example.microserviceeurekatalk.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
    @TableField("type")
    private int type;

    public UserInfoVO(){
    }

}
