import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            DBConnect connect = new DBConnect();
            connect.init();
            Session session = connect.getSession();

            List<Purchase> purchase = session.createQuery("FROM Purchase", Purchase.class).getResultList();
            Transaction transaction = session.beginTransaction();

            for (Purchase purchaseList : purchase) {
                Student student = session.createQuery("FROM Student WHERE name = \'" +
                        purchaseList.getStudentName() + "\'", Student.class).getSingleResult();
                Course course = session.createQuery("FROM Course WHERE name = \'" +
                        purchaseList.getCourseName() + "\'", Course.class).getSingleResult();
                if (student != null && course != null) {
                    LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                    LinkedPurchaseList.Id id = new LinkedPurchaseList.Id(student, course);
                    linkedPurchaseList.setId(id);
                    linkedPurchaseList.setPrice(purchaseList.getPrice());
                    linkedPurchaseList.setSubscriptionDate(purchaseList.getSubscriptionDate());

                    session.save(linkedPurchaseList);
                    session.evict(linkedPurchaseList);
                }
            }

            transaction.commit();
            connect.sessionFactory.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
