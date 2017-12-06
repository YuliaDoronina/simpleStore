package org.store.webapp.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.service.IProducerService;

@Controller
@RequestMapping(value = "/producers")
public class ProducerController {

    @Autowired
    private IProducerService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("producerList", "producerList", service.getAll());
    }
}
