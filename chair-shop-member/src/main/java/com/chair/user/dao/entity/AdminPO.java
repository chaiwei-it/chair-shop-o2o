package com.chair.user.dao.entity;

import com.mood.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-06-04 下午16:00
 */
@Data
@Entity
@Table(name="rebate_admin")
public class AdminPO extends BaseEntity {

    @Id
    private String id;

    /**
     * 名称
     */
    private String username;

    /**
     * 名称
     */
    private String password;

    /**
     * 用户头像
     */
    private String headImage;

    /**
     * 盐值
     */
    private String salt;


}