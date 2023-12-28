package com.pabloagustin.user;

import com.pabloagustin.user.User;
import com.pabloagustin.user.UserRegistrationRequest;
import com.pabloagustin.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

	private final UserRepository userRepository;

	public void registerUser(UserRegistrationRequest userRegistrationRequest){

		if (userRepository.existsByEmail(userRegistrationRequest.email())){
			throw new RuntimeException("Email already taken");
		}

		User user = User.builder()
				.name(userRegistrationRequest.name())
				.lastname(userRegistrationRequest.lastname())
				.email(userRegistrationRequest.email())
				.build();

		userRepository.saveAndFlush(user);

	}

	public Optional<User> getUserById(Integer userId){
		return userRepository.findById(userId);
	}

}
