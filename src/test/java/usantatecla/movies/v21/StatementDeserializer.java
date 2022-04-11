package usantatecla.movies.v21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatementDeserializer {

    private static int CUSTOMER_LINE_POSITION_FROM_START = 0;
    private static int CUSTOMER_NAME_POSITION = 3;
    private static int TOTAL_CHARGE_LINE_POSITION_FROM_END = 2;
    private static int MOVIE_NAME_POSITION = 1;
    private static int MOVIE_CHARGE_POSITION = 2;
    private static int TOTAL_CHARGE_POSITION = 3;
    private static int FREQUENT_POINTS_POSITION = 2;

    private String customerName;
    private List<String> movieNames;
    private List<Double> movieCharges;
    private double totalCharge;
    private int frequentRenterPoints;

    public StatementDeserializer(String statement) {
        this.movieNames = new ArrayList<>();
        this.movieCharges = new ArrayList<>();
        this.deserialize(statement);
    }

    private void deserialize(String statement) {
        List<String> lines = Arrays.asList(statement.split("\n"));
        List<String> customerNameLine = Arrays.asList(lines.get(StatementDeserializer.CUSTOMER_LINE_POSITION_FROM_START).split(" "));
        this.customerName = customerNameLine.get(StatementDeserializer.CUSTOMER_NAME_POSITION);

        final int totalChargeLinePosition = lines.size() - StatementDeserializer.TOTAL_CHARGE_LINE_POSITION_FROM_END;
        for (int i = StatementDeserializer.CUSTOMER_LINE_POSITION_FROM_START + 1; i < totalChargeLinePosition; i++) {
            List<String> movieLine = Arrays.asList(lines.get(i).split("\t"));
            this.movieNames.add(movieLine.get(StatementDeserializer.MOVIE_NAME_POSITION));
            this.movieCharges.add(Double.parseDouble(movieLine.get(StatementDeserializer.MOVIE_CHARGE_POSITION)));
        }

        List<String> totalChargeLine = Arrays.asList(lines.get(totalChargeLinePosition).split(" "));
        this.totalCharge = Double.parseDouble(totalChargeLine.get(StatementDeserializer.TOTAL_CHARGE_POSITION));
        List<String> frequentRenterPointsLine = Arrays.asList(lines.get(lines.size() - 1).split(" "));
        this.frequentRenterPoints = Integer.parseInt(frequentRenterPointsLine.get(StatementDeserializer.FREQUENT_POINTS_POSITION));
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public List<String> getMovieNames() {
        return this.movieNames;
    }

    public List<Double> getMovieCharges() {
        return this.movieCharges;
    }

    public double getTotalCharge() {
        return this.totalCharge;
    }

    public int getFrequentRenterPoints() {
        return this.frequentRenterPoints;
    }
    
}
