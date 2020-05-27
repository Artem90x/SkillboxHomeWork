package Company;

public class Operator implements Employee {
    private int salaryOperator;

    public Operator() {
        this.salaryOperator = (int) (20000 + 5000 * Math.random());
    }

    @Override
    public int getMonthSalary() {
        return salaryOperator;
    }
}
