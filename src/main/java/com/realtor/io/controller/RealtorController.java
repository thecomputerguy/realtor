package com.realtor.io.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realtor/v1")
public class RealtorController {

    @GetMapping("/")
    public ResponseEntity<?> home(){
        return ResponseEntity.ok().body("Getting response from server.");
    }
}
