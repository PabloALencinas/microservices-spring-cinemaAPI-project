package com.pabloagustin.movie;

import com.pabloagustin.movie.Movie;
import com.pabloagustin.movie.MovieRegistrationRequest;
import com.pabloagustin.movie.MovieRepository;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;

	public void createMovie(@Valid @RequestBody MovieRegistrationRequest movieRequest){

		Optional<Movie> currentMovie = movieRepository.findByName(movieRequest.getName());

		if(currentMovie.isEmpty()){
			Movie newMovie = new Movie();
			newMovie.setName(movieRequest.getName());
			newMovie.setDescription(movieRequest.getDescription());
			newMovie.setShowtimes(movieRequest.getShowtimes());

			movieRepository.save(newMovie);

		} else {
			throw new RuntimeException("Movie already created");
		}

	}

	public Optional<Movie> getMovieById(Integer movieId){
		return movieRepository.findById(movieId);
	}

}
