import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> listEmail = new ArrayList<>() {{
            add(0, "petrov@mail.ru");
            add(1, "lola90@gmail.com");
            add(2, "tetov1141@mail.ru");
            add(3, "ivanov@gmail.com");
        }};

        while (true) {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "LIST":
                    System.out.println("Список электронных почт:");
                    for (int i = 0; i < listEmail.size(); i++) {
                        System.out.println(i + ". " + listEmail.get(i));
                    }
                    break;

                case "ADD":
                    System.out.println("Добавить e-mail:");
                    String input = scanner.nextLine();
                    if (input.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                    listEmail.add(input);
                    System.out.println("E-mail был добавлен!\n" + "Номер в списке: " + listEmail.size());
                }
                    else {
                        System.out.println("Формат e-mail указан не верно!\n" +
                                "Введите ADD и попробуйте еще раз");
                    }
                break;

                case "HELP":
                    System.out.println("Список вызываемых команд:\n" +
                            "LIST - вызвать список.\n" +
                            "ADD - добавить e-mail.");
                    break;

                default:
                    System.out.println("Ошибка! Команда указана неправильно\n" +
                            "Команд можете узнать набрав HELP");
                    break;
            }
        }
    }
}
