package Company;

public class Operator implements Employee {
    Company company;
    private int salaryOperator;

    public Operator(Company company) {
        this.salaryOperator = (int) (20000 + 5000 * Math.random());
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return salaryOperator;
    }
}
