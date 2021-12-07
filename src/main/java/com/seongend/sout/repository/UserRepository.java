package com.seongend.sout.repository;

import com.seongend.sout.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 닉네임 존재 여부
    boolean existsByUsername(String email);

    // 카카오 로그인
    Optional<User> findByKakaoId(Long kakaoId);


    Optional<User> findByUsername(String username);
}
