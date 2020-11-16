package com.chair.service.product.service.impl;

import com.chair.base.BaseVO;
import com.chair.base.Result;
import com.chair.service.product.service.vo.ContentVO;
import com.chair.service.product.dao.ProductDAO;
import com.chair.service.product.dao.entity.ProductPO;
import com.chair.service.product.service.ContentService;
import com.chair.service.product.service.command.ContentCreateCommand;
import com.chair.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * @author chaiwei
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ProductDAO productDAO;


    @Override
    public ProductPO add(ProductPO contentPO) {
        contentPO.setCreateTime(new Date());
        return productDAO.save(contentPO);
    }

    @Override
    public ProductPO update(ContentCreateCommand contentCreateCommand) {
        Optional<ProductPO> contentPOOptional = productDAO.findById(contentCreateCommand.getId());
        ProductPO contentPO = contentPOOptional.get();
        BeanUtils.copyProperties(contentCreateCommand, contentPO);
        return productDAO.save(contentPO);
    }

    @Override
    public ProductPO get(int id) {
        Optional<ProductPO> contentPOOptional = productDAO.findById(id);
        ProductPO contentPO = contentPOOptional.get();
        return contentPO;
    }

    @Override
    public BaseVO findAll() {
        List<ProductPO> contentPOList = productDAO.findAll();
        List<ContentVO> contentVOList = new ArrayList<>();
        contentPOList.forEach(contentPO -> contentVOList.add(copy(contentPO)));
        return Result.success(contentVOList);
    }

    @Override
    public void delete(int id) {
        productDAO.deleteById(id);
    }

    private ContentVO copy(ProductPO contentPO){
        ContentVO contentVO = new ContentVO();
        BeanUtils.copyProperties(contentPO, contentVO);
        contentVO.setCreateTime(DateUtil.convertDateToString(contentPO.getCreateTime()));
        return contentVO;
    }
}
