package com.seongend.sout.service;

import com.seongend.sout.dto.CommentResponseDto;
import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.entity.Post;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.repository.PostRepository;
import com.seongend.sout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<PostResponseDto> findAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> allPosts = new ArrayList<>();
        for(Post post : posts) {
            List<CommentResponseDto> allComments = findAllComment(post.getId());
            PostResponseDto responseDto = new PostResponseDto(
                    userRepository.getById(post.getUserId()).getNickname(),
                    post.getContent(),
                    post.getId(),
                    post.getModifiedAt(),
                    post.getUrl(),
                    allComments
                    );
            allPosts.add(responseDto);
        }
        return allPosts;
    }

    @Transactional
    public List<CommentResponseDto> findAllComment(long postId) {
        List<CommentResponseDto> allComments = new ArrayList<>();
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        for(Comment comment : comments)
            allComments.add(new CommentResponseDto(
                    userRepository.getById(comment.getUserId()).getNickname(),
                    comment.getContent(),
                    comment.getModifiedAt()));
        return allComments;
    }
}
