package com.pabloagustin.reservation.config;

import com.pabloagustin.reservation.clients.UserFeignClient;
import com.pabloagustin.reservation.payloads.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFeignConfiguration {


	public UserFeignClient userFeignClient() {
		return new UserFeignClient() {
			@Override
			public User getUserById(Long userId) {
				// Provide a placeholder or throw an UnsupportedOperationException
				throw new UnsupportedOperationException("Method not implemented");
			}
		};
	}
}
