package questionario.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import questionario.entity.Domanda;
import questionario.entity.Risposta;
import questionario.entity.Tag;

@Controller
//@RequestMapping("/api/questionario")
public class LetturaQuestionarioController {

	@RequestMapping(value = "/questions", method=RequestMethod.POST)
	public String insertDomanda(HttpServletRequest request, Model model) {

		String testoDomanda = request.getParameter("domanda");
		int diffDomanda = Integer.parseInt(request.getParameter("diff"));
		String [] risposte =request.getParameterValues("risposte");
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Domanda.class)
				.addAnnotatedClass(Risposta.class)
				.addAnnotatedClass(Tag.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("Creo la domanda");

			Domanda domanda = new Domanda(testoDomanda, diffDomanda);

			//for (int i = 0; i < risposte.length; i++) {
				//domanda.addRisposta(new Risposta(risposte[i]));
			//}

			System.out.println("Salvo la domanda");
			session.save(domanda);
			
			for (int i = 0; i < risposte.length; i++) {
				Risposta ris= new Risposta(risposte[i]);
				ris.setDomanda(domanda);
				session.save(ris);
			}
			Tag tag = new Tag(request.getParameter("tag"));
			session.save(tag);
			session.getTransaction().commit();

			System.out.println("Fine");
		} finally {
			factory.close();
		}

		return "listadomande";
	}

	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public String leggi(Model model) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Domanda.class)
				.addAnnotatedClass(Risposta.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			
			
			
			List<Domanda> domande = session.createQuery("from Domanda").list();
			
			
			session.getTransaction().commit();
			model.addAttribute("domande", domande);
			
		}finally {
			
			
			factory.close();
		}
		
		return "listadomande";
	}
	
	@RequestMapping("/inserimento")
	public String entraNellaInsert(Model model) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tag.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();
				
				session.beginTransaction();
				List<Tag> tags = session.createQuery("from Tag").list();
				
				model.addAttribute("tags", tags);
				session.getTransaction().commit();
				
				factory.close();
		return "newdomanda";
	}
}
