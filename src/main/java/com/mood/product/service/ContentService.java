package com.mood.product.service;


import com.mood.base.BaseVO;
import com.mood.product.dao.entity.ProductPO;
import com.mood.product.service.command.ContentCreateCommand;

public interface ContentService{

    ProductPO add(ProductPO contentPO);

    ProductPO update(ContentCreateCommand contentCreateCommand);

    ProductPO get(int id);

    BaseVO findAll();

    void delete(int id);


}
