package com.chair.service.product.service;


import com.chair.base.BaseVO;
import com.chair.service.product.dao.entity.ProductPO;
import com.chair.service.product.service.command.ContentCreateCommand;

public interface ContentService{

    ProductPO add(ProductPO contentPO);

    ProductPO update(ContentCreateCommand contentCreateCommand);

    ProductPO get(int id);

    BaseVO findAll();

    void delete(int id);


}
