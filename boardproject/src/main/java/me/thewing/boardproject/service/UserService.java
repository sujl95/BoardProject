package me.thewing.boardproject.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.thewing.boardproject.domain.User;
import me.thewing.boardproject.repository.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;

	public User findById(Long id) {
		
		return userMapper.findById(id);
	}
}
