package com.sanaltur.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanaltur.hibernate.entity.Turbilet;

public class UpdateSanalturDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Turbilet.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int customerId =2;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction(); 
			
			// retrieve customer based on the id: primary key
			System.out.println("\nGetting customer with id: " + customerId);
			
			Turbilet myCustomer = session.get(Turbilet.class, customerId);
			
			System.out.println("Updating customer...");
			myCustomer.setMusteriAd("Scooby");
			
			//commit the transaction 
			session.getTransaction().commit();
	
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
