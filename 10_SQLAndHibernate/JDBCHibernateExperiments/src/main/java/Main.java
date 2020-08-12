import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        try {
            Session session = DBConnect.sessionFactory().openSession();
            Course course = session.get(Course.class, 3);
            System.out.println(course.getName() + "\tКоличество студентов: "+ course.getStudentsCount());

            DBConnect.sessionFactory().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
