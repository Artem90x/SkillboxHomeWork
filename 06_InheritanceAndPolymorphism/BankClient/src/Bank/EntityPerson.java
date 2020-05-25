package Bank;

public class EntityPerson extends Client {

    protected static final double COMMISSION = 0.01;

    public EntityPerson(String name) {
        super(name);
    }

    @Override
    public void addMoney(Double amount) {
        super.addMoney(amount);
    }

    @Override
    public void cashOut(Double amount) {
        if (amount < balance) {
            super.cashOut(amount * (1 + COMMISSION));
        }
    }
}
