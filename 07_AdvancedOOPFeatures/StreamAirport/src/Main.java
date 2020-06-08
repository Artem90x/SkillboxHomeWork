import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.HOURS;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        Date dataPlus2Hours = calendar.getTime();

        airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .collect(Collectors.toList())
                .stream().filter(f -> (f.getType() == Flight.Type.ARRIVAL) &&
                (f.getDate().after(date)) && f.getDate().before(dataPlus2Hours))
                .sorted(Comparator.comparing(Flight::getDate))
                .forEach(f -> System.out.println(dateFormat.format(f.getDate()) + "\t" + f.getAircraft().getModel()));

//        airport.getTerminals().stream()
//                .map(Terminal::getFlights)
//                .flatMap(Collection::stream).sorted(Comparator.comparing(Flight::getDate))
//                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE)
//                        && f.getDate().getTime() <= Instant.now().plus(2, HOURS).toEpochMilli()
//                        && f.getDate().compareTo(date) > 0)
//                .forEach(f -> System.out.println(dateFormat.format(f.getDate()) + "\t" + f.getAircraft().getModel()));
    }
}
