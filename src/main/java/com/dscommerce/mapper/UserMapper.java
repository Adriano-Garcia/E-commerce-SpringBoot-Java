package com.dscommerce.mapper;

import org.mapstruct.Mapper;

import com.dscommerce.entities.User;
import com.dscommerce.entities.dto.UserRequestDTO;
import com.dscommerce.entities.dto.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponseDTO toUserResponseDTO(User user);
	UserRequestDTO toUserResquestDto(User user);
	User toUserInResquest(UserRequestDTO userRequest);

}
