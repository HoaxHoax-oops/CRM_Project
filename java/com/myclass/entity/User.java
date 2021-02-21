package com.myclass.entity;

public class User {
	private	int 	id;
	private String	email;
	private String	password;
	private String	fullname;
	private String	address;
	private int		roleId;
	private String	phone;
	private String	userName;
	
	public User() {};
	public User(int id, String email, String password, String fullname, String address, int roleId , String phone , String userName) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.roleId = roleId;
		this.phone = phone;
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int i) {
		this.roleId = i;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
