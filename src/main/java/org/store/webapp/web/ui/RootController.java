package org.store.webapp.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.model.Subcategory;
import org.store.webapp.service.ICategoryService;
import org.store.webapp.service.ISubcategoryService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class RootController {

   /* @GetMapping
    public String root() {
        return "index";
    }*/

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISubcategoryService subcategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("index", "categories", categoryService.getAll());
    }

    @RequestMapping(value = "/listSubcategory")
    public @ResponseBody
    List<Subcategory> getAllById(@RequestParam(value = "categoryId") Integer categoryId) {
        return subcategoryService.getAllById(categoryId);
    }

   /* @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public @ResponseBody
    List<Category> findAllCategories() {
        return categoryService.getAll();
    }*/

}
