package usantatecla.movies.v21;

public  class Price {

	protected static final double CHARGE_REGULAR = 2.0;

	protected static final double EXTRA_CHARGE_REGULAR = 1.5;

	protected static final int DAYS_RENTED_THRESHOLD_REGULAR = 2;

    protected static final double CHARGE_NEW_RELEASE = 3;

	protected static final int DAYS_RENTED_THRESHOLD_NEW_RELEASE = 1;

	protected static final int FREQUENT_RENTER_POINTS_NEW_RELEASE = 2;

	private static final int FREQUENT_RENTER_POINTS = 1;

	protected static final double CHARGE_CHILDREN = 1.5;

	protected static final double EXTRA_CHARGE_CHILDREN = 1.5;

	protected static final int DAYS_RENTED_THRESHOLD_CHILDREN = 3;

	public double getCharge(int daysRented) {
		return 0;
	}

	public double getChargeRegular(int daysRented) {
		double result = Price.CHARGE_REGULAR;
		if (daysRented > Price.DAYS_RENTED_THRESHOLD_REGULAR) {
			result += (daysRented - Price.DAYS_RENTED_THRESHOLD_REGULAR) * Price.EXTRA_CHARGE_REGULAR;
		}
		return result;
	}

	public double getChargeNewReleases(int daysRented) {
		return Price.CHARGE_NEW_RELEASE;
	}

	public int getFrequentRenterPointsNewReleases(int daysRented) {
		if (daysRented > Price.DAYS_RENTED_THRESHOLD_NEW_RELEASE) {
			return Price.FREQUENT_RENTER_POINTS_NEW_RELEASE;
		} else {
			return this.getFrequentRenterPoints(daysRented);
		}
	}

	public double getChargeChildren(int daysRented) {
		double result = Price.CHARGE_CHILDREN;
		if (daysRented > Price.DAYS_RENTED_THRESHOLD_CHILDREN) {
			result += (daysRented - 1) * Price.EXTRA_CHARGE_CHILDREN;
		}
		return result;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		return Price.FREQUENT_RENTER_POINTS;
	}
}
