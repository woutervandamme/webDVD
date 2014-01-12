/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import domain.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author wouter
 */
@Controller
public class DvdFormController extends ServiceController {
    
   
    
    public DvdFormController() {
    }
    
    @RequestMapping("/NewDvd")
    protected ModelAndView getDvd(){
        return new ModelAndView("addDvd","dvd",new Dvd());
    }
}