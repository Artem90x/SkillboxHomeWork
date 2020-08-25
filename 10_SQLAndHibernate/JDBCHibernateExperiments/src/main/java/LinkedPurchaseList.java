import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class LinkedPurchaseList implements Serializable {

    @EmbeddedId
    private Id id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @OneToOne
    @JoinColumn(name = "student_name", updatable = false, insertable = false)
    private Student student;

    @OneToOne
    @JoinColumn(name = "course_name", updatable = false, insertable = false)
    private Course course;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Embeddable
    public static class Id implements Serializable {

        public Id(int studentId, int courseId) {}

        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;
        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
    }
}