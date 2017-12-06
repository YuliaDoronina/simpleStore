package org.store.webapp.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.service.ICategoryService;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("categoryList", "categoryList", service.getAll());
    }
}
