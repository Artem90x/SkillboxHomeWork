package Company;

public class TopManager implements Employee {
    private Company company;
    private int fixSalaryTopManager;

    public TopManager(Company company) {
        this.fixSalaryTopManager = (int) (100000 + Math.random() * 15000);
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        int salaryTopManager;
        if (company.getIncome() >= company.getCompanyIncomePlane()) {
            salaryTopManager = (int) (fixSalaryTopManager + 1.5 * fixSalaryTopManager);
        } else salaryTopManager = fixSalaryTopManager;
        return salaryTopManager;
    }
}
