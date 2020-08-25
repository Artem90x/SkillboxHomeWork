import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            DBConnect connect = new DBConnect();
            connect.init();
            Session session = connect.getSession();

            List<Purchase> purchase = session.createQuery("FROM PurchaseList", Purchase.class).getResultList();
            Transaction transaction = session.beginTransaction();

            purchase.forEach(purchaseList -> {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                Student student = session.createQuery("FROM Student WHERE name = \"" +
                        purchaseList.getStudentName() + "\"", Student.class).getSingleResult();
                Course course = session.createQuery("FROM Course WHERE name = \"" +
                        purchaseList.getCourseName() + "\"", Course.class).getSingleResult();
                LinkedPurchaseList.Id id = new LinkedPurchaseList.Id(student.getId(), course.getId());
                linkedPurchaseList.setId(id);
                linkedPurchaseList.setStudentName(student.getName());
                linkedPurchaseList.setCourseName(course.getName());
                linkedPurchaseList.setPrice(purchaseList.getPrice());
                linkedPurchaseList.setSubscriptionDate(purchaseList.getSubscriptionDate());
                session.save(linkedPurchaseList);
            });
            transaction.commit();
            connect.sessionFactory.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
