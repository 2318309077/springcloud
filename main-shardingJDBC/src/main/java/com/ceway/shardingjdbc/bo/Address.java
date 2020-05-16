package com.ceway.shardingjdbc.bo;

import lombok.Data;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/8 2:59 下午
 */
@Data
public class Address {
    private Long id;
    private String code;
    private String name;
    private String pid;
    private Integer type;
    private Integer lit;
}

