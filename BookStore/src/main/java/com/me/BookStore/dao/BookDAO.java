package com.me.BookStore.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.me.BookStore.pojo.Books;

public class BookDAO {
	
	private final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public BookDAO() {
		
	}
	
    public int addBook(Books bk) throws Exception{
        try {
        	
        	Session session = sf.openSession();
        	
            Transaction tx = session.beginTransaction();
           
           
            session.save(bk);
            
            tx.commit();
            session.close();
            
            return 1;
            
        } catch (Exception ex) {
            System.out.println("Cannot save object" + ex.getMessage());
            return 0;
        } 

    }
	
}
