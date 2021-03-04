package me.thewing.boardproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.thewing.boardproject.domain.User;
import me.thewing.boardproject.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

	private final UserService userService;

	@GetMapping("users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}
}
