package com.seongend.sout.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seongend.sout.dto.SignupRequestDto;
import com.seongend.sout.service.KakaoUserService;
import com.seongend.sout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    //private final KakaoUserService kakaoUserService;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto){
        userService.registerUser(requestDto);
    }

//    // kakao 로그인
//    @GetMapping("/user/kakao/callback")
//    public void kakaoLogin(@RequestParam String code) throws JsonProcessingException {
//        // authorizedCode: 카카오 서버로부터 받은 인가 코드
//        kakaoUserService.kakaoLogin(code);
//    }
}
