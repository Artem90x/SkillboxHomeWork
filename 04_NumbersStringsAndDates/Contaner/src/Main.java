import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int box;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many boxes do you need to deliver?");
        box = scanner.nextInt();

        Cargo cargo = new Cargo(box);
        System.out.println("To deliver the boxes(" + cargo.getBox() + ") you will need: \n" + "Truck: " + cargo.getTruck() + "\nContainer: " + cargo.getContainer());
        System.out.println("===================================");
        cargo.result();
    }

    public static class Cargo {
        private int truck;
        private int container;
        private int box;

        public Cargo(int box) {
            this.box = box;
            if (box != 0) {
                container = box % 27 == 0 ? box / 27 : box / 27 + 1;
            }
            if (container != 0) {
                truck = container % 12 == 0 ? container / 12 : container / 12 + 1;
            }
        }

        public int getTruck() {
            return truck;
        }

        public int getContainer() {
            return container;
        }

        public int getBox() {
            return box;
        }

        public void result() {
            int b = 1;
            int c = 1;
            for (int i = 1; i <= truck; i++) {
                System.out.println("Truck number: " + i);
                int j = 0;
                while (j < 12 && c <= container) {
                    System.out.println("    Container number: " + c);
                    int k = 0;
                    while (k < 27 && b <= box) {
                        System.out.println("      Box number: " + b);
                        k++;
                        b++;
                    }
                    j++;
                    c++;
                    System.out.println();
                }
            }
        }
    }
}