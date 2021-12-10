package com.seongend.sout.service;

import com.seongend.sout.dto.CommentResponseDto;
import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.entity.Post;
import com.seongend.sout.entity.User;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.repository.PostRepository;
import com.seongend.sout.repository.UserRepository;
import com.seongend.sout.timeconversion.TimeConversion;
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

    public List<PostResponseDto> searchPosts(String keyword, int pageNumber, int size) {
        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();
        posts.removeIf(post -> !(userRepository.getById(post.getUserId()).getNickname().contains(keyword)
                || post.getContent().contains(keyword)));
        PagedListHolder<Post> page = new PagedListHolder<>(posts);
        page.setPageSize(size);
        page.setPage(pageNumber);
        posts = page.getPageList();
        List<PostResponseDto> searchedPosts = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDto responseDto = createPostDto(post);
            searchedPosts.add(responseDto);
        }
        return searchedPosts;
    }

    public PostResponseDto createPostDto(Post post) {
        List<CommentResponseDto> allComments = findAllComments(post.getId());

        User user = userRepository.getById(post.getUserId());
        return new PostResponseDto(
                user.getNickname(),
                post.getContent(),
                post.getId(),
                TimeConversion.timeConversion(post.getModifiedAt()),
                post.getUrl(),
                user.getInterest(),
                allComments,
                user.getUsername()
        );
    }

    public List<CommentResponseDto> findAllComments(long postId) {
        List<CommentResponseDto> allComments = new ArrayList<>();
        List<Comment> comments = commentRepository.findAllByPostId(postId);

        for (Comment comment : comments) {
            User user = userRepository.getById(comment.getUserId());

            allComments.add(new CommentResponseDto(
                    comment.getId(),
                    user.getNickname(),
                    comment.getContent(),
                    TimeConversion.timeConversion(comment.getModifiedAt()),
                    user.getUsername()
                    ));
        }

        return allComments;
    }
}
