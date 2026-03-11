package com.sparta.leehy.lesson.domain.user.service;

import com.sparta.leehy.lesson.domain.user.entity.User;
import com.sparta.leehy.lesson.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void getUser() {
        User user = userRepository.findByEmailOrName("leehy").get();
    }
}
