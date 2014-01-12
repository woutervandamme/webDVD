/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

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
public class EditActeurController extends ServiceController {

    ActeurValidator acteurVal;

    public EditActeurController() {
        acteurVal = new ActeurValidator();
    }

    
    @InitBinder(value = "acteur")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ActeurValidator());
    }
    
    @RequestMapping(value="/editActeur",method = RequestMethod.POST)
    protected ModelAndView editActeur(@ModelAttribute(value = "acteur") @Valid Acteur a,BindingResult errors, ModelMap modelMap) throws Exception {
        ModelAndView mav = null;
        if(errors.hasErrors()){
            mav = new ModelAndView("editActeur","acteur",a);
        } else {
        Acteur acteur = getService().getActeur(a.getId());
        acteur.setNaam(a.getNaam());
        Dvd dvd = getService().getDvd(acteur.getMovieId());
        getService().updateActeur(acteur);
        List<Acteur> acteurs = getService().getActeurs(acteur.getMovieId());
        mav = new ModelAndView("acteurOverzicht");
        mav.addObject("acteurs", acteurs);
        mav.addObject("dvd", dvd);
        }
        return mav;
    }
}