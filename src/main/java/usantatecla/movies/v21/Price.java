package usantatecla.movies.v21;

public abstract class Price {

	protected static final double CHARGE = 2.0;

	protected static final double EXTRA_CHARGE = 1.5;

	protected static final int DAYS_RENTED_THRESHOLD = 2;

	private static final int FREQUENT_RENTER_POINTS = 1;
	
	public abstract double getCharge(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented) {
		return Price.FREQUENT_RENTER_POINTS;
	}
}
