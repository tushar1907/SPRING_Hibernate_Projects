package com.me.BookStore.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.BookStore.dao.BookDAO;
import com.me.BookStore.pojo.Books;

import sun.misc.BASE64Decoder;

@Controller
public class BookController {
	
	@Autowired
	@Qualifier("bkdao")
	BookDAO bkdao;
	
	@RequestMapping(value="/addBooks", method=RequestMethod.GET)
	public ModelAndView askForPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String auth = request.getHeader("Authorization");
		
		if(auth == null) {
			response.setStatus(response.SC_UNAUTHORIZED); // I.e., 401
			 response.setHeader("WWW-Authenticate",
			 "BASIC realm=\"Insider-Trading\"");
		}
		
		else {
			String userInfo = auth.substring(6).trim();
			 BASE64Decoder decoder = new BASE64Decoder();
			 String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
			 // Decoded part looks like "username:password".
			 int index = nameAndPassword.indexOf(":");
			 String user = nameAndPassword.substring(0, index);
			 String password = nameAndPassword.substring(index+1);
			 
			 if(user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			 auth = "";
			 int count = Integer.parseInt(request.getParameter("Book_quant"));
			 return new ModelAndView("addBooks","count", count);
			 }
			 else {
				 auth = "";
				 return new ModelAndView("resultView", "msg", "Login failed");
			 }
		}
		
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		return new ModelAndView("resultView", "msg", "Login failed");
	}
	
	@RequestMapping(value="/saveBooks")
	public ModelAndView saveBooks(@RequestParam("isbn") String[] isbn, @RequestParam("title")String [] title, @RequestParam("authors")String[] authors,
									@RequestParam("price")String []price) {
		int count=0;
		try {				
			for(int i = 0; i < isbn.length; i++) {
				if(!(isbn[i].equals(""))) {
					System.out.println("Here A");
					Books b = new Books();
					System.out.println(isbn[i]);
					b.setIsbn(isbn[i]);
					b.setTitle(title[i]);
					b.setAuthors(authors[i]);
					b.setPrice(Float.parseFloat(price[i]));
					System.out.println("A");
					count += bkdao.addBook(b);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("result", "errorMessage", "Error while saving Books");
		}
		
		return new ModelAndView("resultView", "msg", "Books saved !!");
	}

}
