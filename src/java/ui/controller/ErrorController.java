/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wouter
 */
public class ErrorController extends ServiceController{
    
     @RequestMapping("/Exception")
     protected ModelAndView toonError() throws Exception {
        ModelAndView mav = new ModelAndView("exception");
        return mav;
    }
     
}
