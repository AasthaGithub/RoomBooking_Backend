package com.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.bean.UserLogin;

public interface UserLoginDao extends JpaRepository<UserLogin, String>{
	
	UserLogin findByEmail(String email);

}
