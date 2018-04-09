/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.validator;

import com.me.pojo.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Tushar
 */
public class MovieValidator implements Validator{

    @Override
    public boolean supports(Class type) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return type.equals(Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "emty-title", "Title cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "emty-actor", "Actor cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "emty-actress", "Actress cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "emty-genre", "Genre cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "emty-year", "Year cannot be empty");
    }
    
}
