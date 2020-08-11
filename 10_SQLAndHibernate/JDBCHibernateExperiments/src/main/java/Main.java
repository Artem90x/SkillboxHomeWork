import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    private static final Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    public static SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    public static void main(String[] args) {

        try {
            Session session = sessionFactory.openSession();
            Course course = session.get(Course.class, 3);
            System.out.println(course.getName() + "\tКоличество студентов: "+ course.getStudentsCount());

            sessionFactory.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
