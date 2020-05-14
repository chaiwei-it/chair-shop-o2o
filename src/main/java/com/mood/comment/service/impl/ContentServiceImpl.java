package com.mood.comment.service.impl;

import com.mood.base.BaseVO;
import com.mood.base.Result;
import com.mood.base.StateCode;
import com.mood.comment.controller.vo.ContentVO;
import com.mood.comment.dao.ContentDAO;
import com.mood.comment.dao.entity.ContentPO;
import com.mood.comment.service.ContentService;
import com.mood.comment.service.command.ContentCreateCommand;
import com.mood.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author chaiwei
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDAO contentDAO;


    @Override
    public ContentPO add(ContentPO contentPO) {
        contentPO.setCreateTime(new Date());
        return contentDAO.save(contentPO);
    }

    @Override
    public ContentPO update(ContentCreateCommand contentCreateCommand) {
        ContentPO contentPO = contentDAO.findOne(contentCreateCommand.getId());
        BeanUtils.copyProperties(contentCreateCommand, contentPO);
        return contentDAO.save(contentPO);
    }

    @Override
    public ContentPO get(int id) {
        return contentDAO.findOne(id);
    }

    @Override
    public BaseVO findAll() {
        List<ContentPO> contentPOList = contentDAO.findAll();
        List<ContentVO> contentVOList = new ArrayList<>();
        contentPOList.forEach(contentPO -> contentVOList.add(copy(contentPO)));
        return Result.Result(contentVOList);
    }

    @Override
    public void delete(int id) {
        contentDAO.delete(id);
    }

    private ContentVO copy(ContentPO contentPO){
        ContentVO contentVO = new ContentVO();
        BeanUtils.copyProperties(contentPO, contentVO);
        contentVO.setCreateTime(DateUtil.convertDateToString(contentPO.getCreateTime()));
        return contentVO;
    }
}
