package com.blogapplication.sprint.repository;

import com.blogapplication.sprint.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface postRepository  extends JpaRepository<Post,Long> {
}
