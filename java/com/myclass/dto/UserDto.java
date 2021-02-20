package com.myclass.dto;

public class UserDto {
	private	int 	id;
	private String	email;
	private String	password;
	private String	fullname;
	private String	address;
	private int		roleId;
	private String	roleDescription;
	private String	roleName;
	private String	phone;
	private String	userName;
	
	public UserDto() {};
	


	public UserDto(int id, String email, String password, String fullname, String address, int roleId,
			String roleDescription, String roleName, String phone , String userName) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.roleId = roleId;
		this.roleDescription = roleDescription;
		this.roleName = roleName;
		this.phone = phone;
		this.userName = userName;
	}


	public UserDto(int id, String email, String password, String fullname, String avatar, int roleId) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.roleId = roleId;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public String getRoleDescription() {
		return roleDescription;
	}



	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}




}
