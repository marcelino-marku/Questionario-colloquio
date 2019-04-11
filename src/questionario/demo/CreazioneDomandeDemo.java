package questionario.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import questionario.entity.Domanda;

public class CreazioneDomandeDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Domanda.class)
								.buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creo la domanda");
			Domanda dmn = new Domanda("sono hibernate!! ", 2); 
			
			
			session.beginTransaction(); 
			
			System.out.println("Salvo la domanda");
			session.save(dmn); 
			
			session.getTransaction().commit();
			
			System.out.println("Fine");
		}finally {
			factory.close(); 
		}
	}

}
