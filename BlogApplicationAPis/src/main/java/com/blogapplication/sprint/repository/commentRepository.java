package com.blogapplication.sprint.repository;

import com.blogapplication.sprint.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface commentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
