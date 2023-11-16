package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
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
        try { instrauctor instrauctor = new instrauctor("rahma" , "ashraf" , "asalman@gmail.com");
            instraucrtor_Detail detail = new instraucrtor_Detail("mai salman" , "10000");
            instrauctor.setInstraucrtorDetail(detail);
            session.beginTransaction();
            int theId = 2;
            instrauctor instrauctor1 = session.get(org.example.instrauctor.class,theId);
            //create course
           course courses = new course("jdbc");
            course courses1 = new course("C");
            //add
            instrauctor1.add(courses);
            instrauctor1.add(courses1);
            //save
            session.save(courses);
            session.save(courses1);


            session.getTransaction().commit();


        }finally {
            session.close();
            factory.close();
        }
        connection.close();
    }
}