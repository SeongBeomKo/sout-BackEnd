package com.seongend.sout.controller;

import com.seongend.sout.dto.CommentRequestDto;
import com.seongend.sout.dto.CommentResponseDto;
import com.seongend.sout.entity.User;
import com.seongend.sout.security.UserDetailsImpl;
import com.seongend.sout.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성
    @ApiOperation("포스트 별 댓글 작성 - 로그인 필요")
    @PostMapping("/api/{postId}/comment")
    public CommentResponseDto createComments(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return commentService.createComments(postId, requestDto, user);
    }

    // 댓글 삭제
    @ApiOperation("포스트 별 댓글 삭제 - 로그인 필요")
    @DeleteMapping("/api/{postId}/{commentId}")
    public Long deleteComments(@PathVariable String postId, @PathVariable Long commentId) {
        commentService.deleteComments(commentId);
        return commentId;
    }

}
