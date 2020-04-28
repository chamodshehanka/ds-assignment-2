package com.fantastic4.server.resources;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure(
                    "/com/fantastic4/server/config/hibernate.cfg.xml"
            ).buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
