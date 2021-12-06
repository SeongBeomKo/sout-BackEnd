package com.seongend.sout.entity;

import com.seongend.sout.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    }

    /* [jwt] 설정 완료됐다는 가정 하에 userId까지 포함한 Entity
    * public Post(PostRequestDto requestDto, Long userId) {
    *   this.uerId = userId;
    *   this.content = requestDto.getContent();
    *   this.url = requestDto.getUrl();
    * }
    * */
}
