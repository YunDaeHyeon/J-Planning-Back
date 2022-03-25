package com.meonjicompany.planning.jplanningbackend.mapper;

import com.meonjicompany.planning.jplanningbackend.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 사용자 정보 저장
    void registerUser(UserDTO userDTO) throws Exception;
}