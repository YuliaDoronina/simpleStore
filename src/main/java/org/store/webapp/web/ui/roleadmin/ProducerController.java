package org.store.webapp.web.ui.roleadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.model.Producer;
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("admin/editProducer", "producer", new Producer());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Producer producer) {
        service.save(producer);
        return "redirect:/admin/producers";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        service.delete(id);
        return "redirect:/admin/producers";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam(value = "id") Integer id) {
        return new ModelAndView("admin/editProducer", "producer", service.getById(id));
    }
}
