public class Loader {

    public static void main(String[] args) {

        Cat murka = new Cat();
        {
            murka.setColor("BLACK");
            System.out.println("Murka color: " + murka.getColor());
            System.out.println("Murka weight: " + murka.getWeight());
            while (!murka.getStatus().equals("Dead")) {
                murka.meow();
            }
            System.out.println("Murka weight: " + murka.getWeight());
            System.out.println("Murka: " + murka.getStatus());
            System.out.println("Murka is alive? " + murka.isAlive());
            System.out.println();
        }

        Cat barsic = new Cat();
        {
            barsic.setColor("GRAY");
            System.out.println("Barsic color: " + barsic.getColor());
            System.out.println("Barsic weight: " + barsic.getWeight());
            barsic.feed(1000.2);
            System.out.println("Barsic feed and weight: " + barsic.getWeight());
            System.out.println("Barsic is alive? " + barsic.isAlive());
            System.out.println();
        }

        Cat kisa = new Cat();
        {
            kisa.setColor("WHITE");
            System.out.println("Kisa color: " + kisa.getColor());
            System.out.println("Kisa weight: " + kisa.getWeight());
            kisa.feed(3000.25);
            System.out.println("Kisa feed and weight: " + kisa.getWeight());
            System.out.println("Kisa is alive? " + kisa.isAlive());
            System.out.println();
        }

        Cat leopold = new Cat();
        {
            System.out.println("Leopold weight: " + leopold.getWeight());
            while (!leopold.getStatus().equals("Exploded")) {
                leopold.feed(3000.1);
            }
            System.out.println("Leopold weight: " + leopold.getWeight());
            System.out.println("Leopold: " + leopold.getStatus());
            System.out.println("Leopold is alive? " + leopold.isAlive());
            System.out.println();
        }

        Cat moly = new Cat();
        {
            System.out.println("Moly weight: " + moly.getWeight());
            moly.drink(100.2);
            System.out.println("Moly weight and drink: " + moly.getWeight());
            System.out.println("Moly is alive? " + moly.isAlive());
            System.out.println();
        }

        Cat vasya = new Cat();
        {
            System.out.println("Vasya weight: " + vasya.getWeight());
            vasya.feed(150.0);
            System.out.println("Vasya eaten food: " + vasya.getQuantityFood());
            System.out.println("Vasya weight: " + vasya.getWeight());
            System.out.println("Vasya is alive? " + vasya.isAlive());
            System.out.println();
        }

        Cat serega = new Cat();
        {
            System.out.println("Serega weight: " + serega.getWeight());
            for (int i = 0; i < 3; i++) {
                serega.pee();
            }
            System.out.println("Serega weight: " + serega.getWeight());
            System.out.println("Serega is alive? " + serega.isAlive());
            System.out.println();
        }

        getKitten();
        {
            System.out.println();
        }

        Cat lapa = new Cat(2000.2, "BLACK");
        {
            System.out.println("Lapa color: " + lapa.getColor());
            System.out.println("Lapa weight: " + lapa.getWeight());
            System.out.println();
        }

        System.out.println("How many live cats are left: " + Cat.getCount());
        System.out.println("Cat eyes count: " + Cat.EYES_COUNT);
    }

    public static Cat getKitten() {
        Cat kitten = new Cat(1100.0);
        System.out.println("Kitten weight: " + kitten.getWeight());
        System.out.println("Kitten is alive? " + kitten.isAlive());
        return kitten;
    }
}
