package DBinteraction;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
               .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating new student object");
            Student student = new Student("Jacob", "Fine", "jajaja@mail.com");

            System.out.println("Begin transaction and save object name: " + student.getFirstName());
            session.beginTransaction();
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            session.close();
        }


    }
}
