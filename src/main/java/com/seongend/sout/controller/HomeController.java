package com.seongend.sout.controller;

import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;


    @GetMapping("/")
    public List<PostResponseDto> getAllPosts() {
        //@AuthenticationPrincipal UserDetailsImpl userDetails
        return homeService.findAllPost();
    }

    @GetMapping("/search")
    public List<PostResponseDto> getSearchedPost(@RequestParam String keyword) {
        return homeService.searchPosts(keyword);
    }

}
