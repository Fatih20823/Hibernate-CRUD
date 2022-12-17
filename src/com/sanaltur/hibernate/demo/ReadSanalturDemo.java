package com.sanaltur.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanaltur.hibernate.entity.Turbilet;

public class ReadSanalturDemo {

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
			Turbilet tempTurbilet = new Turbilet("Daffy","Duck",10,25);
			
			//start a transaction
			session.beginTransaction();
			
			//save the turbilet object
			System.out.println("Saving the turbilet...");
			System.out.println(tempTurbilet);
			session.save(tempTurbilet);
			
			// commit transaction
			session.getTransaction().commit();
			
			//MY NEW CODE
			
			// find out the customer's id: primary key
			System.out.println("Saved customer. Generated id: " + tempTurbilet.getBiletId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve customer based on the id: primary key
			System.out.println("\nGetting customer with id: " + tempTurbilet.getBiletId());
			
			Turbilet myCustomer = session.get(Turbilet.class, tempTurbilet.getBiletId());
			
			System.out.println("Get complate: " + myCustomer);
			
			//commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
