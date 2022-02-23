package com.example.shop.repository;

import com.example.shop.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

// Первым в <> с чем работает и тип его id
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
