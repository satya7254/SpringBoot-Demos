package com.satya.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
