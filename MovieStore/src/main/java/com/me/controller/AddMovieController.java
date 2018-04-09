package com.me.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.MovieDAO;
import com.me.pojo.Movie;
import com.me.validator.MovieValidator;

@Controller
@RequestMapping(value="/addMovie.htm")
public class AddMovieController {
	
	@Autowired
	@Qualifier("movieDAO")
	MovieDAO mdao;
	
	@Autowired
	@Qualifier("movieValidator")
	MovieValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView addMoviePage() {
		
		return new ModelAndView("addMovies", "muvee", new Movie());
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView saveMovie(@ModelAttribute("muvee") Movie movie, BindingResult result) throws Exception {
		
		String modelObject=null;
		Map<String, Object> map = new HashMap<String,Object>();
		
		validator.validate(movie, result);
		
		if(result.hasErrors()) {
			return new ModelAndView("addMovies", "movie", movie);
		}
		
		Boolean saved = mdao.addMovie(movie);
		int count = 1;
        map.put("msgtyp", "add");
        
        if(saved) {
          map.put("msgfor", "success");
          map.put("rowcount", count);}
        else {
        	map.put("msgfor", "error");
        	map.put("msg", "Could not save movie");
        }
		return new ModelAndView("resultsView", "map", map);
	}
	
	
}
