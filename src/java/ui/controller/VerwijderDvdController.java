/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

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
public class VerwijderDvdController extends ServiceController{
    
   
    
    public VerwijderDvdController() {
    }
    
    @RequestMapping("/RemoveDvd")
     protected ModelAndView verwijderDvd(long id) throws Exception {     
        Dvd d = getService().getDvd(id);
        getService().removeDvd(d);
        List<Dvd>dvds = getService().getAlleDvds();
        return new ModelAndView("Dvdoverzicht","dvds",dvds);
    }
}