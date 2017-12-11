package org.store.webapp.web.ui.roleadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.model.Category;
import org.store.webapp.service.ICategoryService;

@Controller
@RequestMapping(value = "/admin/categories")
@Secured("ROLE_ADMIN")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("admin/categoryList", "categoryList", service.getAll());
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("admin/editCategory", "category", new Category());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Category category) {
        service.save(category);
        return "redirect:/admin/categories";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        service.delete(id);
        return "redirect:/admin/categories";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam(value = "id") Integer id){
        return new ModelAndView("admin/editCategory", "category", service.getById(id));
    }
}
