package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

public class RoleService {
	private RoleRepository roleRepository;
	
	public RoleService() {
		roleRepository = new RoleRepository();
	}

	public List<RoleDto> getAll(){
		//b1 goi ham chay cau lenh truy van lay du lieu
		List<Role> entities =  roleRepository.findAll(); // tra ve List<Role>
		//b2 mapping tham chieu du lieu tu entity sang dto
		List<RoleDto> listRoleDto = new ArrayList<RoleDto>();
		for (Role entity : entities) {
			RoleDto dto = new RoleDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setDescription(entity.getDescription());
			listRoleDto.add(dto);
		}
		//b3 tra ve dto
		return listRoleDto;
	}
	
	public RoleDto finById(int idEdit) {
		// TODO Auto-generated method stub
		Role entity = roleRepository.findById(idEdit);
		RoleDto roleDto = new RoleDto();
		
		roleDto.setId(entity.getId());
		roleDto.setName(entity.getName());
		roleDto.setDescription(entity.getDescription());
		return roleDto;
	}



	public int editRole(RoleDto roleDto) {
		// TODO Auto-generated method stub
		Role entity = roleRepository.findById(roleDto.getId());
		if(entity != null) {
		entity.setId(roleDto.getId());
		entity.setName(roleDto.getName());
		entity.setDescription(roleDto.getDescription());
	
		return roleRepository.editRole(entity);
		}
		return -1;
	}

	public int insert(RoleDto roleDto) {
		Role entity = new Role();
		entity.setName(roleDto.getName());
		entity.setDescription(roleDto.getDescription());
		
		return roleRepository.addRole(entity);
	}

	public int deleteRole(int idRemove) {
		Role entity = roleRepository.findById(idRemove);
		
		if (entity != null) 
			return roleRepository.removeRole(idRemove);
		
		return -1;
		
	}

}
