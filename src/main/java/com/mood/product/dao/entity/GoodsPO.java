package com.mood.product.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "char_content")
public class GoodsPO implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;

    private String title;

    private String content;

    private Date createTime;




}
