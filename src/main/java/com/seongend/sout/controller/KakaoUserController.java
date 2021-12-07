package com.seongend.sout.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seongend.sout.service.KakaoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class KakaoUserController {
    private final KakaoUserService kakaoUserService;

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        kakaoUserService.kakaoLogin(code);
        return "redirect:/?page=0&size=1";
    }
}