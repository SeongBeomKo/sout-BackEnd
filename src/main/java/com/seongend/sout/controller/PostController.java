package com.seongend.sout.controller;

import com.seongend.sout.dto.PostRequestDto;
import com.seongend.sout.security.UserDetailsImpl;
import com.seongend.sout.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/newpost")
    public void createPosts(@RequestBody PostRequestDto requestDto,
                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        postService.createPosts(requestDto, userId);
    }

    @PutMapping("/newpost/{postId}")
    public Long updatePosts(@PathVariable Long postId, @RequestBody PostRequestDto requestDto,
                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.update(postId, requestDto);
        return postId;
    }

    @DeleteMapping("/{postId}")
    public Long deletePosts(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.deletePosts(postId);
        return postId;
    }
}
