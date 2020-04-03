import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Напишите ваше ФИО:");
        String fullName  = reader.readLine();

        int lastIndex = fullName.indexOf(" ");
        int firstIndex = fullName.lastIndexOf(" ");

        String lastName = fullName.substring(0,lastIndex);
        String firstName = fullName.substring(lastIndex + 1, firstIndex);
        String otherName = fullName.substring(firstIndex + 1);

        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + otherName);
    }
}
