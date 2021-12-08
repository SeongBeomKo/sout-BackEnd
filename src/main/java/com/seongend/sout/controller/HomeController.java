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

    //모든 포스트 보여주기
    //수정한 날짜 내림차순으로(최신순)
    //요청한 페이지와 페이지마다 포스트 개수를 지정해서 요청
    @GetMapping("/*")
    public List<PostResponseDto> getAllPosts(@RequestParam int page, @RequestParam int size) {
        //@AuthenticationPrincipal UserDetailsImpl userDetails
        Pageable sortedByModifiedAtDesc = PageRequest.of(page, size, Sort.by("modifiedAt").descending());
        return homeService.findAllPosts(sortedByModifiedAtDesc);
    }

    // 키워드를 검색한 포스트를
    // 수정한 날짜 내림차순(최신순)
    // 요청한 페이지와 페이지마다 포스트 개수를 지정해서 요청
    @GetMapping("/search")
    public List<PostResponseDto> getSearchedPost(@RequestParam String keyword, @RequestParam int page, @RequestParam int size) {
        return homeService.searchPosts(keyword, page, size);
    }
}
