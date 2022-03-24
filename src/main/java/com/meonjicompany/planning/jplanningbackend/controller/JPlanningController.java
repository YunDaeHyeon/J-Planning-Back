package com.meonjicompany.planning.jplanningbackend.controller;

import com.meonjicompany.planning.jplanningbackend.dto.UserDTO;
import com.meonjicompany.planning.jplanningbackend.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user/")
public class JPlanningController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "save")
    public Message TestPost(HttpServletRequest request){
        Message message = new Message();
        try{
            message.setMessage("정상적으로 값을 받았습니다.");
            String email = request.getParameter("user_email");
            String nickname = request.getParameter("user_nickname");
            System.out.println("이메일 : "+email);
            System.out.println("닉네임 : "+nickname);
            return message;
        }catch(Exception e){
            message.setMessage("서버에서 값을 받는 도중 문제가 생겼습니다.");
            System.out.println("통신 실패");
            e.printStackTrace();
            return message;
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