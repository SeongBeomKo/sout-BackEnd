package com.seongend.sout.controller;

import com.seongend.sout.dto.PostRequestDto;
import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public List<PostResponseDto> getAllPost() {
        //@AuthenticationPrincipal UserDetailsImpl userDetails
        return homeService.findAllPost();
    }

}
