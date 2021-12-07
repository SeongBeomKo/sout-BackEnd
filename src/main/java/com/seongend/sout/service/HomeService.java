package com.seongend.sout.service;

import com.seongend.sout.dto.CommentResponseDto;
import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.entity.Post;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.repository.PostRepository;
import com.seongend.sout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public List<PostResponseDto> findAllPosts(Pageable pageable) {
        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc(pageable).getContent();
        List<PostResponseDto> allPosts = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDto responseDto = createPostDto(post);
            allPosts.add(responseDto);
        }
        return allPosts;
    }

    public List<PostResponseDto> searchPosts(String keyword, Pageable pageable) {
        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();
        posts.removeIf(post -> !(userRepository.getById(post.getUserId()).getNickname().contains(keyword)
                || post.getContent().contains(keyword)));
        PagedListHolder<Post> page = new PagedListHolder<>(posts);
        page.setPageSize(pageable.getPageSize());
        page.setPage(pageable.getPageNumber());
        posts = page.getPageList();
        System.out.println(posts);
        List<PostResponseDto> searchedPosts = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDto responseDto = createPostDto(post);
            searchedPosts.add(responseDto);
        }
        return searchedPosts;
    }

    public PostResponseDto createPostDto(Post post) {
        List<CommentResponseDto> allComments = findAllComments(post.getId());
        return new PostResponseDto(
                userRepository.getById(post.getUserId()).getNickname(),
                post.getContent(),
                post.getId(),
                post.getModifiedAt(),
                post.getUrl(),
                allComments
        );
    }

    public List<CommentResponseDto> findAllComments(long postId) {
        List<CommentResponseDto> allComments = new ArrayList<>();
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        for (Comment comment : comments)
            allComments.add(new CommentResponseDto(
                    userRepository.getById(comment.getUserId()).getNickname(),
                    comment.getContent(),
                    comment.getModifiedAt()));
        return allComments;
    }
}
