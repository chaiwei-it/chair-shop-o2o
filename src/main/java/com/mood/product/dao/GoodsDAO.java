package com.mood.product.dao;

import com.mood.product.dao.entity.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface GoodsDAO extends JpaRepository<ProductPO,Integer> {

}
