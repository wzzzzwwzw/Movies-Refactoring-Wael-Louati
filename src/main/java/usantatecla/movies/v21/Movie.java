package usantatecla.movies.v21;

public class Movie {

	private Price price;

	private String title;

	private MovieType movieType;

	public Movie(String title, Price price, MovieType movieType) {
		this.title = title;
		this.price = price;
		this.movieType = movieType;
	}


	public double getCharge(int daysRented) {

		if(this.movieType == MovieType.REGULAR) {
			return price.getChargeRegular(daysRented);
		}
		else if(this.movieType == MovieType.NEW_RELEASE) {
			return price.getChargeNewReleases(daysRented);
		}
		else {
			return price.getChargeChildren(daysRented);
		}
	}
	
	public int getFrequentRenterPoints(int daysRented) {

		if(this.movieType == MovieType.NEW_RELEASE) {
			return price.getFrequentRenterPointsNewReleases(daysRented);
		}
		else {
			return price.getFrequentRenterPoints(daysRented);
		}
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
}
