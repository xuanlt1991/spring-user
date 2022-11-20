package com.spring.springuser.service.impl;

import com.spring.springcommon.exception.ApiError;
import com.spring.springcommon.exception.CustomException;
import com.spring.springcommon.integration.PostApiIntegration;
import com.spring.springcommon.response.PostResponseDTO;
import com.spring.springuser.entity.User;
import com.spring.springuser.mapper.UserRequestDTOMapper;
import com.spring.springuser.mapper.UserResponseDTOMapper;
import com.spring.springuser.request.UserRequestDTO;
import com.spring.springuser.response.UserResponseDTO;
import com.spring.springuser.respository.UserRepository;
import com.spring.springuser.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserResponseDTOMapper userResponseDTOMapper;

    @Autowired
    private UserRequestDTOMapper userRequestDTOMapper;

    @Autowired
    private PostApiIntegration postApiIntegration;

    @Override
    public UserResponseDTO retrieveUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException(ApiError.populateEntityNotFound("User", "userId", "user_id")));

        return userResponseDTOMapper.toDto(user);
    }

    @Override
    public List<UserResponseDTO> retrieveAllUsers() {
        List<User> users = userRepository.findAll();
        return userResponseDTOMapper.toDtoList(users);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException(ApiError.populateEntityNotFound("User", "userId", "user_id")));
        userRepository.delete(user);
    }

    @Override
    public void updateUser(Long userId, UserRequestDTO requestDTO) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException(ApiError.populateEntityNotFound("User", "userId", "user_id")));
        user.setEmail(requestDTO.getEmail());
        userRepository.save(user);
    }

    @Override
    public void createUser(UserRequestDTO requestDTO) {
        User user = userRequestDTOMapper.toEntity(requestDTO);
        userRepository.save(user);
    }

    @Override
    public UserResponseDTO getPostsByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException(ApiError.populateEntityNotFound("User", "userId", "user_id")));
        UserResponseDTO userResponseDTO = userResponseDTOMapper.toDto(user);
        List<PostResponseDTO> posts = postApiIntegration.getPostsByUserId(userId);
        userResponseDTO.setPostResponseDTOList(posts);

        return userResponseDTO;
    }
}
