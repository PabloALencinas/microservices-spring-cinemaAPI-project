package com.pabloagustin.user;

import java.util.Set;

public record UserRegistrationRequest(
		String name,
		String lastname,
		String email
) {
}
