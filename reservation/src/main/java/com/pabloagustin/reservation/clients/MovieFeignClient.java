package com.pabloagustin.reservation.clients;

import com.pabloagustin.reservation.payloads.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(
		name = "movie",
		url = "${clients.movie.url}"
)
public interface MovieFeignClient {

	@GetMapping("/movies/{movieId}")
	Movie getMovieById(@PathVariable("movieId") Long movieId);
}
