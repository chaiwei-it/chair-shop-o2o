package com.chair.service.product.es;

import com.mood.service.product.dao.entity.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface ProductESDAO extends JpaRepository<ProductPO,Integer> {

}
