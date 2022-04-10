package usantatecla.movies.v21;

public class RegularPrice extends Price {

	@Override
	public double getCharge(int daysRented) {
		double result = RegularPrice.CHARGE;
		if (daysRented > RegularPrice.DAYS_RENTED_THRESHOLD) {
			result += (daysRented - RegularPrice.DAYS_RENTED_THRESHOLD) * RegularPrice.EXTRA_CHARGE;
		}
		return result;
	}

}
