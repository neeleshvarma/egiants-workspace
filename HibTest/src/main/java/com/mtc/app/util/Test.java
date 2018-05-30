package com.mtc.app.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import com.mtc.app.entity.Product;
import com.mtc.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
	//	Product product = session.get(Product.class,1);
		
		Product product = (Product) session.get(Product.class, 1);
		
    	System.out.println("Id    : "+product.getId());
		System.out.println("Name  : "+product.getName());
		System.out.println("Price : "+product.getPrice());
		System.out.println("description : "+product.getDescription());
		

		session.close();
		
		sessionFactory.close();
	}

}
