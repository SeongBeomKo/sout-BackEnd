package com.seongend.sout.controller;

import com.seongend.sout.dto.CommentRequestDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.repository.CommentRepository;
import com.seongend.sout.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    /*private final CommentRepository CommentRepository;
    private final CommentService CommentService;

    @PostMapping("/{postId}/comment")
    public boolean createComments(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 여기서 @PathVariable Long postId는 빼도 되나? 근데 Comment에 Joincolumn으로 post가 있어서 애매
        if (userDetails != null) {
            Long userId = userDetails.getUser().getId();
            CommentService.createComments(postId, requestDto, userId);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{postId}/{commentId}")
    public Long deleteComments(@PathVariable Long commentId) {
        Comment comment = new Comment();
        commentId = comment.getId();
        CommentRepository.deleteById(commentId); // 꽤 짧다고 생각해 Service에 method를 만들지 않았으나 마음을 먹으면 못 만들 건 없는?
        return commentId;
    }*/
}
