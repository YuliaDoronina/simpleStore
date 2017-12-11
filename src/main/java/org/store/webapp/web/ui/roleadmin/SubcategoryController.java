package org.store.webapp.web.ui.roleadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.model.Subcategory;
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("admin/editSubcategory", "subcategory", new Subcategory());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Subcategory subcategory) {
        service.save(subcategory);
        return "redirect:/admin/subcategories";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        service.delete(id);
        return "redirect:/admin/subcategories";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam(value = "id") Integer id) {
        return new ModelAndView("admin/editSubcategory", "subcategory", service.getById(id));
    }
}
