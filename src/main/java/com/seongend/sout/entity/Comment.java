package com.seongend.sout.entity;

import com.seongend.sout.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long userId;

    public Comment(Post post, CommentRequestDto requestDto, Long userId) {
        this.post = post;
        this.content = requestDto.getContent();
        this.userId = userId;
    }
}
