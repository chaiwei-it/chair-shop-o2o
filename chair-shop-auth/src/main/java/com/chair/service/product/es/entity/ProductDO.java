package com.chair.service.product.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "product", shards = 30, replicas = 0)
public class ProductDO {

    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String productName;

    @Field(type = FieldType.Keyword)
    private String productCode;

    @Field(type = FieldType.Nested)
    private List<GoodsDO> goods;

    @Field(type = FieldType.Double)
    private Double price;


}
