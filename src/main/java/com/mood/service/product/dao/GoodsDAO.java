package com.mood.service.product.dao;

import com.mood.service.product.dao.entity.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface GoodsDAO extends JpaRepository<ProductPO,Integer> {

}
