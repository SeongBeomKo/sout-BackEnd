package com.seongend.sout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository<Post> extends JpaRepository<Post, Long> {
}
