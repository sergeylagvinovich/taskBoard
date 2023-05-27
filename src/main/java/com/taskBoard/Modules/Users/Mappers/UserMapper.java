package com.taskBoard.Modules.Users.Mappers;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import com.taskBoard.Modules.Users.Dto.NewUserDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper
public interface UserMapper {

    User newUserToModel (NewUserDto userDto);


}
