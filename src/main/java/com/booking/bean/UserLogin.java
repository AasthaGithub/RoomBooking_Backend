package com.booking.bean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_login")
public class UserLogin {

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private UserDetails userDetails;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLogin(String email, String password, UserDetails userDetails) {
		super();
		this.email = email;
		this.password = password;
		this.userDetails = userDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "UserLogin [email=" + email + ", password=" + password + ", userDetails=" + userDetails + "]";
	}
	
	
	
}
