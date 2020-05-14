package com.mood.comment.controller;


import com.mood.base.BaseVO;
import com.mood.comment.controller.param.ContentUpdateParam;
import com.mood.comment.controller.vo.ContentVO;
import com.mood.comment.dao.entity.ContentPO;
import com.mood.comment.service.ContentService;
import com.mood.comment.service.command.ContentCreateCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("")
    public ContentPO add(@RequestBody ContentPO contentPO) {
        return contentService.add(contentPO);
    }

    @PutMapping("/{id}")
    public ContentPO update(@PathVariable(value = "id", required = false) int id,
                            @RequestBody ContentUpdateParam contentUpdateParam) {
        ContentCreateCommand contentCreateCommand = new ContentCreateCommand();
        BeanUtils.copyProperties(contentUpdateParam, contentCreateCommand);
        contentCreateCommand.setId(id);
        return contentService.update(contentCreateCommand);
    }

    @GetMapping("/{id}")
    public ContentPO get(@PathVariable(value = "id", required = false) int id) {
        return contentService.get(id);
    }

    @GetMapping("")
    public BaseVO list() {
        return contentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id", required = false) int id) {
         contentService.delete(id);
    }

}
