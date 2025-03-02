package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(long id) {
        return movieRepository.findById(id).orElseThrow(()-> new ApiException("Movie is not found with id: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public Movie update(long id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie is not found with id: " + id));

        existingMovie.setName(movie.getName());
        existingMovie.setDirectorName(movie.getDirectorName());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setActors(movie.getActors());
        existingMovie.setRating(movie.getRating());

        return movieRepository.save(existingMovie);
    }
}
