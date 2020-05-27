package Company;

public class Manager implements Employee {
    private int salaryManager;
    private int earnedMoney;

    public Manager() {
        this.earnedMoney = (int) (500000 * Math.random());
        this.salaryManager = (int) (50000 + this.earnedMoney * 0.05);
    }

    @Override
    public int getMonthSalary() {
        return salaryManager;
    }

    @Override
    public int getEarnedMoney() {
        return earnedMoney;
    }
}
