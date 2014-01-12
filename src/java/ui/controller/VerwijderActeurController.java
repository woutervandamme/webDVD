/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import domain.Acteur;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author wouter
 */
@Controller
public class VerwijderActeurController extends ServiceController {
    
  
    
    public VerwijderActeurController() {
    }
    
    @RequestMapping("/RemoveActeur")
     protected ModelAndView verwijderActeur(long id) throws Exception {   
        Acteur acteur = getService().getActeur(id);
        long movieId = acteur.getMovieId();
        getService().removeActeurFromDvd(acteur);
        List<Acteur>acteurs = getService().getActeurs(movieId);
        ModelAndView mav = new ModelAndView("acteurOverzicht");
        mav.addObject("acteurs",acteurs);
        mav.addObject("dvd",getService().getDvd(movieId));
        return mav;
    }
}