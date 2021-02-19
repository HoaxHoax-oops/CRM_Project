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
	
	public UserDto() {};
	
	public UserDto(int id, String email, String password, String fullname, String avatar, int roleId ) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = avatar;
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

	public void setRoleName(String roleName) {
		// TODO Auto-generated method stub
		this.roleName = roleName;
		
	}
	public String getRoleName() {
		return roleName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}





}
