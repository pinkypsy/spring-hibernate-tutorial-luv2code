package DBinteraction;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

public class UpdateStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            int studentId = 5;

            session.beginTransaction();

            Student student = session.get(Student.class,studentId);

            student.setFirstName("Scooby");


            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            session.createQuery("update Student set email = 'foobar3@mail.com'").executeUpdate();

            session.getTransaction().commit();


            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            List students = session.createQuery("from Student").getResultList();

            displayStudents(students);


        }finally {
            session.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        int i = 0;
        for (Student s :
                students) {

            System.out.println((++i) + " " +  s);
        }
    }
}
