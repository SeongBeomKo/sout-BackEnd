package com.seongend.sout.entity;

import com.seongend.sout.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

//    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
//    @JoinColumn
//    private List<Comment> commentList = new ArrayList<>();
    // 순환참조의 위험성이 생기긴 하나 commentList를 지칭할 때 Post post가 입력변수일 때 정확히 표현할 방법이라서 새로 추가.

    public Post(PostRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.url = requestDto.getUrl();
        this.userId = 1L; // userId 가상 설정할 땐 1L
    } // authentication userDetails 가 제대로 설정되지 않았을 때 임시방편용.
    // jwt token 을 지칭하는 UserDetails 항목이 보다 정확히 지칭되면 입력변수에 UserDetails ~ 넣고 this.userId = userDetails.getUser.getId(); 등 넣을 것.

    public void update(PostRequestDto requestDto) {
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
