package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connecttion.DbConnection;
import com.myclass.dto.ProjectDto;
import com.myclass.entity.Project;

public class ProjectRepository {

	public List<ProjectDto> findAll() {
		// TODO Auto-generated method stub
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		Connection conn = DbConnection.getConnection();
		ProjectDto entity = null;
		String query = "SELECT PROJECT.id, PROJECT.name, PROJECT.description , PROJECT.startDate , PROJECT.endDate , PROJECT.createUser , USER.userName\r\n" + 
				" FROM PROJECT\r\n" + 
				" INNER JOIN USER\r\n" + 
				" ON PROJECT.createUser = USER.id";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				entity.setStartDate(resultSet.getString("startDate"));
				entity.setEndDate(resultSet.getString("endDate"));
				entity.setUserName(resultSet.getString("userName"));
				entity.setCreateUser(resultSet.getInt("createUser"));
				
				projectList.add(entity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectList;
	}

	public int remove(int idDelete) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "DELETE FROM PROJECT WHERE id=?";
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

	public int save(Project entity) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "INSERT INTO PROJECT (name , description , startDate , endDate , createUser) value ( ? , ? , ? , ? , ?)";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getDescription());
			statement.setString(3, entity.getStartDate());
			statement.setString(4, entity.getEndDate());
			statement.setInt(5, entity.getCreateUser());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public Project findById(int idEdit) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "SELECT * FROM PROJECT WHERE id=?";
		Project entity = null;
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idEdit);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				entity = new Project();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				entity.setStartDate(resultSet.getString("startDate"));
				entity.setEndDate(resultSet.getString("endDate"));
				entity.setCreateUser(resultSet.getInt("createUser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public int edit(Project project) {
		Connection conn = DbConnection.getConnection();
		String query = "UPDATE PROJECT SET  name= ? , description = ? , startDate = ? , endDate = ? , createUser = ? WHERE id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setString(3, project.getStartDate());
			statement.setString(4, project.getEndDate());
			statement.setInt(5, project.getCreateUser());
			statement.setInt(6, project.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}


}
