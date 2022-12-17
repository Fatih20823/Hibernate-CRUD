package com.sanaltur.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanaltur.hibernate.entity.Turbilet;

public class CreateSanalturDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Turbilet.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a turbilet object
			System.out.println("Creating new turbilet object...");
			Turbilet tempTurbilet = new Turbilet("Jack","Daniel",11,35);
			
			//start a transaction
			session.beginTransaction();
			
			//save the turbilet object
			System.out.println("Saving the turbilet...");
			session.save(tempTurbilet);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
