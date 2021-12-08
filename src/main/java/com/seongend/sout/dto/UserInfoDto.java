package com.seongend.sout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserInfoDto {
    private String email;
    private String nickname;
    private String interest;
    private String password;
}
