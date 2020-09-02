import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    @EmbeddedId
    private Id id;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Embeddable
    public static class Id implements Serializable {

        public Id(Student studentId, Course courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "student_id", insertable = false, updatable = false)
        private Student studentId;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id", insertable = false, updatable = false)
        private Course courseId;

        public Student getStudentId() {
            return studentId;
        }

        public void setStudentId(Student studentId) {
            this.studentId = studentId;
        }

        public Course getCourseId() {
            return courseId;
        }

        public void setCourseId(Course courseId) {
            this.courseId = courseId;
        }
    }
}