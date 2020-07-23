package DBinteraction;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            int id = 0;
            //get student id
            System.out.println("Student " + id + " is saved with ID: " + id);

            //get a new session and start transaction
            System.out.println("Get a new session and start transaction");
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("Retrieve student with ID: " + id);
            Student student1 = session.get(Student.class, id);
            // commit the transaction
            session.getTransaction().commit();

            System.out.println(student1);



        }finally {
            session.close();
        }


    }
}
