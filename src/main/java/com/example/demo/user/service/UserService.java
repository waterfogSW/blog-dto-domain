package com.example.demo.user.service;

import org.springframework.stereotype.Service;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User findById(long id) {
    return userRepository
        .findById(id)
        .orElseThrow(NotFoundException::new);
  }

}
