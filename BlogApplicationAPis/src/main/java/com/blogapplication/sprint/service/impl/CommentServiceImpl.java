package com.blogapplication.sprint.service.impl;

import com.blogapplication.sprint.Entity.Comment;
import com.blogapplication.sprint.Entity.Post;
import com.blogapplication.sprint.exceptions.BlogAPIException;
import com.blogapplication.sprint.exceptions.ResourceNotFoundException;
import com.blogapplication.sprint.payload.commentdto;
import com.blogapplication.sprint.payload.postdto;
import com.blogapplication.sprint.repository.commentRepository;
import com.blogapplication.sprint.repository.postRepository;
import com.blogapplication.sprint.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {
private commentRepository commentRepository;
private postRepository postRepository;

    public CommentServiceImpl(commentRepository commentRepository,postRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public commentdto createcomment(Long post_id, commentdto commentdto) {


        Comment comment = maptoentity(commentdto);
        Post post = postRepository.findById(post_id).orElseThrow(()-> new ResourceNotFoundException("Post","id","post_id"));
        comment.setPost(post);
        Comment comment1=commentRepository.save(comment);
        return maptodto(comment1);
    }

    private Comment maptoentity(commentdto commentdto){
        Comment comment=new Comment();
        comment.setName(commentdto.getName());
        comment.setBody(commentdto.getBody());
        comment.setEmail(commentdto.getEmail());
        comment.setId(commentdto.getId());
        return comment;
    }
    private commentdto maptodto(Comment comment){
        commentdto commentdto=new commentdto();
        commentdto.setName(comment.getName());
        commentdto.setBody(comment.getBody());
        commentdto.setEmail(comment.getEmail());
        commentdto.setId(comment.getId());
        return commentdto;
    }

    @Override
    public List<commentdto> getallcomments(Long post_id) {

        List<Comment> comment1 = commentRepository.findByPostId(post_id);

  return comment1.stream().map(come -> maptodto(come)).collect(Collectors.toList());


    }

    @Override
    public commentdto getcommentbyId(Long post_id, Long id) {
        Comment comment = commentRepository.getReferenceById(id);
        commentdto commentdto = maptodto(comment);
        return commentdto;
    }

    @Override
    public commentdto updatecommentbyId(Long post_id, Long id, commentdto commentdto) {
        Post post = postRepository.getReferenceById(post_id);
        Comment comment = commentRepository.getReferenceById(id);

        if(comment.getPost().getId()==(post.getId())){
            comment.setName(commentdto.getName());
            comment.setBody(commentdto.getBody());
            comment.setEmail(commentdto.getEmail());
            return maptodto(commentRepository.save(comment));

        }
        else
            throw new BlogAPIException("cannot","find","somethins");



    }

    @Override
    public String deletecomment(Long post_id, Long id, commentdto commentdto) {

        Post post = postRepository.getReferenceById(post_id);
        Comment comment = commentRepository.getReferenceById(id);

        if(comment.getPost().getId()==(post.getId())){

          commentRepository.delete(comment);
          return "Deleted";

        }
        else
        throw new BlogAPIException("cannot","find","somethins");

    }
}
