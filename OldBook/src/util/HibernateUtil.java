package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static{
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	public static Session openSession(){
		/*Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;*/
		return sessionFactory.openSession();
	}
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
}
