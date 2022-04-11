package usantatecla.movies.v21;

public class NewReleaseMovie extends Movie{

    public NewReleaseMovie(String title) {
        super(title, MovieType.NEW_RELEASE);
    }

    public double getCharge(int daysRented) {
        return Movie.CHARGE_NEW_RELEASE;

    }
}
