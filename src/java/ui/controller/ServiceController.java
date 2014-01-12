/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import domain.DvdFacade;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author wouter
 */
public abstract class ServiceController {
    
   
    private DvdFacade service;

    public DvdFacade getService() {
        return service;
    }

    @Autowired
    public void setService(DvdFacade service) {
        this.service = service;
    }
}
