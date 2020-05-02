import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        TreeMap<String, String> phoneBookLIst = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (scanner.nextLine()) {
                case "LIST": {
                    System.out.println("Контакты телефонной книжки:");
                    printPhoneBook(phoneBookLIst);
                    break;
                }
                case "ADD": {
                    System.out.println("Добавить контакт: \n" +
                            "Пример ввода: Иван 89008882011");
                    String input = scanner.nextLine();
                    String[] parts = input.split("\\s");
                    String name = parts[0];
                    String number = parts[1];

                    if (name.matches("^[a-zA-Z-А-яА-Я\\s]+$")) { //Проверка имени
                        phoneBookLIst.containsKey(name);
                    } else {
                        System.out.println("Имя указано неверно!");

                    }

                    if (number.matches("-?[\\d]+")) { //Проверка номера телефона
                        phoneBookLIst.containsKey(number);
                    } else {
                        System.out.println("Номер телефона указан неверно!");
                    }
                    phoneBookLIst.put(name, number);
                    break;
                }
                case "HELP": {
                    System.out.println("Список вызываемых команд:\n" +
                            "LIST - вызвать список.\n" +
                            "ADD - добавить контакт.");
                    break;
                }
                default: {
                    System.out.println("Ошибка! Команда указана неправильно\n" +
                            "Команды можете узнать набрав HELP");
                    break;
                }
            }
        }
    }
    private static void printPhoneBook(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}