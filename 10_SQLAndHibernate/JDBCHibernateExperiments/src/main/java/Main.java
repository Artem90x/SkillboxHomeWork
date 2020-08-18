import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        try {
            DBConnect connect = new DBConnect();
            connect.init();
            Session session = connect.getSession();
            Course course = session.get(Course.class, 3);
            System.out.println(course.getName() + "\tКоличество студентов: "+ course.getStudentsCount() + course.getTeacher().getName());
            connect.sessionFactory.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
