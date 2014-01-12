/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import domain.Dvd;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ui.validator.DvdValidator;

/**
 *
 * @author wouter
 */
@Controller
public class AddDvdController extends ServiceController {

    DvdValidator dvdVal;

    public AddDvdController() {
        dvdVal = new DvdValidator();
    }

    @InitBinder(value = "dvd")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new DvdValidator());
    }

    @RequestMapping(value = "/AddDvd", method = RequestMethod.POST)
    protected ModelAndView addDvd(@ModelAttribute(value = "dvd") Dvd dvd, BindingResult errors, ModelMap modelMap) throws Exception {

        ModelAndView mav;
        if (errors.hasErrors()) {
            mav = new ModelAndView("addDvd");
        } else {
            mav = new ModelAndView("Dvdoverzicht");
            getService().addDvd(dvd);
            List<Dvd> dvds = getService().getAlleDvds();
            mav.addObject("dvds", dvds);
        }
        return mav;
    }
}