package com.blogapplication.sprint.payload;

import lombok.Data;

import java.util.Set;

@Data
public class postdto {
    private long id;

    private String title;
    private String description;
    private String content;
    //private Set<commentdto> comments;   Do later
}
