package com.seongend.sout.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String nickname;
    private String password;
    private String email;
    private String interest;
}
