package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getCoursesOfinstractor {
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
        try { instrauctor instrauctor = new instrauctor("mai" , "salman" , "asalman@gmail.com");

            session.beginTransaction();
            int theId = 1;
            instrauctor instrauctor1 = session.get(org.example.instrauctor.class,theId);

            System.out.println("the id : "+instrauctor1);
            System.out.println("Cources "+instrauctor1.getCourses());
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
        connection.close();
    }
}