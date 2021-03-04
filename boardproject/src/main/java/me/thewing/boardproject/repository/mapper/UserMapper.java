package me.thewing.boardproject.repository.mapper;

import me.thewing.boardproject.domain.User;

public interface UserMapper {
	User findById(Long id);
}
