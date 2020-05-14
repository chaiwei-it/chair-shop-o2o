package com.mood.comment.dao;

import com.mood.comment.dao.entity.ContentPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface ContentDAO extends JpaRepository<ContentPO,Integer> {

}
