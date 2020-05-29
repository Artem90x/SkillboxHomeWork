import Company.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("OOO Company", 5000000);
        company.hireAll(staffList("Manager", 80, company));
        company.hireAll(staffList("Operator", 180, company));
        company.hireAll(staffList("TopManager", 10, company));
        System.out.println("Общее количество сотрудников: " + company.getEmployeesQuantity());

        System.out.println("15 самых высоких зарплат:");
        company.getTopSalaryStaff(15);
        System.out.println("\n30 самых низких зарплат:");
        company.getLowestSalaryStaff(30);


        int k = company.getEmployeesQuantity();
        for (int i = 0; i <= k / 2 - 1; i++) {
            company.fire(i, company);
        }
        System.out.println("\nОбщее количество сотрудников после увольнения: " + company.getEmployeesQuantity());
        System.out.println("15 самых высоких зарплат после увольнения:");
        company.getTopSalaryStaff(15);
        System.out.println("\n30 самых низких зарплат после увольнения:");
        company.getLowestSalaryStaff(30);
    }

    private static List<Employee> staffList(String employeeType, int Quantity, Company company) {
        List<Employee> staff = Arrays.asList(new Employee[Quantity]);
        switch (employeeType) {
            case "Manager":
                for (int i = 0; i < staff.size(); i++) {
                    staff.set(i, new Manager(company));
                }
                break;
            case "Operator":
                for (int i = 0; i < staff.size(); i++) {
                    staff.set(i, new Operator(company));
                }
                break;
            case "TopManager":
                for (int i = 0; i < staff.size(); i++) {
                    staff.set(i, new TopManager(company));
                }
                break;
        }
        return staff;
    }
}
