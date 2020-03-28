import com.skillbox.airport.Airport;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts().forEach(System.out::println);
        System.out.println(airport.getAllAircrafts().size());
    }
}
