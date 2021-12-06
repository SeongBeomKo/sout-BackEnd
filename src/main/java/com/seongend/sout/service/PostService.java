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

    /* public List<PostResponseDto> showDtoPosts() {
        return showPost(PostRepository.findAllByOrderByModifiedAtDesc());
    }

    private List<PostResponseDto> showPost(List<Post> postList) {
        List<PostResponseDto> result = new ArrayList<>();

        for (Post post : postList ) {
            // String nickname은 어떤 식으로 연결해야 하지?
            // User 와 Post 사이에 JoinColumn이 없으니 Service에서 Get으로는 받아올 수 없음
            // "입력변수"란에 User user, userDetailsImpl 등을 새로 넣는다면 모를까.
            String nickname = post.getUser().getNickname();
            String content = post.getContent();
            Long postId = post.getId();
            String url = post.getUrl();
            List<CommentResponseDto> commentResponseDtos = getCommentResponseDtos(post);

            result.add(new PostResponseDto(nickname, content, postId, url, commentResponseDtos));
        }

        return result;
    }

    private List<CommentResponseDto> getCommentResponseDtos(Post post) {
        List<CommentResponseDto> result = new ArrayList<>();
        List<Comment> commentList = post.getCommentList();

        for ( Comment comment : commentList ) {
            String nickname = user.getNickname();
            String content = comment.getContent();

            result.add(new CommentResponseDto(nickname, content));
        }

        return result;
    } */

    @Transactional
    public Long update(Long postId, PostRequestDto requestDto) throws IllegalArgumentException {
        Post post = PostRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디의 게시글이 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

}
