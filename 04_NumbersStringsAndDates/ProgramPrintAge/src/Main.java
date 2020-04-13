import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy - EEE", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1991, Calendar.JANUARY, 18);

        Date date = new Date();
        Date your = calendar.getTime();
        int i = 0;

        while (date.compareTo(your) > 0)
        {
            System.out.println(i + dateFormat.format(your));
            calendar.add(Calendar.YEAR, 1);
            your = calendar.getTime();
            i++;
        }
    }
}
