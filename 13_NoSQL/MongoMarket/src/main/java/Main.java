import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CommandControl mongoControlCommand = new CommandControl();

        while (true) {
            String command = scanner.nextLine().trim();
            mongoControlCommand.execute(command);
        }
    }
}