package usantatecla.movies.v21;

public class Movie {

	protected static final double CHARGE_REGULAR = 2.0;

	protected static final double EXTRA_CHARGE_REGULAR = 1.5;

	protected static final int DAYS_RENTED_THRESHOLD_REGULAR = 2;

	protected static final double CHARGE_NEW_RELEASE = 3;

	protected static final int DAYS_RENTED_THRESHOLD_NEW_RELEASE = 1;

	protected static final int FREQUENT_RENTER_POINTS_NEW_RELEASE = 2;

	protected static final double CHARGE_CHILDREN = 1.5;

	protected static final double EXTRA_CHARGE_CHILDREN = 1.5;

	protected static final int DAYS_RENTED_THRESHOLD_CHILDREN = 3;

	static final int FREQUENT_RENTER_POINTS = 1;


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
			return (int) price.getFrequentRenterPoints(daysRented);
		}
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
}
