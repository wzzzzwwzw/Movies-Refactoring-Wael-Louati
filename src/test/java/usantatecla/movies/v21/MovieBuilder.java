package usantatecla.movies.v21;

public class MovieBuilder {

	private String title;
	
	private Price price;

	private MovieType movieType;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder childrens() {
		this.price = new ChildrenPrice();
		return this;
	}
	
	public MovieBuilder regular() {
		this.price = new RegularPrice();
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.price = new NewReleasePrice();
		return this;
	}
	
	public Movie build() {
		return new Movie(this.title, new Price(), this.movieType);
	}
}
