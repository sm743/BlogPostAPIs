package com.blogapplication.sprint.payload;

import lombok.Data;

@Data
public class commentdto {
    private long id;

    private String name;
    private String email;
    private String body;


}
