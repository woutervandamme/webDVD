/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import db.DatabaseException;
import domain.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author wouter
 */
@Controller
public class DvdEditFormController extends ServiceController{
    
   
    
    public DvdEditFormController() {
    }
    
    @RequestMapping("/editFormDvd")
    protected ModelAndView getDvd(long id) throws DatabaseException{
        Dvd d = getService().getDvd(id);
        return new ModelAndView("editDvd","dvd",d);
    }
}