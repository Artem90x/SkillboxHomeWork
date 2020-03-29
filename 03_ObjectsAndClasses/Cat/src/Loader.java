public class Loader {

    public static void main(String[] args) {

        Cat murka = new Cat();
        {
            murka.setColor(Color.BLACK);
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
            barsic.setColor(Color.GRAY);
            System.out.println("Barsic color: " + barsic.getColor());
            System.out.println("Barsic weight: " + barsic.getWeight());
            System.out.println("Barsic is alive? " + barsic.isAlive());
            barsic.feed(1000.2);
            System.out.println("Barsic feed and weight: " + barsic.getWeight());
            System.out.println();
        }

        Cat kisa = new Cat();
        {
            kisa.setColor(Color.WHITE);
            System.out.println("Kisa color: " + kisa.getColor());
            System.out.println("Kisa weight: " + kisa.getWeight());
            System.out.println("Kisa is alive? " + kisa.isAlive());
            kisa.feed(3000.25);
            System.out.println("Kisa feed and weight: " + kisa.getWeight());
            System.out.println();
        }

        Cat leopold = new Cat();
        {
            leopold.setColor(Color.ORANGE);
            System.out.println("Leopold color: " + leopold.getColor());
            System.out.println("Leopold weight: " + leopold.getWeight());
            System.out.println("Leopold is alive? " + leopold.isAlive());
            while (!leopold.getStatus().equals("Exploded")) {
                leopold.feed(3000.1);
            }
            System.out.println("Leopold weight: " + leopold.getWeight());
            System.out.println("Leopold: " + leopold.getStatus());
            System.out.println();
        }

        Cat moly = new Cat();
        {
            moly.setColor(Color.BROW);
            System.out.println("Moly weight: " + moly.getWeight());
            System.out.println("Moly is alive? " + moly.isAlive());
            moly.drink(100.2);
            System.out.println("Moly weight and drink: " + moly.getWeight());
            System.out.println();
        }

        Cat vasya = new Cat();
        {
            System.out.println("Vasya weight: " + vasya.getWeight());
            System.out.println("Vasya is alive? " + vasya.isAlive());
            vasya.feed(150.0);
            System.out.println("Vasya eaten food: " + vasya.getQuantityFood());
            System.out.println("Vasya weight: " + vasya.getWeight());
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

        Cat lapa = Cat.copy(barsic);
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
