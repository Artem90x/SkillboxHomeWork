import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int box;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько ящиков отправить?");
        box = scanner.nextInt();

        Loading loading = new Loading(box);
        loading.result();
    }

    public static class Loading {
        private int truck;
        private int container;
        private int box;

        public Loading(int box) {
            this.box = box;
            if (box != 0) {
                container = box % 27 == 0 ? box / 27 : box / 27 + 1;
            }
            if (container != 0) {
                truck = container % 12 == 0 ? container / 12 : container / 12 + 1;
            }
        }

        public void result() {
            int a = 1;
            int b = 1;
            for (int i = 1; i <= truck; i++) {
                System.out.println("Truck number: " + i);
                int c = 0;
                while (c < 12 && b <= container) {
                    System.out.println("    Container number: " + b);
                    int d = 0;
                    while (d < 27 && a <= box) {
                        System.out.println("      Box number: " + a);
                        d++;
                        a++;
                    }
                    c++;
                    b++;
                    System.out.println();
                }
            }
        }
    }
}