package com.bicycle.equity.controller;

import com.bicycle.common.dto.JSONResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author miujoke
 * @date 2025/3/15 22:52
 */
@Controller
public class BicycleController {


    @GetMapping("/health")
    public ResponseEntity<JSONResponse> checkHealth(){
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setErrorCode(0);
        return ResponseEntity.ok(jsonResponse);
    }
}
