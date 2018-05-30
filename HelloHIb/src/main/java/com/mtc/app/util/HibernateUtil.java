package com.mtc.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mtc.app.entity.Product;
//import com.mtc.app.entity.Supplier;

//import com.mtc.app.actionbazaar.Address;
//import com.mtc.app.actionbazaar.Bid;
//import com.mtc.app.actionbazaar.Bidder;
//import com.mtc.app.actionbazaar.Billing;
//import com.mtc.app.actionbazaar.Category;
//import com.mtc.app.actionbazaar.CreditCard;
//import com.mtc.app.actionbazaar.Item;
//import com.mtc.app.actionbazaar.Order;
//import com.mtc.app.actionbazaar.OrderStatus;
//import com.mtc.app.actionbazaar.Seller;
//import com.mtc.app.actionbazaar.User;
//import com.mtc.app.entity.Product;
//import com.mtc.app.entity.Supplier;

public class HibernateUtil {
	
	private final static SessionFactory SESSION_FACTORY;
	
	static {
		
		Configuration configuration = new Configuration();
		
		//loads hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		
		configuration.addAnnotatedClass(Product.class);
		//configuration.addAnnotatedClass(Supplier.class);
		
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
