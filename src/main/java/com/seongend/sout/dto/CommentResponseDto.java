package com.seongend.sout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {

    private Long commentId;

    private String nickname;

    private String content;

    private String modifiedAt;

    private String email;
}
