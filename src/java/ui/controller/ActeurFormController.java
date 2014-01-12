/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import db.DatabaseException;
import domain.Acteur;
import domain.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author wouter
 */
@Controller
public class ActeurFormController extends ServiceController{
    
  
    
    public ActeurFormController() {
    }
    
    @RequestMapping("/NewActeur")
    protected ModelAndView getActeur(long id) throws DatabaseException{
        Dvd d = getService().getDvd(id);
        Acteur acteur = new Acteur();
        acteur.setMovieId(d.getId());
        ModelAndView mav = new ModelAndView("addActeur");
        mav.addObject("acteurs",getService().getAlleActeurs());
        mav.addObject("acteur",acteur);
        mav.addObject("dvd",d);
        return mav;
    }
}