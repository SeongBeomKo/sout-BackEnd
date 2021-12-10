package com.seongend.sout.repository;

import com.seongend.sout.entity.Comment;
import com.seongend.sout.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(long postId);

    void deleteAllByPost(Post post);
}
