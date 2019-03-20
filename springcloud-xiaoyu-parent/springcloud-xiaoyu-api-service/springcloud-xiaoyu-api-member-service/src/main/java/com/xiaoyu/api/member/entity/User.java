package com.xiaoyu.api.member.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户实体
 * @author xiaoyu
 */
@Data
@ToString
public class User implements Serializable {

    private Long id;

    private String name;

    private String sex;
}
