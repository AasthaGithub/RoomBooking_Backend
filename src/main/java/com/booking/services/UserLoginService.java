package com.booking.services;

import com.booking.bean.UserLogin;

public interface UserLoginService {

	UserLogin saveUser(UserLogin user, Integer userId);

	UserLogin fetchLoginUser(String email);

}
