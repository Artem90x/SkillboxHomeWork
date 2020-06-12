import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws MyException {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new MyException("Wrong Format. Correct format:\n" +
                    "\tadd Василий Петров vasily.petrov@gmail.com +79215637722");
        }

        if (!emailValid(components[2])) {
            throw new MyException("Wrong Email Format. Correct format:\n" +
                    "\tvasily.petrov@gmail.com");
        }

        if (!telephoneNumberValid(components[3])) {
            throw new MyException("Wrong Telephone Number Format. Correct format:\n" +
                    "\t+79215637722");
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public boolean emailValid(String email) {
        return email.matches("\\w+\\.?\\w+@\\w+\\.\\w{2,3}");
    }

    public boolean telephoneNumberValid(String telephoneNumber) {
        return telephoneNumber.matches("^\\+\\d{11}$");
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}