package usantatecla.movies.v21;

public class ChildrenPrice extends Price {

	
	@Override
	public double getCharge(int daysRented) {
		double result = Price.CHARGE_CHILDREN;
		if (daysRented > Price.DAYS_RENTED_THRESHOLD_CHILDREN) {
			result += (daysRented - 1) * Price.EXTRA_CHARGE_CHILDREN;
		}
		return result;
	}



}
