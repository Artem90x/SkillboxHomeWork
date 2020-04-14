import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Указать число массива: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        String[][] test = new String[number][number];

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {

                test[i][j] = " ";
                if (i == j) test[i][j] = "X";
                if (j == (number - 1 - i)) test[i][j] = "X";
            }
        }

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j]);
            }
            System.out.println();
        }
    }
}

