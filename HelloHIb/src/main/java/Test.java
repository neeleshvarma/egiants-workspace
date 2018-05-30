import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mtc.app.entity.Product;
import com.mtc.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Product product = session.get(Product.class,1);
		
		System.out.println("Id    : "+product.getId());
		System.out.println("Name  : "+product.getName());
		System.out.println("Price : "+product.getPrice());

		session.close();
		
		sessionFactory.close();
	}

}
