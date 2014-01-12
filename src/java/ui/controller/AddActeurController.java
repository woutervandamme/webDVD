/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import db.DatabaseException;
import domain.Acteur;
import domain.Dvd;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ui.validator.ActeurValidator;

/**
 *
 * @author wouter
 */
@Controller
public class AddActeurController extends ServiceController {

    ActeurValidator acteurVal;

    public AddActeurController() {
        acteurVal = new ActeurValidator();
    }

    @InitBinder(value = "Acteur")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ActeurValidator());
    }

    @RequestMapping(value="/AddActeur",method = RequestMethod.POST)
    public ModelAndView addActeur(@ModelAttribute(value = "acteur") @Valid Acteur acteur,BindingResult errors, ModelMap modelMap) throws DatabaseException{
        ModelAndView mav ;
        
        if(errors.hasErrors()){
            Dvd d = getService().getDvd(acteur.getMovieId());
            mav = new ModelAndView("addActeur");
            mav.addObject("acteurs",getService().getAlleActeurs());
            mav.addObject("acteur",acteur);
            mav.addObject("dvd",d);
        } else {
            getService().addActeurToDvd(acteur);
            List<Acteur> acteurs = getService().getActeurs(acteur.getMovieId());
            mav = new ModelAndView("acteurOverzicht");
            mav.addObject("acteurs", acteurs);
            mav.addObject("dvd", getService().getDvd(acteur.getMovieId()));
        }
        return mav;
    }
}