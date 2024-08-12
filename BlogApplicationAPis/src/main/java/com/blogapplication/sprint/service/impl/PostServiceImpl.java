package com.blogapplication.sprint.service.impl;

import com.blogapplication.sprint.Entity.Post;
import com.blogapplication.sprint.payload.postdto;
import com.blogapplication.sprint.payload.PostResponse;

import com.blogapplication.sprint.repository.postRepository;
import com.blogapplication.sprint.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private postRepository postRepository;
//    private ModelMapper mapper;

    public PostServiceImpl(postRepository postRepository
//                           ModelMapper mapper
    ) {
        this.postRepository = postRepository;
//        this.mapper=mapper;
    }

    @Override
    public postdto createpost(postdto postdto) {
        Post post1= new Post();
        post1.setTitle(postdto.getTitle());
        post1.setDescription(postdto.getDescription());
        post1.setContent(postdto.getContent());

        Post newPost= postRepository.save(post1);

        postdto postresponse = tabletodto(newPost);
        return postresponse;




    }

    @Override
    public PostResponse getallPosts(int pageNo, int pagesize, String sortby, String sortdir ) {

        Page<Post> posts;
        Sort sort =sortdir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortby).ascending(): Sort.by(sortby).descending();
        Pageable pageable = PageRequest.of(pageNo,pagesize, sort);
        posts= postRepository.findAll(pageable);

        List<Post> lisofposts =  posts.getContent();

    List<postdto> returnposts=lisofposts.stream().map(post -> tabletodto(post)).collect(Collectors.toList());

    PostResponse postresponse =new PostResponse();
    postresponse.setPostdtoList(returnposts);
    postresponse.setPagesize(posts.getSize());
    postresponse.setPageNo(posts.getNumber());
    postresponse.setTatalpages(posts.getTotalPages());
    postresponse.setTotalElements(posts.getTotalElements());
    postresponse.setIslast(posts.isLast());

        return postresponse;


    }

    private postdto tabletodto(Post newPost){
//        postdto postresponse=mapper.map(newPost, postdto.class);
        ModelMapper modelMapper = new ModelMapper();
        postdto postresponse = modelMapper.map(newPost, postdto.class);
//        postdto postresponse = new postdto();
//        postresponse.setId(newPost.getId());
//        postresponse.setTitle(newPost.getTitle());
//        postresponse.setContent(newPost.getContent());
//        postresponse.setDescription(newPost.getDescription());
        return postresponse;

    }

    @Override
    public postdto getpostbyId(long id) {

        Post post=postRepository.getReferenceById(id);

        return tabletodto(post);
    }

    @Override
    public postdto updatepostbyId(postdto postdto, Long id) {
        Post post=postRepository.getReferenceById(id);
        post.setContent(postdto.getContent());
        post.setDescription(postdto.getDescription());
        post.setTitle(postdto.getTitle());
        Post postupdated= postRepository.save(post);
        postdto postresponse = tabletodto(postupdated);


        return postresponse;
    }

    @Override
    public String deletepostbyId(long id) {
      postRepository.deleteById(id);
        return "Deleted";
    }
}
