package com.seongend.sout.service;

import com.seongend.sout.dto.CommentRequestDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.entity.Post;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void createComments(Long postId, CommentRequestDto requestDto, Long userId) throws NullPointerException {

        Post post = postRepository.findById(postId).orElse(null);
        if (post == null) {
            throw new NullPointerException("해당 게시글 정보가 존재하지 않습니다.");
        }

        Comment comment = new Comment(post, requestDto, userId);
        commentRepository.save(comment);
    }

    public Long deleteComments(Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
