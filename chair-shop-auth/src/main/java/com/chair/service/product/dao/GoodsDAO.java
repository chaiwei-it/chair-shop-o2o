package com.chair.service.product.dao;

import com.chair.service.product.dao.entity.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface GoodsDAO extends JpaRepository<ProductPO,Integer> {

}
