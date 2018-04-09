/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Movie;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MovieDAO {

	private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public MovieDAO() {
    
    }
    
    
    
    public Boolean addMovie(Movie mv) throws Exception{
        try {
        	
        	Session session = sf.openSession();
        	
            Transaction tx = session.beginTransaction();
           
           
            session.save(mv);
            
            tx.commit();
            session.close();
            
            return true;
            
        } catch (Exception ex) {
            System.out.println("Cannot save object" + ex.getMessage());
            return false;
        } 

    }
    
    
    public List<Movie> searchMovie(String keyword, String choice) throws Exception{
        List<Movie> movieList = new ArrayList<Movie>();
//        Movie movie;
        
        String select_query= "from Movie where "+choice+"= :"+choice;
//        String select_query= "from Movie where title= :title";
        try {
        	
        	Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            
            Query q=session.createQuery(select_query);
            q.setString(choice,keyword);
//            q.setString("title", "Titanic");
            movieList = q.list();
            tx.commit();
            session.close();

        
            
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return movieList;
    }
        
    
}
