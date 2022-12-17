package com.sanaltur.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanaltur.hibernate.entity.Turbilet;

public class PrimaryKeySanalturDemo {

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
			Turbilet tempTurbilet = new Turbilet("Marlon","Brando",12,15);
			Turbilet tempTurbilet1 = new Turbilet("John","Date",01,25);
			Turbilet tempTurbilet2 = new Turbilet("Johnny","Gage",14,55);
			Turbilet tempTurbilet3 = new Turbilet("Sub","Zero",17,26);
			
			
			//start a transaction
			session.beginTransaction();
			
			//save the turbilet object
			System.out.println("Saving the turbilet...");
			session.save(tempTurbilet);
			session.save(tempTurbilet1);
			session.save(tempTurbilet2);
			session.save(tempTurbilet3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
