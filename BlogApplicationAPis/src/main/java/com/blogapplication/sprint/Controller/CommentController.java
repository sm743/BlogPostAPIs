package com.blogapplication.sprint.Controller;

import com.blogapplication.sprint.payload.commentdto;
import com.blogapplication.sprint.payload.postdto;
import com.blogapplication.sprint.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")

public class CommentController {
private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{post_id}/comments")
    public ResponseEntity<commentdto> createposts(@PathVariable(value = "post_id") long post_id, @RequestBody commentdto commentdto){
        return new ResponseEntity<>(commentService.createcomment(post_id,commentdto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{post_id}/comments")
    public ResponseEntity<List<commentdto>> getallcomments(@PathVariable(value = "post_id") long post_id){

        return new ResponseEntity<>(commentService.getallcomments(post_id),HttpStatus.OK);
    }

    @GetMapping("/posts/{post_id}/comment/{id}")
    public  ResponseEntity<commentdto> getcommentbyId(@PathVariable(value = "post_id") long post_id, @PathVariable(value = "id") long id){
        return new ResponseEntity<>(commentService.getcommentbyId(post_id,id),HttpStatus.OK);
    }

    @PutMapping("/posts/{post_id}/comment/{id}")
    public  ResponseEntity<commentdto> updatecommentbyID(@PathVariable(value = "post_id") long post_id, @PathVariable(value = "id") long id, @RequestBody commentdto commentdto){
        return new ResponseEntity<>(commentService.updatecommentbyId(post_id,id,commentdto),HttpStatus.OK);
    }

    @DeleteMapping("/posts/{post_id}/comment/{id}")
    public String deletecomment(@PathVariable(value = "post_id") long post_id, @PathVariable(value = "id") long id, @RequestBody commentdto commentdto){
        return commentService.deletecomment(post_id,id,commentdto);
    }

}
