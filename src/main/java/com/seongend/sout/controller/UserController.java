package com.seongend.sout.controller;

//import com.fasterxml.jackson.core.JsonProcessingException;

import com.seongend.sout.dto.SignupRequestDto;
import com.seongend.sout.dto.UserInfoDto;
import com.seongend.sout.entity.User;
import com.seongend.sout.security.UserDetailsImpl;
import com.seongend.sout.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    //회원가입
    @ApiOperation("회원가입")
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto){
        userService.registerUser(requestDto);
    }

    //프로필 수정
    @ApiOperation("프로필 수정 - 로그인 필요")
    @PutMapping("/setting/profile")
    public void editProfile(@RequestBody SignupRequestDto requestDto) { userService.editProfile(requestDto); }

    // 회원 관련 정보 받기
    @ApiOperation("유저 정보 요청")
    @PostMapping("/userinfo")
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return new UserInfoDto(user.getUsername(), user.getNickname(), user.getInterest(), user.getPassword());
    }
}
