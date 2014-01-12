/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import domain.Dvd;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author wouter
 */
public class DvdValidator implements Validator{

    @Override
    public boolean supports(Class type) {
        return Dvd.class.equals(type);
    }

    @Override
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "naam", "name.empty");
        ValidationUtils.rejectIfEmpty(e, "naam", "name.empty", null, "Naam mag niet leeg zijn.");
        ValidationUtils.rejectIfEmpty(e, "rating", "rating.empty");
        ValidationUtils.rejectIfEmpty(e, "speelduur", "speelduur.empty");
        ValidationUtils.rejectIfEmpty(e, "regisseur", "regisseur.empty");
       
        Dvd dvd = (Dvd) obj;
        if (dvd.getRating() < 0) {
            e.rejectValue("rating", "rating.laag");
        } else if (dvd.getRating() > 10) {
            e.rejectValue("rating", "rating.hoog");
        } else if (dvd.getSpeelduur() < 0) {
            e.rejectValue("speelduur", "speel.laag");
        }
    }
    
}
