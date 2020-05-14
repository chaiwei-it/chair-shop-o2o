package com.mood.comment.service;


import com.mood.base.BaseVO;
import com.mood.comment.controller.vo.ContentVO;
import com.mood.comment.dao.entity.ContentPO;
import com.mood.comment.service.command.ContentCreateCommand;

import java.util.List;

public interface ContentService{

    ContentPO add(ContentPO contentPO);

    ContentPO update(ContentCreateCommand contentCreateCommand);

    ContentPO get(int id);

    BaseVO findAll();

    void delete(int id);


}
