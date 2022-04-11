package usantatecla.movies.v21;

public class ChildrenMovie extends  Movie{

    public ChildrenMovie(String title) {
        super(title, MovieType.CHILDREN);
    }

    public double getCharge(int daysRented) {
        double result = Movie.CHARGE_CHILDREN;
        if (daysRented > Movie.DAYS_RENTED_THRESHOLD_CHILDREN) {
            result += (daysRented - 1) * Movie.EXTRA_CHARGE_CHILDREN;
        }
        return result;
    }
}

