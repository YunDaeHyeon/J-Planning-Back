package com.meonjicompany.planning.jplanningbackend.service;

import com.meonjicompany.planning.jplanningbackend.dto.UserDTO;
import com.meonjicompany.planning.jplanningbackend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    Date time = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");

    @Autowired
    UserMapper userMapper;

    public void saveUser(UserDTO userDTO) throws Exception{
        userMapper.registerUser(userDTO);
    }

    public int userRoadId(String userEmail) throws Exception{
        return userMapper.roadUserId(userEmail);
    }
}
