package Company;

public class Manager implements Employee {
    Company company;
    private int salaryManager;
    private int earnedMoney;

    public Manager(Company company) {
        this.earnedMoney = (int) (500000 * Math.random());
        this.salaryManager = (int) (50000 + this.earnedMoney * 0.05);
        this.company = company;
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
