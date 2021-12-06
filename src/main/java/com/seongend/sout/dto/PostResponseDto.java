package com.seongend.sout.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostResponseDto {
    private String nickname;
    private String content;
    private Long postId;
    private String url;
    private List<CommentResponseDto> commentResponseDtoList;
}
