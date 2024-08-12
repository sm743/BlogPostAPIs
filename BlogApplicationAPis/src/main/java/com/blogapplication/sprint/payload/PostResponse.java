package com.blogapplication.sprint.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostResponse {
    private List<postdto> postdtoList;
    private int pageNo;
    private int pagesize;
    private long totalElements;
    private long tatalpages;
    private boolean islast;


}
