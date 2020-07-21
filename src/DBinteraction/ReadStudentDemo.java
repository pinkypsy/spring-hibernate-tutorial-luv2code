package DBinteraction;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
               .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating new student object");
            Student student = new Student("Mango", "Jerry", "mj@mail.com");

                        System.out.println("Begin transaction and save object name: " + student.getFirstName());
            session.beginTransaction();
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Done!");

            //get student id
            System.out.println("Student " + student.getFirstName() + " is saved with ID: " + student.getId());

            //get a new session and start transaction
            System.out.println("Get a new session and start transaction");
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("Retrieve student with ID: " + student.getId());
            Student student1 = session.get(Student.class, student.getId());
            // commit the transaction
            session.getTransaction().commit();

            System.out.println(student1);



        }finally {
            session.close();
        }


    }
}
