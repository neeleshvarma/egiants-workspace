package com.mtc.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {
	
	private final static SessionFactory SESSION_FACTORY;
	
	static {
		
		Configuration configuration = new Configuration();
		
		//loads hibernate.cfg.xml
		configuration.configure();
		
		configuration.addAnnotatedClass(Product.class);
//		configuration.addAnnotatedClass(Supplier.class);
		
//		configuration.addAnnotatedClass(Address.class);
//		configuration.addAnnotatedClass(Bid.class);
//		configuration.addAnnotatedClass(Bidder.class);
//		configuration.addAnnotatedClass(Billing.class);
//		configuration.addAnnotatedClass(Category.class);
//		configuration.addAnnotatedClass(CreditCard.class);
//		configuration.addAnnotatedClass(Item.class);
//		configuration.addAnnotatedClass(Order.class);		
//		configuration.addAnnotatedClass(Seller.class);
//		configuration.addAnnotatedClass(User.class);
		
		
		//starts hibernate services essential to work with hibernate framework
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		SESSION_FACTORY  = configuration.buildSessionFactory(serviceRegistry);
		
		
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
