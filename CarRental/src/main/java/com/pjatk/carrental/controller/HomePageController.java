package com.pjatk.carrental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public ResponseEntity index(){
        return ResponseEntity.ok("<h1>Hello</1>");
    }
    @GetMapping("user")
    public ResponseEntity user(){
        return ResponseEntity.ok("<h1>Hello User</1>");
    }
    @GetMapping("admin")
    public ResponseEntity admin(){
        return ResponseEntity.ok("<h1>Hello Admin</1>");
    }
}
