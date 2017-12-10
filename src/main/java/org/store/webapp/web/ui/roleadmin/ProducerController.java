package org.store.webapp.web.ui.roleadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.service.IProducerService;

@Controller
@RequestMapping(value = "/admin/producers")
@Secured("ROLE_ADMIN")
public class ProducerController {

    @Autowired
    private IProducerService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("admin/producerList", "producerList", service.getAll());
    }
}
