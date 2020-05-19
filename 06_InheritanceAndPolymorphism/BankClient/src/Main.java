import Bank.Client;
import Bank.EntityPerson;
import Bank.IndividualEntrepreneur;
import Bank.PhysicalPerson;

public class Main {
    public static void main(String[] args) {

        Client physical = new PhysicalPerson();
        physical.addMoney(10000.0);
        physical.cashOut(3500.0);
        System.out.println("Баланс физического лица: " + physical.getBalance());

        Client entity = new EntityPerson();
        entity.addMoney(500000.0);
        entity.cashOut(300000.0);
        System.out.println("Баланс юридического лица: " + entity.getBalance());

        Client individual = new IndividualEntrepreneur();
        individual.addMoney(140000.0);
        individual.cashOut(50000.0);
        System.out.println("Баланс индивидуального предпринимателя: " + individual.getBalance());
    }
}
