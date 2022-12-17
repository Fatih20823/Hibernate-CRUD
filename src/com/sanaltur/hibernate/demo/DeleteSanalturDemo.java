package com.sanaltur.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanaltur.hibernate.entity.Turbilet;

public class DeleteSanalturDemo {

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
			
			// Turbilet myCustomer = session.get(Turbilet.class, customerId);
			
			// delete the turbilet
			// System.out.println("Deleting turbilet: " + myCustomer);
			// session.delete(myCustomer);
			
			// delete turbilet id=2
			System.out.println("Deleting customer id=3");
						
			session.createQuery("delete from Turbilet where id=6").executeUpdate();
			
			
			//commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
