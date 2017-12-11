package org.store.webapp.web.ui.roleadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.model.Product;
import org.store.webapp.service.IProductService;

@Controller
@RequestMapping(value = "/admin/products")
@Secured("ROLE_ADMIN")
public class ProductController {

    @Autowired
    private IProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("admin/productList", "productList", service.getAll());
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("admin/editProduct", "product", new Product());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Product product) {
        service.save(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        service.delete(id);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam(value = "id") Integer id) {
        return new ModelAndView("admin/editProduct", "product", service.getById(id));
    }
}
