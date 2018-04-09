package com.me.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.MovieDAO;
import com.me.pojo.Movie;

@Controller
@RequestMapping(value="/searchMovie")
public class SearchMovieController {
	
	
	@Autowired
	@Qualifier("movieDAO")
	MovieDAO mdao;
	
	public void SearchMovieController() {
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String searchPage() {
		return "searchMovies";
	}
	
	@RequestMapping(value="/searchBy.htm", method=RequestMethod.GET)
	public ModelAndView searchMovie(@RequestParam("keyword")String keyword, @RequestParam("choice")String choice) throws Exception{
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		 List<Movie> movielist = mdao.searchMovie(keyword,choice);
        map.put("msgtyp", "search");

      if(movielist == null || movielist.size() == 0){
          map.put("msgfor", "error");
          map.put("msg", "No movies found");
      }
          else{
          map.put("msgfor", "success");
          map.put("msg", keyword);
          map.put("movielist", movielist);
      }
		
		return new ModelAndView("resultsView", "map", map);
	}

}
