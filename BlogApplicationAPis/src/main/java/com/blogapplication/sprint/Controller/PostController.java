package com.blogapplication.sprint.Controller;

import com.blogapplication.sprint.Entity.Post;
import com.blogapplication.sprint.payload.PostResponse;
import com.blogapplication.sprint.payload.postdto;
import com.blogapplication.sprint.utils.constants;

import com.blogapplication.sprint.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<postdto> createpost(@RequestBody postdto postdto){
        return new ResponseEntity<>(postService.createpost(postdto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<PostResponse> getposts(@RequestParam(value = "pageNo",defaultValue = constants.DEFAULT_PAGE_NO,required = false) int pageNo,
                                                 @RequestParam(value = "pagesize",defaultValue = constants.DEFAULT_PAGE_SIZE,required = false) int pagesize,
                                                 @RequestParam(value = "sortby",defaultValue = constants.DEFAULT_SORTBY,required = false) String sortby,
                                                 @RequestParam(value = "sortdir",defaultValue = constants.DEFAULT_SORT_DIRECTOIN,required = false) String sortdir){
        return  new ResponseEntity<>(postService.getallPosts(pageNo,pagesize,sortby,sortdir),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<postdto> getpostbyId(@PathVariable long id){
        return new ResponseEntity<>(postService.getpostbyId(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<postdto> updatepostybyId(@RequestBody postdto postdto,@PathVariable Long id){
        return new ResponseEntity<>(postService.updatepostbyId(postdto,id),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletepostbyId(@PathVariable long id){
        return new ResponseEntity<>(postService.deletepostbyId(id),HttpStatus.OK);
    }

}

