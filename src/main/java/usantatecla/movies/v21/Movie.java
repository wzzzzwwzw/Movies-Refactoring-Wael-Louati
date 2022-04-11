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




	private String title;

	private MovieType movieType;

	public Movie(String title, MovieType movieType) {
		this.title = title;

		this.movieType = movieType;
	}


	public double getCharge(int daysRented) {

		if(this.movieType == MovieType.REGULAR) {
			return this.getChargeRegular(daysRented);
		}
		else if(this.movieType == MovieType.NEW_RELEASE) {
			return this.getChargeNewReleases(daysRented);
		}
		else {
			return this.getChargeChildren(daysRented);
		}
	}

	public double getChargeRegular(int daysRented) {
		double result = Movie.CHARGE_REGULAR;
		if (daysRented > Movie.DAYS_RENTED_THRESHOLD_REGULAR) {
			result += (daysRented - Movie.DAYS_RENTED_THRESHOLD_REGULAR) * Movie.EXTRA_CHARGE_REGULAR;
		}
		return result;
	}

	public double getChargeNewReleases(int daysRented) {
		return Movie.CHARGE_NEW_RELEASE;
	}

	public double getChargeChildren(int daysRented) {
		double result = Movie.CHARGE_CHILDREN;
		if (daysRented > Movie.DAYS_RENTED_THRESHOLD_CHILDREN) {
			result += (daysRented - 1) * Movie.EXTRA_CHARGE_CHILDREN;
		}
		return result;
	}
	
	public int getFrequentRenterPoints(int daysRented) {

		if(this.movieType == MovieType.NEW_RELEASE) {
			return this.getFrequentRenterPointsNewReleases(daysRented);
		}
		else {
			return Movie.FREQUENT_RENTER_POINTS;
		}
	}
	public int getFrequentRenterPointsNewReleases(int daysRented) {
		if (daysRented > Movie.DAYS_RENTED_THRESHOLD_NEW_RELEASE) {
			return Movie.FREQUENT_RENTER_POINTS_NEW_RELEASE;
		} else {
			return Movie.FREQUENT_RENTER_POINTS;
		}
	}


	
	public String getTitle() {
		return title;
	}
	
}
