package com.seongend.sout.service;

import com.seongend.sout.dto.CommentRequestDto;
import com.seongend.sout.entity.Comment;
import com.seongend.sout.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    @Transactional
    public Comment createComments(Long postId, CommentRequestDto requestDto, Long userId) {
        Comment comment = new Comment(postId, requestDto, userId);
        CommentRepository.save(comment);
        return comment;
    }
    // Comment entity에 post와 Joincolumn이 되어있는데 그걸 postId로 표현이 가능한 건지 잘 모르겠음.
    // postId로 표현이 가능한 건지 모르겠냐는 말은, Comment의 객체를 설정할 때 comment entity에는 Post post라고 적혀있는데 post대신 postId를 써도 괜찮을까 하는 걱정
    // 표현방식을 좀 달리해야 할 것 같은데 postId에서 post를 가리키는 표현 방법을 모르겠다.
}
