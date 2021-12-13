package com.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.bean.UserDetails;
import com.booking.bean.UserLogin;
import com.booking.dao.UserDetailsDao;
import com.booking.dao.UserLoginDao;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	@Autowired
	private UserLoginDao userLoginDao;
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	
	@Override
	public UserLogin saveUser(UserLogin user, Integer userId){
		UserDetails usrDets= userDetailsDao.findUserDetailsByuserId(userId);
		user.setUserDetails(usrDets);		
		return userLoginDao.save(user);	
	}
	
	
	@Override
	public UserLogin fetchLoginUser(String email){
		return userLoginDao.findByEmail(email);
	}
}
