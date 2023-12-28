package com.pabloagustin.reservation.config;

import com.pabloagustin.reservation.clients.MovieFeignClient;
import com.pabloagustin.reservation.payloads.Movie;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieFeignConfiguration {


	public MovieFeignClient movieFeignClient() {
		return new MovieFeignClient() {
			@Override
			public Movie getMovieById(Long movieId) {
				// Provide a placeholder or throw an UnsupportedOperationException
				throw new UnsupportedOperationException("Method not implemented");
			}
		};
	}

}
