package com.pabloagustin.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

	@PostMapping("/create")
	public void registerUser(@RequestBody UserRegistrationRequest request){
		log.info("New user registration {}", request);
		userService.registerUser(request);
	}

	@GetMapping(path = "{userId}")
	public Optional<User> getUserById(@PathVariable("userId") Integer userId){
		return userService.getUserById(userId);
	}

}
