package usantatecla.movies.v21;

public class NewReleaseMovie extends Movie{

    private static final int DAYS_RENTED_THRESHOLD = 1;

    private static final int FREQUENT_RENTER_POINTS = 2;

    public NewReleaseMovie(String title) {
        super(title, MovieType.NEW_RELEASE);
    }

    public double getCharge(int daysRented) {
        return Movie.CHARGE_NEW_RELEASE;

    }
    public int getFrequentRenterPoints(int daysRented) {

        if (daysRented > NewReleaseMovie.DAYS_RENTED_THRESHOLD) {
            return NewReleaseMovie.FREQUENT_RENTER_POINTS;
        } else {
            return Movie.FREQUENT_RENTER_POINTS;
        }
    }
}
