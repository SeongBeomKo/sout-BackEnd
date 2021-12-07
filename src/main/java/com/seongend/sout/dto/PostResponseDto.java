package com.seongend.sout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostResponseDto {

    private String nickname;

    private String content;

    private long postId;

    private LocalDateTime modifiedAt;

    private String url;

    private List<CommentResponseDto> commentList;


}
