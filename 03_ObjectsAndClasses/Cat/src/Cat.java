

public class Cat {

    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    private double originWeight;
    private double weight;
    private double quantityFood;
    public static int count;
    private Color typeColor;
    private boolean alive;

    public static Cat copy(Cat cat) {
        Cat barsic = new Cat();
        barsic.weight = cat.getWeight();
        barsic.typeColor = cat.getColor();
        return barsic;
    }

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;

        quantityFood = 0.0;
        count++;
    }

    public Cat(Double weight) {

        this.weight = weight;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public Double getQuantityFood() {
        return quantityFood;
    }

    public void pee() {
        weight = weight - 100;
        System.out.println("Pee...");
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");

    }

    public void feed(Double amount) {
        weight = weight + amount;
        quantityFood = quantityFood + amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            count = --count;
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public void setColor(Color typeColor) {
        this.typeColor = typeColor;
    }

    public Color getColor() {
        return typeColor;
    }

    public boolean isAlive() {
        if (weight < MIN_WEIGHT) {
            return alive;
        } else if (weight > MAX_WEIGHT) {
            return alive;
        } else {
            return alive = true;
        }
    }
}