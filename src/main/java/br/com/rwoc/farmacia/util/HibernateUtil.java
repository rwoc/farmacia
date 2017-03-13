package br.com.rwoc.farmacia.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	public static SessionFactory fabricaDeSessoes = CriarFabricaDeSessoes();
	
	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
	
	private static SessionFactory CriarFabricaDeSessoes(){
		try {
			Configuration configuracao = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			return fabrica;
			 
		} catch (Throwable ex) {
			System.err.println("A Fábrica de sessões não pôde ser criada"+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
