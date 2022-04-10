package usantatecla.movies.v21;

public class RegularPrice extends Price {

	@Override
	public double getCharge(int daysRented) {
		double result = RegularPrice.EXTRA_CHARGE_REGULAR;
		if (daysRented > RegularPrice.DAYS_RENTED_THRESHOLD_NEW_RELEASE) {
			result += (daysRented - Price.DAYS_RENTED_THRESHOLD_REGULAR) * Price.EXTRA_CHARGE_REGULAR;
		}
		return result;
	}

}
