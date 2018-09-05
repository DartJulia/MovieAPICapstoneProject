package com.movieapicapstone.MovieApiCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.movieapicapstone.MovieApiCapstone.entity.FavoriteMovie;
import com.movieapicapstone.MovieApiCapstone.entity.MovieResults;
import com.movieapicapstone.MovieApiCapstone.repo.FavoriteMovieRepo;

@Controller
public class MovieController {
	@Autowired
	FavoriteMovieRepo fmr;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/search")
	public ModelAndView searchTitle(@RequestParam("query") String query) {
		// Add headers to our API request - using a header object
		HttpHeaders headers = new HttpHeaders();
		// requirement from mashape website

		// headers.add("X-Mashape-Key", "1f4482bb6549bd63e26c3d56b8e5afd2");
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		// To attach headers to our requests, we need the HttpEntity
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		RestTemplate restTemp = new RestTemplate();
		// initial test to retrieve something from api
		// first param-url, action(GET or POST), entity used to add parameter for
		// headers, and then class to reference
		ResponseEntity<MovieResults> response = restTemp
				.exchange(
						"https://api.themoviedb.org/3/search/movie?api_key=1f4482bb6549bd63e26c3d56b8e5afd2&query="
								+ query,
						HttpMethod.GET, entity, MovieResults.class);
		// test to make sure we're getting data back
		System.out.println(response.getBody());
		return new ModelAndView("titleresults", "movie", response.getBody().getResult());
	}

	@RequestMapping("/genresearch")
	public ModelAndView searchTitle(@RequestParam("genreid") int query) {
		// Add headers to our API request - using a header object
		HttpHeaders headers = new HttpHeaders();

		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		// To attach headers to our requests, we need the HttpEntity
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		RestTemplate restTemp = new RestTemplate();
		// initial test to retrieve something from api
		// first param-url, action(GET or POST), entity used to add parameter for
		// headers, and then class to reference
		ResponseEntity<MovieResults> response = restTemp.exchange(
				"https://api.themoviedb.org/3/discover/movie?api_key=1f4482bb6549bd63e26c3d56b8e5afd2&with_genres="
						+ query,
				HttpMethod.GET, entity, MovieResults.class);
		// test to make sure we're getting data back
		System.out.println(response.getBody());
		return new ModelAndView("titleresults", "movie", response.getBody().getResult());
	}

	@RequestMapping("/favorite/{id}/{title}/{release_date}/{overview}/")
	public ModelAndView addFavoriteMovie(@PathVariable("id") Integer id, @PathVariable("title") String title,
			@PathVariable("release_date") String rd, @PathVariable("overview") String ovw) {

		FavoriteMovie movie = new FavoriteMovie(id, title, ovw, rd);
		fmr.save(movie);
		System.out.println(movie.toString());

		return new ModelAndView("redirect:/");

	}

	@RequestMapping("/favoritelist")
	public ModelAndView viewFavs() {
		return new ModelAndView("favlist", "movies", fmr.findAll());
	}

	@RequestMapping("{id}/delete")
	public ModelAndView deleteFavs(@PathVariable("id") Integer id) {
		fmr.deleteById(id);
		return new ModelAndView("redirect:/favoritelist");
	}
}
