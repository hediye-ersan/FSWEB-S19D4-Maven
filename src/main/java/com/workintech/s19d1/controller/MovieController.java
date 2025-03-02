package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable long id){
        return movieService.findById(id);
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@RequestBody Movie movie, @PathVariable long id){
        return movieService.update(id, movie);
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestBody Movie movie){
        movieService.delete(movie);
        return "Movie with id " + movie + " has been deleted successfully.";
    }
}
