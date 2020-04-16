import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Список команд: \n" + "LIST - открыть весь список дел.\n" + "ADD - добавить дело.\n"
               +"ADD 4 Добавить дело на 4 место\n" + "EDIT - новое название дела.\n"
                + "DELETE - удалить дело." + "\n=======================\n");
        System.out.println("Вызовите команду: ");

        ArrayList<String> todoList = new ArrayList<>() {{
            add(0, "Сделать зарядку");
            add(1, "Принять душ");
            add(2, "Позавтракать");
            add(3, "Поработать");
            add(4, "Прогуляться");
        }};



        while (true) {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "LIST":
                    System.out.println("Список дел: \n" + todoList);
                    break;

                case "ADD":
                    System.out.println("Добавить дело: ");
                    todoList.add(scanner.nextLine());
                    System.out.println("Дело добавлено в конец списка!" + " номер в списке: " + todoList.size());
                    break;

                case "ADD 4":
                    System.out.println("Добавить дело на 4 место: ");
                    todoList.add(3, scanner.nextLine());
                    System.out.println("Дело добавлено!\n"+ todoList);
                    break;

                case "DELETE":
                    System.out.println("Удалить дело из списка: ");
                    todoList.remove(scanner.nextInt() - 1);
                    System.out.println("Дело успешно удалено!\n" + "Текущий список дел:\n" + todoList);
                    break;

                case "EDIT":
                    System.out.println("Выбрать дело: \n" + todoList);

                default:
                    System.out.println("Ошибка! Команда указана неправильно");
                    break;
            }
        }
    }
}
