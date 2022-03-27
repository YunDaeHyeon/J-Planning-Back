package com.meonjicompany.planning.jplanningbackend.service;

import com.meonjicompany.planning.jplanningbackend.dto.PieceSaveDTO;
import com.meonjicompany.planning.jplanningbackend.dto.PlanSaveDTO;
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

    // 사용자 정보 저장
    public void saveUser(UserDTO userDTO) throws Exception{
        userMapper.registerUser(userDTO);
    }

    // 사용자 식별값 조회
    public int userRoadId(String userEmail) throws Exception{
        return userMapper.roadUserId(userEmail);
    }

    // 계획 저장, 테이블 : plan
    public void savePlan(PlanSaveDTO planSaveDTO) throws Exception{
        userMapper.savePlan(planSaveDTO);
    }

    // 계획 식별값 조회
    public int planRoadId(String planTitle) throws Exception{
        return userMapper.roadPlanId(planTitle);
    }

    // 상세 계획 저장, 테이블 : piece
    public void savePiece(PieceSaveDTO pieceSaveDTO) throws Exception{
        userMapper.savePiece(pieceSaveDTO);
    }
}
