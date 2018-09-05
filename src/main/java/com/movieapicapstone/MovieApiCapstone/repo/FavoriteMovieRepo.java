package com.movieapicapstone.MovieApiCapstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapicapstone.MovieApiCapstone.entity.FavoriteMovie;

public interface FavoriteMovieRepo extends JpaRepository<FavoriteMovie, Integer> {

}
