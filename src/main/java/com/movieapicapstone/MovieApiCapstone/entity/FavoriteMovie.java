package com.movieapicapstone.MovieApiCapstone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class FavoriteMovie {
	@Id
	private int movieid;
	private String title;
	private String overview;
	private String releasedate;

	public FavoriteMovie() {

	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	public FavoriteMovie(int movieid, String title, String overview, String releasedate) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.overview = overview;
		this.releasedate = releasedate;
	}

	@Override
	public String toString() {
		return "FavoriteMovie [movieid=" + movieid + ", title=" + title + ", overview=" + overview + ", releasedate="
				+ releasedate + "]";
	}

}
