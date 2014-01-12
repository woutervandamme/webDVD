/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import db.DatabaseException;
import domain.Acteur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author wouter
 */
@Controller
public class ActeurEditFormController extends ServiceController{
    
    public ActeurEditFormController() {
    }
    
    @RequestMapping("/editFormActeur")
    protected ModelAndView getDvd(long id) throws DatabaseException{
        Acteur acteur = getService().getActeur(id);
        return new ModelAndView("editActeur","acteur",acteur);
    }
}