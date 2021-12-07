package com.seongend.sout.controller;

import com.seongend.sout.dto.CommentRequestDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository CommentRepository;
    private final CommentService CommentService;

    @PostMapping("/{postId}/comment")
    public Comment createComments(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto) {
        return CommentService.createComments(postId, requestDto);
    }

    @DeleteMapping("/{postId}/{commentId}")
    public Long deleteComments(@PathVariable Long commentId) {
        CommentRepository.deleteById(commentId);
        return commentId;
    }

}
