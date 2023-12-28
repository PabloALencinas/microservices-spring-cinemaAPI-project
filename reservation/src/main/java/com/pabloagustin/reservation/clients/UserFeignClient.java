package com.pabloagustin.reservation.clients;

import com.pabloagustin.reservation.payloads.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(
		name = "user",
		url = "${clients.user.url}"
)
public interface UserFeignClient {

	@GetMapping("/{userId}")
	User getUserById(@PathVariable("userId") Long userId);
}
