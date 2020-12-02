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
    public ProductPO add(ProductPO contentPo) {
        contentPo.setCreateTime(new Date());
        return productDAO.save(contentPo);
    }

    @Override
    public ProductPO update(ContentCreateCommand contentCreateCommand) {
        Optional<ProductPO> contentPoOptional = productDAO.findById(contentCreateCommand.getId());
        ProductPO contentPo = contentPoOptional.get();
        BeanUtils.copyProperties(contentCreateCommand, contentPo);
        return productDAO.save(contentPo);
    }

    @Override
    public ProductPO get(int id) {
        Optional<ProductPO> contentPoOptional = productDAO.findById(id);
        ProductPO contentPo = contentPoOptional.get();
        return contentPo;
    }

    @Override
    public BaseVO findAll() {
        List<ProductPO> contentPoList = productDAO.findAll();
        List<ContentVO> contentVOList = new ArrayList<>();
        contentPoList.forEach(contentPo -> contentVOList.add(copy(contentPo)));
        return Result.success(contentVOList);
    }

    @Override
    public void delete(int id) {
        productDAO.deleteById(id);
    }

    private ContentVO copy(ProductPO contentPo){
        ContentVO contentVO = new ContentVO();
        BeanUtils.copyProperties(contentPo, contentVO);
        contentVO.setCreateTime(DateUtil.convertDateToString(contentPo.getCreateTime()));
        return contentVO;
    }
}
