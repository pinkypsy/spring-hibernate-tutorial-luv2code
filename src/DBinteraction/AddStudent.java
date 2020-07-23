package DBinteraction;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

import static utils.DateUtils.*;

public class AddStudent {
    public static void main(String[] args) throws ParseException {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating new student object");
            Student student = new Student("Hour", "Man",
                                            "hours@tomidnight.com",parseDate("23/07/2020"));

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
