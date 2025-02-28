package com.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    
}
