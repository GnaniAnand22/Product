package com.example.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productapp.module.User;

public interface UserRepository extends JpaRepository<User, String> {

}
