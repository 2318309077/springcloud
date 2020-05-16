package com.ceway.shardingjdbc.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/8 2:52 下午
 */
@Data
public class User {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;

}
