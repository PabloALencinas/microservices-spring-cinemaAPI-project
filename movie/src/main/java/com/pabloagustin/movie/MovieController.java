package com.pabloagustin.movie;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

	private final MovieService movieService;

	@PostMapping("/create")
	public void registerMovie(@RequestBody MovieRegistrationRequest request){
		log.info("New movie {} registration", request.getName());
		movieService.createMovie(request);
	}

	@GetMapping("/{movieId}")
	public Optional<Movie> getMovieById(@PathVariable Integer movieId){
		return movieService.getMovieById(movieId);
 	}

}
