package com.myclass.service;

import java.util.List;

import com.myclass.dto.ProjectDto;
import com.myclass.repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository projectRepository;
	public ProjectService() {
		projectRepository = new ProjectRepository();
	}
	
	public List<ProjectDto> getAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	public int deleteUser(int idDelete) {
		// TODO Auto-generated method stub
		
		return projectRepository.remove(idDelete);
	}

}
