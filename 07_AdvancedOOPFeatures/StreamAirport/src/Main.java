import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import static java.time.temporal.ChronoUnit.HOURS;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream).sorted(Comparator.comparing(Flight::getDate))
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE)
                        && f.getDate().getTime() <= Instant.now().plus(2, HOURS).toEpochMilli()
                        && f.getDate().compareTo(date) > 0)
                .forEach(f -> System.out.println(dateFormat.format(f.getDate()) + "\t" + f.getAircraft().getModel()));
    }
}
