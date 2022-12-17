package com.sanaltur.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanaltur.hibernate.entity.Turbilet;

public class QuerySanalturDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Turbilet.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			//query customer
			List<Turbilet> theCustomer = session.createQuery("from Turbilet").list();
			
			// display turbilet
			displayTurbilet(theCustomer);
			
			//query customer: lastName = "Zero"
			theCustomer = session.createQuery("from Turbilet  where musteri_soyad='Zero'").list();
			
			// display the customer
			System.out.println("\n\nCustomer who have last name of Doe");
			displayTurbilet(theCustomer);
			
			// query customer: lastName='Doe' OR firstName='Daffy'
			theCustomer = session.createQuery("from Turbilet  where musteri_soyad='Date' OR musteri_ad='John'").list();
			
			System.out.println("\n\nCustomer who have last name of Date OR first name John");
			displayTurbilet(theCustomer);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}
	
	private static void displayTurbilet(List<Turbilet> theCustomer) {
		for (Turbilet tempCustomer : theCustomer) {
			System.out.println(tempCustomer);
		}
	}

}
