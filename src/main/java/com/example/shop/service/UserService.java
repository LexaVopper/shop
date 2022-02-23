package com.example.shop.service;


import com.example.shop.entity.UserEntity;
import com.example.shop.exception.UserAlreadyExistEx;
import com.example.shop.exception.UserNotFoundEx;
import com.example.shop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistEx {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistEx("Пользователь существует");
        }
        return userRepo.save(user);
    }

    public UserEntity getOne(Long id) throws UserNotFoundEx {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundEx("Пользователя нет");
        }
        return user;
    }
}
