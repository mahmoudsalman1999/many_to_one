package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class deleteCoursesOfinstractor {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/onetomany?useSSL=false";
        String user = "root";
        String pass = "5826";
        Connection connection = DriverManager.getConnection(url , user , pass);
        if (connection!= null)
        {
            System.out.println("DOM .....");
        }
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(instrauctor.class)
                                .addAnnotatedClass(instraucrtor_Detail.class)
                                        .addAnnotatedClass(course.class)
                                                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            int theId = 2;
            course course = session.get(org.example.course.class,theId);
            System.out.println("deleted cource :  " + course);
            session.delete(course);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
        connection.close();
    }
}