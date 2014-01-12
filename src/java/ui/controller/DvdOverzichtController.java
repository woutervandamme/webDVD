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
public class DvdOverzichtController extends ServiceController{

    public DvdOverzichtController() {
    }
    
    @RequestMapping("/Dvdoverzicht")
    protected ModelAndView getDvds() throws Exception {
        List<Dvd>dvds = getService().getAlleDvds();
        ModelAndView mav = new ModelAndView("Dvdoverzicht");
        mav.addObject("dvds",dvds);
        return mav;
    }
}