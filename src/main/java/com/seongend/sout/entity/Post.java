package com.seongend.sout.entity;

import com.seongend.sout.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String content;

    @Column
    private String url;

    public Post(PostRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.url = requestDto.getUrl();
        this.userId = 1L; // userId 가상 설정할 땐 1L
    }

    public void update(PostRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.url = requestDto.getUrl();
    }
}
