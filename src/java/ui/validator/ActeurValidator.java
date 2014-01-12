/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import domain.Acteur;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author wouter
 */
public class ActeurValidator implements Validator{

    @Override
    public boolean supports(Class type) {
        return Acteur.class.equals(type);    
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"naam","name.empty");
    }
}
