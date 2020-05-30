package Company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private int income;
    String nameCompany;
    int incomePlane = 5000000;
    private ArrayList<Employee> employees = new ArrayList();

    public Company(String nameCompany, int income) {
        this.nameCompany = nameCompany;
        this.income = income;
    }

    int getIncome() {
        return income;
    }

    int getCompanyIncomePlane() {
        return incomePlane;
    }

    public int getEmployeesQuantity() {
        return employees.size();
    }

    public void hire(Employee object) {
        income += object.getEarnedMoney();
        employees.add(object);
    }

    public void hireAll(List<Employee> staff) {
        for (Employee object : staff) {
            hire(object);
        }
    }

    public void fire(int number) {
        if (number < getEmployeesQuantity() & number >= 0) {
            employees.remove(number);
        }
    }

    private void getSalaryStaff(int count, Comparator comparator) {
        if (count <= getEmployeesQuantity() & count > 0) {
            ArrayList<Employee> SalaryList = new ArrayList<>(employees);

            SalaryList.sort(comparator);

            for (int i = 0; i < count; i++) {
                System.out.println(i + 1 + ". " + SalaryList.get(i).getMonthSalary() + " руб.");
            }
        } else
            System.out.println("Ошибка! Введено некорректоное количество сотрудников");
    }

    public void getTopSalaryStaff(int count) {

        getSalaryStaff(count, Comparator.reverseOrder());
    }

    public void getLowestSalaryStaff(int count) {

        getSalaryStaff(count, (Comparator<Employee>) (o1, o2) -> o2.compareToDesc(o1));
    }
}
