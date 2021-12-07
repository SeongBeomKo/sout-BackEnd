package com.seongend.sout.validator;

import com.seongend.sout.dto.SignupRequestDto;

import java.util.regex.Pattern;

public class UserInfoValidator {
    public static void validateUserInfoInput(SignupRequestDto requestDto) {
        String patternEmail = "^(.+)@(.+)$";
        String patternNickname = "[^!@#$%^&*(),.?\\\":{}|<>]{2,}";

        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String email = requestDto.getEmail();

        // 닉네임 형식 확인
        if(nickname == null || !Pattern.matches(patternNickname, nickname)) {
            throw new IllegalArgumentException("최소 2자 이상, 특수문자는 포함될 수 없습니다.");
        }

        // 비밀번호 형식 확인
        if(password == null || password.length() < 4){
            throw new IllegalArgumentException("최소 4자 이상이어야 합니다.");
        }

        // email 형식 검사
        if (email == null || !Pattern.matches(patternEmail, email)){
            throw new IllegalArgumentException("이메일 형식이 아닙니다.");
        }
    }
}
