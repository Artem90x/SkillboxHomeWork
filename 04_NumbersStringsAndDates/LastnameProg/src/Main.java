import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Напишите ваше ФИО:");
        String fullName = reader.readLine();

        for (String retval : fullName.split(" ", 3)) {
            System.out.println(retval); }

        int lastIndex = fullName.indexOf(" ");
        int firstIndex = fullName.lastIndexOf(" ");

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(fullName);

        if (m.find()) {
            System.out.println("Ошибка! Данные не соответствуют формату");
        } else {
            System.out.println("");

            String lastName = fullName.substring(0, lastIndex);
            String firstName = fullName.substring(lastIndex + 1, firstIndex);
            String otherName = fullName.substring(firstIndex + 1);

            System.out.println("Фамилия:" + lastName);
            System.out.println("Имя:" + firstName);
            System.out.println("Отчество:" + otherName);
        }
    }
}
