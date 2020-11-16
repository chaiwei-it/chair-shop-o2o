package com.chair.service.product.controller.admin;


import com.chair.base.BaseVO;
import com.chair.service.product.controller.param.ContentUpdateParam;
import com.chair.service.product.dao.entity.ProductPO;
import com.chair.service.product.service.ContentService;
import com.chair.service.product.service.command.ContentCreateCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ProductController {

    @Autowired
    private ContentService contentService;

    @PostMapping("")
    public ProductPO add(@RequestBody ProductPO contentPO) {
        return contentService.add(contentPO);
    }

    @PutMapping("/{id}")
    public ProductPO update(@PathVariable(value = "id", required = false) int id,
                            @RequestBody ContentUpdateParam contentUpdateParam) {
        ContentCreateCommand contentCreateCommand = new ContentCreateCommand();
        BeanUtils.copyProperties(contentUpdateParam, contentCreateCommand);
        contentCreateCommand.setId(id);
        return contentService.update(contentCreateCommand);
    }

    @GetMapping("/{id}")
    public ProductPO get(@PathVariable(value = "id", required = false) int id) {
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
