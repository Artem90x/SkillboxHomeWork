package Bank;

public class PhysicalPerson extends Client {

    @Override
    public void addMoney(Double amount) {
        balance += amount;
    }

    @Override
    public void cashOut(Double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
