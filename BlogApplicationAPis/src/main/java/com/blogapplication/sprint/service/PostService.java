package com.blogapplication.sprint.service;
import com.blogapplication.sprint.payload.PostResponse;
import com.blogapplication.sprint.payload.postdto;

import java.util.List;

public interface PostService {
    postdto createpost(postdto postdto);
    PostResponse getallPosts(int pageNo, int pagesize,String sortby,String sortdir );
    postdto getpostbyId(long id);
    postdto updatepostbyId(postdto postdto,Long id);
    String deletepostbyId(long id);
}
