package com.seongend.sout.controller;

import com.seongend.sout.dto.CommentRequestDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.security.UserDetailsImpl;
import com.seongend.sout.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository CommentRepository;
    private final CommentService CommentService;

    @PostMapping("/{postId}/comment")
    public void createComments(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        CommentService.createComments(postId, requestDto, userId);
    }

    @DeleteMapping("/{postId}/{commentId}")
    public Long deleteComments(@PathVariable String postId, @PathVariable Long commentId) {
        CommentRepository.deleteById(commentId);
        return commentId;
    }

}
