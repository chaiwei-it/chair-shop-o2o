package com.mood.user.dao;

import com.mood.user.dao.entity.AdminPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
@Component
public interface AdminDao extends JpaRepository<AdminPO,Integer> {

}
