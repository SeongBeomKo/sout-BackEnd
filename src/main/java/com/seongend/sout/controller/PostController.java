package com.seongend.sout.controller;

import com.seongend.sout.dto.PostRequestDto;
import com.seongend.sout.entity.Post;
import com.seongend.sout.repository.PostRepository;
import com.seongend.sout.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository PostRepository;
    private final PostService PostService;

    @PostMapping("/newpost")
    public void createPosts(@RequestBody PostRequestDto requestDto) {
        //@AuthenticationPrincipal UserDetailsImpl userDetails
        // ?value="token"
        PostService.createPosts(requestDto);
    }

    /*
    * @PostMapping("/newPost")
    * public void createPosts(@RequestBody PostRequestDto requestDto) {
    *   PostService.createPosts(requestDto)
    * }
    *
    * [ jwt ] 다 설정되어서 @AuthenticationPrincipal UserDetailsImpl userDetails 로 userId 식볋한다는 가정 하의 코드
    * @PostMapping("/newpost")
    * public void createPosts(@RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
    *   Long userId = userDetails.getUser().getId();
    *   return PostService.createPosts(requestDto, userId);
    * }
    *  */

    @DeleteMapping("/{postId}")
    public Long deletePosts(@PathVariable Long postId) {
        // ?value="token"
        // jwt 설정 완료되면 투입란(입력변수란)에 @AuthenticationPrincipal UserDetailsImpl userDetails 넣고
        // if 조건문으로 작성자 userId = jwt token 보유자 userId 일 때만
        PostRepository.deleteById(postId);
        // 하라고 식을 적어야 할 것 같은데 그 조건을 어떻게 적어야 할지 모르겠다.
        return postId;
    }
}
