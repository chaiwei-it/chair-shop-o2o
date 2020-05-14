package com.mood.comment.service.command;

import lombok.Data;

@Data
public class ContentCreateCommand {

    private int id;

    private String title;

    private String content;

}
