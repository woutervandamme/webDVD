/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import domain.Acteur;
import domain.Dvd;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author wouter
 */
@Controller
public class ActeurOverzichtController extends ServiceController{
    
    
    public ActeurOverzichtController() {
    }
    
    @RequestMapping("/acteurOverzicht")
    protected ModelAndView getActeurs(long id) throws Exception {
        List<Acteur>acteurs = getService().getActeurs(id);
        Dvd d = getService().getDvd(id);
        ModelAndView mav = new ModelAndView("acteurOverzicht");
        mav.addObject("acteurs",acteurs);
        mav.addObject("dvd",d);
        return mav;
    }
}