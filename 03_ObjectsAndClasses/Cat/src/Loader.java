
public class Loader {
    public static void main(String[] args) {
        Cat murka = new Cat();
        System.out.println("Murka weight: " + murka.getWeight());
        while (!murka.getStatus().equals("Dead")) {
            murka.meow();
        }
        System.out.println("Murka weight: " + murka.getWeight());
        System.out.println();
        //=======================================================
        Cat barsic = new Cat();
        System.out.println("Barsic weight: " + barsic.getWeight());
        barsic.feed(1000.2);
        System.out.println("Barsic feed and weight: " + barsic.getWeight());
        System.out.println();
        //=======================================================
        Cat kisa = new Cat();
        System.out.println("Kisa weight: " + kisa.getWeight());
        kisa.feed(3000.25);
        System.out.println("Kisa feed and weight: " + kisa.getWeight());
        System.out.println();
        //=======================================================
        Cat leopold = new Cat();
        System.out.println("Leopold weight: " + leopold.getWeight());
        while (!leopold.getStatus().equals("Exploded")) {
            leopold.feed(3000.1);
        }
        System.out.println("Leopold weight: " + leopold.getWeight());
        System.out.println(leopold.getStatus());
        System.out.println();
        //=======================================================
        Cat moly = new Cat();
        System.out.println("Moly weight: " + moly.getWeight());
        moly.drink(100.2);
        System.out.println("Moly weight and drink: " + moly.getWeight());
        System.out.println();
    }
}
