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

    @Transactional
    public Long update(Long postId, PostRequestDto requestDto) throws IllegalArgumentException {
        Post post = PostRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디의 게시글이 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }
}
