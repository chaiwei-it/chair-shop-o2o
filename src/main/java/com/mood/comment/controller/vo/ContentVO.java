package com.mood.comment.controller.vo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class ContentVO {

    private int id;

    private String title;

    private String content;

    private String createTime;




}
