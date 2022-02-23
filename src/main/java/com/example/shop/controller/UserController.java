package com.example.shop.controller;

import com.example.shop.entity.UserEntity;
import com.example.shop.exception.UserAlreadyExistEx;
import com.example.shop.exception.UserNotFoundEx;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired //Инициализирует репозиторий
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Server working");
        } catch (UserAlreadyExistEx e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server Error");
        }
    }
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam(required = false) Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundEx e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server Error");
        }
    }

    @GetMapping(path = "/hello")
    public Map<String, String> getJson() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;
    }
}
