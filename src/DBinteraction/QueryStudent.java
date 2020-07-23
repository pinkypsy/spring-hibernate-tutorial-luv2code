package DBinteraction;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            System.out.println("All students:");
            displayStudents(students);

            System.out.println();

            System.out.println("Students with name Mango:");
            students = session.createQuery("from Student where firstName = 'Mango'").getResultList();
            displayStudents(students);

            System.out.println("Done!");


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
