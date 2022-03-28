package com.meonjicompany.planning.jplanningbackend.controller;

import com.meonjicompany.planning.jplanningbackend.dto.*;
import com.meonjicompany.planning.jplanningbackend.service.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user/")
public class JPlanningController {
    Message message;
    JSONArray jsonArray;
    int key = 0;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "save")
    public Message userSave(HttpServletRequest request, UserDTO userDTO) throws Exception{
        message = new Message();
        try{
            message.setMessage("정상적으로 값을 받았습니다.");
            String email = request.getParameter("user_email");
            String nickname = request.getParameter("user_nickname");
            userDTO.setUserEmail(email);
            userDTO.setUserNickname(nickname);
            userService.saveUser(userDTO);
            key = userService.userRoadId(email);
            message.setMessage(String.valueOf(key));
            return message;
        }catch(Exception e){
            message.setMessage("서버에서 값을 받는 도중 문제가 생겼습니다.");
            System.out.println("userSave 통신 실패");
            e.printStackTrace();
            return message;
        }
    }

    @RequestMapping(value = "roadUserId")
    public Message roadUserId(HttpServletRequest request) throws Exception{
        message = new Message();
        try{
            String email = request.getParameter("user_email");
            key = userService.userRoadId(email);
            message.setMessage(String.valueOf(key));
            // userService.userRoadId(email);
            System.out.println("유저 식별값 : "+key);
            return message;
        }catch(Exception e){
            System.out.println("roadUserId 통신 실패");
            e.printStackTrace();
            return message;
        }
    }

    @RequestMapping(value = "savePlan", produces = "application/json; charset=utf8")
    public Message savePlan(@RequestBody PlanDTO planDTO, HttpServletRequest request, PlanSaveDTO planSaveDTO, PieceSaveDTO pieceSaveDTO) throws Exception{
        message = new Message();
        try{
            String planTitle = planDTO.getPlanTitle();
            String planDate = planDTO.getPlanDate();

            System.out.println("사용자 식별값 : "+key);
            planSaveDTO.setUserId(key);
            planSaveDTO.setPlanTitle(planTitle);
            planSaveDTO.setPlanDate(planDate);

            userService.savePlan(planSaveDTO); // plan 테이블에 값 저장
            int planId = userService.planRoadId(planTitle); // FK 불러오기

            pieceSaveDTO.setPlanId(planId); // Piece 테이블에 FK인 plan_id 값 불러오기
            for(int i = 0 ; i < planDTO.getPieces().size(); i++){
                pieceSaveDTO.setPieceTime(planDTO.getPieces().get(i).getPieceTime());
                pieceSaveDTO.setPieceContents(planDTO.getPieces().get(i).getPieceContents());
                userService.savePiece(pieceSaveDTO); // piece 테이블에 값 저장
            }
            message.setMessage(String.valueOf(planId));
            return message;
        }catch (Exception e){
            System.out.println("savePlan 통신 실패");
            e.printStackTrace();
            return message;
        }
    }

    @RequestMapping(value = "roadPlan", produces = "application/json; charset=utf8")
    public JSONArray roadPlan(HttpServletRequest request) throws Exception{
        jsonArray = new JSONArray();
        try{
            int userId = Integer.parseInt(request.getParameter("user_id")); // 유저 PK값 불러오기
            List<PlanRoadDTO> planRoadDTO = userService.roadPlan(userId);
            System.out.println(planRoadDTO.size());
            for(int i = 0; i < planRoadDTO.size(); i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("plan_id",planRoadDTO.get(i).getPlanId());
                jsonObject.put("plan_title",planRoadDTO.get(i).getPlanTitle());
                jsonObject.put("plan_date",planRoadDTO.get(i).getPlanDate());
                jsonArray.add(jsonObject);
            }
            System.out.println(jsonArray);
            return jsonArray;
        }catch(Exception e){
            System.out.println("roadPlan 통신 실패");
            e.printStackTrace();
            return jsonArray;
        }
    }

}

class Message{
    String message;

    Message(){}

    public Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}