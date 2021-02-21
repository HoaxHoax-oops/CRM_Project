package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.dto.UserDto;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.UserRepository;

public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	public UserService() {
		userRepository = new UserRepository();
		roleRepository = new RoleRepository();
	}

	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
			List<UserDto> entities = userRepository.getAll();
//			List<UserDto> listUserDto = new ArrayList<UserDto>();
//			for (UserDto entity : entities) {
//				UserDto dto = new UserDto();
//				dto.setId(entity.getId());
//				dto.setEmail(entity.getEmail());
//				dto.setPassword(entity.getPassword());
//				dto.setFullname(entity.getFullname());
//				dto.setAddress(entity.getAddress());
//				dto.setRoleId(entity.getRoleId());
//				dto.setPhone(entity.getPhone());
//				dto.setUserName(entity.getUserName());
//				dto.setRoleDescription(entity.getRoleDescription());
//				//lấy ra thông tin role dựa vào khóa ngoại
//				Role role = roleRepository.findById(entity.getRoleId());
//				dto.setRoleDescription(role.getDescription());
//				
//				listUserDto.add(dto);
//			}

		// nếu chạy câu lệnh này thì k cần chạy vòng lặp trog service
		return entities;
	}

	public int saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		try {
			String hashed = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
			User entity = new User();
			entity.setEmail(userDto.getEmail());
			entity.setPassword(hashed);
			entity.setFullname(userDto.getFullname());
			entity.setAddress(userDto.getAddress());
			entity.setRoleId(userDto.getRoleId());
			return userRepository.addUser(entity);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	public int updateUser(UserDto userEditDto) {
		// TODO Auto-generated method stub
		try {
			User entity = userRepository.findById(userEditDto.getId());
			if (entity != null) {
				entity.setId(userEditDto.getId());
				entity.setEmail(userEditDto.getEmail());
				entity.setPassword(userEditDto.getPassword());
				entity.setFullname(userEditDto.getFullname());
				entity.setAddress(userEditDto.getAddress());
				entity.setRoleId(userEditDto.getRoleId());
			}
			;
			// nếu pass đc nhập => thay đổi pass
			if (userEditDto.getPassword().isEmpty()) {
				String hashed = BCrypt.hashpw(userEditDto.getPassword(), BCrypt.gensalt());
				entity.setPassword(hashed);
			}

			return userRepository.editUser(entity);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	public int deleteUser(int idDelete) {
		// TODO Auto-generated method stub
		return userRepository.remove(idDelete);
	}

	public UserDto getById(int idEdit) {
		// TODO Auto-generated method stub
		User entity = userRepository.findById(idEdit);
		UserDto dto = new UserDto(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getFullname(),
				entity.getAddress(), entity.getRoleId());

		return dto;
	}

}
