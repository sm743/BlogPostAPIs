package com.blogapplication.sprint.service;

import com.blogapplication.sprint.payload.commentdto;
import lombok.extern.java.Log;

import java.util.List;

public interface CommentService {
    commentdto createcomment(Long post_id, commentdto commentdto);
    List<commentdto> getallcomments(Long post_id);
    commentdto getcommentbyId(Long post_id, Long id);
    commentdto updatecommentbyId(Long post_id, Long id,commentdto commentdto);
    String deletecomment(Long post_id, Long id,commentdto commentdto);

}
