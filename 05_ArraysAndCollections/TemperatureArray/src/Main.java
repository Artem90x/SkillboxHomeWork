import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main (String [] args) {

        Double[] temperatures = {32.1, 32.2, 33.5, 34.6, 35.7, 36.3, 36.6, 36.9, 37.8, 38.2,
        35.3, 34.9, 40.0, 39.1, 39.6, 38.3, 36.7, 34.4, 36.3, 35.5,
        39.1, 35.1, 32.9, 33.8, 34.7, 37.2, 35.8, 38.1, 39.9, 36.0};

        int numberHealthyPeople = (int) Arrays.stream(temperatures)
                .filter(t -> t >= 36.2 && t <= 36.9)
                .count();

        Double average = Arrays.stream(temperatures)
                .collect( Collectors.averagingDouble(value -> value));

        System.out.printf("Средняя температра: %1.1f\n", average);
        System.out.println("Количество здоровых людей: " + numberHealthyPeople);
    }
}
