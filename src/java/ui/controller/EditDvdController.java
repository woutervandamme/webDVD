/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

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
import ui.validator.DvdValidator;

/**
 *
 * @author wouter
 */
@Controller
public class EditDvdController extends ServiceController {

    DvdValidator dvdVal;

    public EditDvdController() {
        dvdVal = new DvdValidator();
    }

    @InitBinder(value = "dvd")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new DvdValidator());
    }

    @RequestMapping(value = "/editDvd", method = RequestMethod.POST)
    protected ModelAndView editDvd(@ModelAttribute(value = "dvd") @Valid Dvd dvd, BindingResult errors, ModelMap modelMap) throws Exception {
        ModelAndView mav = null;

        if (errors.hasErrors()) {
            mav = new ModelAndView("editDvd","dvd",dvd);
        } else {
            getService().updateDvd(dvd);
            List<Dvd> dvds = getService().getAlleDvds();
            mav = new ModelAndView("Dvdoverzicht", "dvds", dvds);
        }
        return mav;
    }
}