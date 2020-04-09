import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Укажите ваш номер телефона:");
        String phone = reader.readLine();
//        System.out.println(phone.replaceAll("^((8|\\+7)[\\- ]?)?[\\d\\- ]{7,10}$", ""));

        System.out.println(phone
                .replaceAll("[^\\d]", "")
                .replaceAll("(\\d)(\\d{10})", "+7$2"));



    }
}