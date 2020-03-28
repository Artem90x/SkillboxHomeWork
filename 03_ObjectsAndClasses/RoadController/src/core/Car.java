package core;

public class Car {
    public String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public int height;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public double weight;

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }


    public boolean hasVehicle;

    public void setHasVehicle(Boolean type) {
        this.hasVehicle = true;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public boolean isSpecial;

    public void setSpecial(Boolean type) {
        this.isSpecial = true;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public String toString() {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
                special + "Автомобиль с номером " + number +
                ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}