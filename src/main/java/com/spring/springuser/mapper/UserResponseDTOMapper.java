package com.spring.springuser.mapper;

import com.spring.springcommon.mapper.EntityMapper;
import com.spring.springuser.entity.User;
import com.spring.springuser.response.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseDTOMapper extends EntityMapper<UserResponseDTO, User> {

}
