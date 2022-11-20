package com.spring.springuser.mapper;

import com.spring.springcommon.mapper.EntityMapper;
import com.spring.springuser.entity.User;
import com.spring.springuser.request.UserRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestDTOMapper extends EntityMapper<UserRequestDTO, User> {
}
