package com.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.bean.UserDetails;

public interface UserDetailsDao extends JpaRepository<UserDetails, Integer> {
	
	UserDetails findUserDetailsByuserId(Integer userId);

}
