package com.bicycle.equity.controller;

import com.bicycle.common.dto.JSONResponse;
import com.bicycle.service.dto.UserDto;
import com.bicycle.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author miujoke
 * @date 2025/3/15 22:52
 */
@Controller
@RequestMapping("/api")
public class BicycleController {

    @Autowired
    private UserService userService;


    @GetMapping("/health")
    public ResponseEntity<JSONResponse> checkHealth(){
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setErrorCode(0);
        return ResponseEntity.ok(jsonResponse);
    }

    @GetMapping("/getUserAll")
    public ResponseEntity<JSONResponse> getUserAll(){
        List<UserDto> allUsers = userService.getAllUsers();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setErrorCode(0);
        jsonResponse.setMessage("Success");
        jsonResponse.setReturnObject(allUsers);
        return ResponseEntity.ok(jsonResponse);
    }
}
