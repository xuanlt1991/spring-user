package com.spring.springuser.service;

import com.spring.springuser.request.UserRequestDTO;
import com.spring.springuser.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO retrieveUser(Long userId);
    List<UserResponseDTO> retrieveAllUsers();
    void deleteUser(Long userId);
    void updateUser(Long userId, UserRequestDTO requestDTO);

    void createUser(UserRequestDTO requestDTO);

    UserResponseDTO getPostsByUserId(Long userId);
}
