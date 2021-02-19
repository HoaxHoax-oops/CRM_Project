package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connecttion.DbConnection;
import com.myclass.dto.UserDto;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.mysql.cj.xdevapi.Result;

public class UserRepository {

	public List<User> findAll() {
		List<User> userList = new ArrayList<User>();
		Connection conn = DbConnection.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM users");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User entity = new User();
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setFullname(resultSet.getString("fullname"));
				entity.setAvatar(resultSet.getString("avatar"));
				entity.setRoleId(resultSet.getInt("role_id"));

				userList.add(entity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "INSERT INTO users (email , password , fullname , avatar , role_id) value ( ? , ? , ? , ? , ?)";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRoleId());
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int remove(int idDelete) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "DELETE FROM users WHERE id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idDelete);
			statement.executeUpdate();
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int editUser(User userEdit) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query  = "UPDATE users SET email = ? , password = ? , fullname = ? , avatar = ? , role_id = ? WHERE id = ?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, userEdit.getEmail());
			statement.setString(2, userEdit.getPassword());
			statement.setString(3, userEdit.getFullname());
			statement.setString(4, userEdit.getAvatar());
			statement.setInt(5, userEdit.getRoleId());
			statement.setInt(6, userEdit.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public User findById(int idEdit) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		User entity = null;
		String query = "SELECT * FROM users WHERE id=?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idEdit);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				entity = new User();
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setFullname(resultSet.getString("fullname"));
				entity.setAvatar(resultSet.getString("avatar"));
				entity.setRoleId(resultSet.getInt("role_id"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}


	public List<UserDto> getAll() {
		// TODO Auto-generated method stub
		List<UserDto> userList = new ArrayList<UserDto>();
		Connection conn = DbConnection.getConnection();
		UserDto entity = null;
		String query = "SELECT USER.id, USER.email, USER.password , USER.fullname , USER.address , USER.role_id , ROLE.description	\r\n" + 
				" FROM USER\r\n" + 
				" INNER JOIN ROLE\r\n" + 
				" ON USER.role_id = ROLE.id";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				entity = new UserDto();
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setFullname(resultSet.getString("fullname"));
				entity.setAddress(resultSet.getString("address"));
				entity.setRoleId(resultSet.getInt("role_id"));
				entity.setRoleDescription(resultSet.getString("roles.description"));
				
				userList.add(entity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		User entity = null;
		Connection conn = DbConnection.getConnection();
		String query = "SELECT * FROM users WHERE email = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				entity = new User();
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setFullname(resultSet.getString("fullname"));
				entity.setAvatar(resultSet.getString("avatar"));
				entity.setRoleId(resultSet.getInt("role_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entity;
	}

	public int checkPass(User entity) {
		// TODO Auto-generated method stub
		
		return -1;
	}




}
