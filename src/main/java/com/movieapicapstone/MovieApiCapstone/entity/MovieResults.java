package com.movieapicapstone.MovieApiCapstone.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResults {

	private int page;
	private int total_results;
	@JsonProperty("results") // matches property in JSON data
	private ArrayList<Movie> results;

	public MovieResults() {

	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal_results() {
		return total_results;
	}

	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}

	public ArrayList<Movie> getResult() {
		return results;
	}

	public void setResult(ArrayList<Movie> result) {
		this.results = result;
	}

	@Override
	public String toString() {
		return "MovieResults [page=" + page + ", total_results=" + total_results + ", result=" + results + "]";
	}

}
