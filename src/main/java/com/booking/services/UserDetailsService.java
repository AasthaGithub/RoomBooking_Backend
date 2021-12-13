package com.booking.services;

import com.booking.bean.UserDetails;

public interface UserDetailsService {

	UserDetails findUserDetailsById(Integer id);

	UserDetails saveUser(UserDetails userDetails);

}
