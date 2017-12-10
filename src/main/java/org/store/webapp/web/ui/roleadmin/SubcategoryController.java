package org.store.webapp.web.ui.roleadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.service.ISubcategoryService;

@Controller
@RequestMapping(value = "/admin/subcategories")
@Secured("ROLE_ADMIN")
public class SubcategoryController {

    @Autowired
    private ISubcategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("admin/subcategoryList", "subcategoryList", service.getAll());
    }
}
