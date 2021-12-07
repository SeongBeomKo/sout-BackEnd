package com.seongend.sout.repository;

import com.seongend.sout.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
    Page<Post> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
