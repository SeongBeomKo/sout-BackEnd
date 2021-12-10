package com.seongend.sout.service;

import com.seongend.sout.dto.CommentResponseDto;
import com.seongend.sout.dto.PostRequestDto;
import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.entity.Post;
import com.seongend.sout.entity.User;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.repository.PostRepository;
import com.seongend.sout.timeconversion.TimeConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public PostResponseDto createPosts(PostRequestDto requestDto, User user) {
        // post 저장
        Post post = new Post(requestDto, user.getId());
        postRepository.save(post);

        // 새로 작성한 글이기 때문에 댓글이 없이 리스트만 생김..
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

        // 새로 작성한 포스트 정보 리턴
        return new PostResponseDto(
                user.getNickname(),
                post.getContent(),
                post.getId(),
                TimeConversion.timeConversion(post.getModifiedAt()),
                post.getUrl(),
                user.getInterest(),
                commentResponseDtoList,
                user.getUsername()
                );
    }

    @Transactional
    public Long update(Long postId, PostRequestDto requestDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디의 게시글이 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

    @Transactional
    public Long deletePosts(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시물이 없습니다."));
        commentRepository.deleteAllByPost(post);
        postRepository.deleteById(postId);
        return postId;
    }
}