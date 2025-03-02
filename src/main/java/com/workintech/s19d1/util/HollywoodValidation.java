package com.workintech.s19d1.util;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class HollywoodValidation {
    public static void validateMovie(Movie movie) {
        if (movie.getName() == null || movie.getName().isBlank()) {
            throw new ApiException("Movie name cannot be blank", HttpStatus.BAD_REQUEST);
        }
        if (movie.getDirectorName() == null || movie.getDirectorName().isBlank()) {
            throw new ApiException("Director name cannot be blank", HttpStatus.BAD_REQUEST);
        }
        if (movie.getRating() < 0 || movie.getRating() > 10) {
            throw new ApiException("Rating must be between 0 and 10", HttpStatus.BAD_REQUEST);
        }
        if (movie.getReleaseDate() == null) {
            throw new ApiException("Release date cannot be null", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateActor(Actor actor) {
        if (actor.getFirstName() == null || actor.getFirstName().isBlank()) {
            throw new ApiException("First name cannot be blank", HttpStatus.BAD_REQUEST);
        }
        if (actor.getLastName() == null || actor.getLastName().isBlank()) {
            throw new ApiException("Last name cannot be blank", HttpStatus.BAD_REQUEST);
        }
        if (actor.getGender() == null) {
            throw new ApiException("Gender cannot be null", HttpStatus.BAD_REQUEST);
        }
        if (actor.getBirthDate() == null) {
            throw new ApiException("Birth date cannot be null", HttpStatus.BAD_REQUEST);
        }
    }
}
