package DBinteraction;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudent {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure()
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

           /* session.createQuery("delete Student where id = 7").executeUpdate();

            session.getTransaction().commit();*/

            Student student = session.get(Student.class,1);

            session.delete(student);

            session.getTransaction().commit();

        }finally {
            session.close();
        }

    }

}
