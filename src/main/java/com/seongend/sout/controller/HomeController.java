package com.seongend.sout.controller;

import com.seongend.sout.dto.PostResponseDto;
import com.seongend.sout.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public List<PostResponseDto> getAllPosts(@RequestParam int page, @RequestParam int size) {
        //@AuthenticationPrincipal UserDetailsImpl userDetails
        Pageable sortedByModifiedAtDesc = PageRequest.of(page, size, Sort.by("modifiedAt").descending());
        return homeService.findAllPosts(sortedByModifiedAtDesc);
    }

    @GetMapping("/search")
    public List<PostResponseDto> getSearchedPost(@RequestParam String keyword, @RequestParam int page, @RequestParam int size) {
        return homeService.searchPosts(keyword, page, size);
    }
}
