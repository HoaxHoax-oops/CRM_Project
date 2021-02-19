package com.myclass.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connecttion.DbConnection;
import com.myclass.entity.Role;

public class RoleRepository {
	
	public List<Role> findAll() {
		List<Role> roleList = new ArrayList<Role>();
		Connection conn = DbConnection.getConnection();
		// TRUY VẤN LẤY DỮ LIỆU
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM ROLE");
			// Thực thi câu lệnh truy vấn
			ResultSet resultSet = statement.executeQuery();
			// Chuyển dữ liệu qua Role entity
			while (resultSet.next()) {
				Role entity = new Role();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));

				roleList.add(entity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList;
	}

	public int addRole(Role role) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query ="INSERT INTO ROLE  (name , description) value (? ,?)";
		try {
			PreparedStatement statement =  conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2,role.getDescription());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int removeRole(int idRemove) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		
		String query = "DELETE FROM ROLE WHERE id=?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idRemove);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}

	public Role findById(int idEdit) {
		Connection conn = DbConnection.getConnection();
		String query = "SELECT * FROM ROLE WHERE id = ?";
		Role entity = entity = new Role();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idEdit);
			//thực thi lệnh truy vấn
			ResultSet resultSet = statement.executeQuery();
			//chuyển dữ liệu qua entity
			while(resultSet.next()) {
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public int editRole(Role role) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "UPDATE ROLE SET name = ? , description = ? WHERE id = ?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
}
