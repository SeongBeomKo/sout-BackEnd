package com.seongend.sout.service;

import com.seongend.sout.dto.PostRequestDto;
import com.seongend.sout.entity.Post;
import com.seongend.sout.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository PostRepository;

    @Transactional
    public void createPosts(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        PostRepository.save(post);
    }

    /* [jwt] @AuthenticationPrincipal UserDetailsImpl userDetails 다 설정되었다고 가정
    * public void createPosts(PostRequestDto requestDto, Long userId) {
    *   Post post = new Post(requestDto, userId);
    *   PostRepository.save(post);
    * }
    * */


}
