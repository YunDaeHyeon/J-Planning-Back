package com.meonjicompany.planning.jplanningbackend.controller;

import com.meonjicompany.planning.jplanningbackend.dto.UserDTO;
import com.meonjicompany.planning.jplanningbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JPlanningController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ModelAndView registerUser(UserDTO userDTO, Model model){
        userService.saveUser(userDTO);
        model.addAttribute("message","성공");

        ModelAndView mv = new ModelAndView("/user_access");
        return mv;
//        return "redirect:/response_success";
    }
}
