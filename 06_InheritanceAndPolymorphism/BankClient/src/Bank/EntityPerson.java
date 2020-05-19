package Bank;

public class EntityPerson extends Client {

    private static final double COMMISSION = 0.01;

    @Override
    public void addMoney(Double amount) {
        balance += amount;
    }

    @Override
    public void cashOut(Double amount) {
        if (amount < balance) {
            balance -= amount * (1 + COMMISSION);
        }
    }
}
