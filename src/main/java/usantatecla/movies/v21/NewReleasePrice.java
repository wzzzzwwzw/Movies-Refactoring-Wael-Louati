package usantatecla.movies.v21;

public class NewReleasePrice extends Price {

	private static final double CHARGE = 3;
	private static final int DAYS_RENTED_THRESHOLD = 1;
	private static final int FREQUENT_RENTER_POINTS = 2;
	
	@Override
	public double getCharge(int daysRented) {
		 return Price.CHARGE_NEW_RELEASE;
	}
	
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if (daysRented > Price.DAYS_RENTED_THRESHOLD) {
			return Price.FREQUENT_RENTER_POINTS_NEW_RELEASE;
		} else {
			return super.getFrequentRenterPoints(daysRented);
		}
	}

}
