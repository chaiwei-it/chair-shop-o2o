package com.mood.service.product.service;


import com.mood.base.BaseVO;
import com.mood.service.product.dao.entity.ProductPO;
import com.mood.service.product.service.command.ContentCreateCommand;

public interface ContentService{

    ProductPO add(ProductPO contentPO);

    ProductPO update(ContentCreateCommand contentCreateCommand);

    ProductPO get(int id);

    BaseVO findAll();

    void delete(int id);


}
