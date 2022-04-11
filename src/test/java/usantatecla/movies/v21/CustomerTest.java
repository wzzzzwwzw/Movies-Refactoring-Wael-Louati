package usantatecla.movies.v21;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

	private static String CUSTOMER_NAME = "customerName";

	private usantatecla.movies.v21.CustomerBuilder getCustomerBuilder() {
		return new usantatecla.movies.v21.CustomerBuilder().name(CustomerTest.CUSTOMER_NAME);
	}

	private usantatecla.movies.v21.StatementBuilder getStatementBuilder() {
		return new usantatecla.movies.v21.StatementBuilder().customerName(CustomerTest.CUSTOMER_NAME);
	}

	@Test
	public void givenCustomerWhenStatementThenCorrectCustomerName() {
		Customer customer = this.getCustomerBuilder().build();

		String statement = customer.statement();

		assertEquals(new usantatecla.movies.models.StatementDeserializer(statement).getCustomerName(), customer.getName());
	}

	@Test
	public void givenCustomerWhenStatementThenCorrectMovieName() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertEquals(new usantatecla.movies.models.StatementDeserializer(statement).getMovieNames().get(0), movieName);
	}

	@Test
	public void givenCustomerWithoutRentalsWhenStatementThenCorrectTotalAmount() {
		Customer customer = this.getCustomerBuilder().build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 0);
	}

	@Test
	public void givenCustomerWithoutRentalsWhenStatementThenCorrectFrequentRenterPoints() {
		Customer customer = this.getCustomerBuilder().build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 0);
	}

	@Test
	public void givenCustomerWith1DayRentalWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 2);
	}

	@Test
	public void givenCustomerWith1DayRentalWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 1);
	}

	@Test
	public void givenCustomerWith2DayRentalWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 2);
	}

	@Test
	public void givenCustomerWith2DayRentalWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 1);
	}

	@Test
	public void givenCustomerWith3DayRentalWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 3.5);
	}

	@Test
	public void givenCustomerWith3DayRentalWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 1);
	}

	@Test
	public void givenCustomerWithNewReleaseMovie1RentalDayWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 3);
	}

	@Test
	public void givenCustomerWithNewReleaseMovie1RentalDayWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 1);
	}

	@Test
	public void givenCustomerWithNewReleaseMovie2RentalDayWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 3);
	}

	@Test
	public void givenCustomerWithNewReleaseMovie2RentalDayWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 2);
	}

	@Test
	public void givenCustomerWithNewReleaseMovie3RentalDayWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 3);
	}

	@Test
	public void givenCustomerWithNewReleaseMovie3RentalDayWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 2);
	}
	
	@Test
	public void givenCustomerWithChildrenMovie1RentalDayWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 1.5);
	}

	@Test
	public void givenCustomerWithChildrenMovie1RentalDayWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 1);
	}

	@Test
	public void givenCustomerWithChildrenMovie3RentalDayWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 1.5);
	}

	@Test
	public void givenCustomerWithChildrenMovie3RentalDayWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 1);
	}

	@Test
	public void givenCustomerWithChildrenMovie4RentalDayWhenStatementThenCorrectTotalAmount() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(4).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getTotalCharge() == 6);
	}

	@Test
	public void givenCustomerWithChildrenMovie4RentalDayWhenStatementThenCorrectFrequentRenterPoints() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new usantatecla.movies.v21.RentalBuilder().movie(movie).daysRented(4).build();
		Customer customer = this.getCustomerBuilder().rental(rental).build();

		String statement = customer.statement();

		assertTrue(new usantatecla.movies.models.StatementDeserializer(statement).getFrequentRenterPoints() == 1);
	}
	
	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).regular().build();
		Rental regularRental = new usantatecla.movies.v21.RentalBuilder().movie(regularMovie).daysRented(10).build();
		
		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();
		Rental newReleaseRental = new usantatecla.movies.v21.RentalBuilder().movie(newReleaseMovie).daysRented(10).build();
		
		String childrensMovieName = "childrensMovieName";
		Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();
		Rental childrensRental = new usantatecla.movies.v21.RentalBuilder().movie(childrensMovie).daysRented(10).build();
		
		Customer customer = this.getCustomerBuilder()
				.rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

		String statement = customer.statement();

		String result = this.getStatementBuilder()
				.movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}
	
	
}
