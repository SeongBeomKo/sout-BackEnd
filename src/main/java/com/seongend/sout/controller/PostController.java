package com.seongend.sout.controller;

import com.seongend.sout.dto.PostRequestDto;
import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.entity.User;
import com.seongend.sout.security.UserDetailsImpl;
import com.seongend.sout.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    // 글 작성
    @ApiOperation("포스트 작성 - 로그인 필요")
    @PostMapping("/newpost")
    public PostResponseDto createPosts(@RequestBody PostRequestDto requestDto,
                                       @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return postService.createPosts(requestDto, user);
    }

    // 글 수정
    @ApiOperation("포스트 수정 - 로그인 필요")
    @PutMapping("/newpost/{postId}")
    public Long updatePosts(@PathVariable Long postId, @RequestBody PostRequestDto requestDto,
                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.update(postId, requestDto);
        return postId;
    }

    // 글 삭제
    @ApiOperation("포스트 삭제 - 로그인 필요")
    @DeleteMapping("/api/{postId}")
    public Long deletePosts(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.deletePosts(postId);
        return postId;
    }
}
