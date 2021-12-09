package com.seongend.sout.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seongend.sout.service.KakaoUserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class KakaoUserController {
    private final KakaoUserService kakaoUserService;
    private final String AUTH_HEADER = "Authorization";

    @ApiOperation("카카오 로그인")
    @GetMapping("/user/kakao/callback")
    public void kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        String token = kakaoUserService.kakaoLogin(code);
        response.addHeader(AUTH_HEADER, token);
    }
}