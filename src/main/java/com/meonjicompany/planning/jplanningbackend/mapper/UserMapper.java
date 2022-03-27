package com.meonjicompany.planning.jplanningbackend.mapper;

import com.meonjicompany.planning.jplanningbackend.dto.PieceSaveDTO;
import com.meonjicompany.planning.jplanningbackend.dto.PlanSaveDTO;
import com.meonjicompany.planning.jplanningbackend.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 사용자 정보 저장
    void registerUser(UserDTO userDTO) throws Exception;
    // 사용자 id 불러오기
    int roadUserId(String userEmail) throws Exception;
    // 계획 저장 - DB TABLE : plan
    void savePlan(PlanSaveDTO planSaveDTO) throws Exception;
    // 계획 id 불러오기
    int roadPlanId(String planTitle) throws Exception;
    // 상세 계획 저장 - DB TABLE : piece
    void savePiece(PieceSaveDTO pieceSaveDTO) throws Exception;
}