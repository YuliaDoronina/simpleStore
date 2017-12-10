package org.store.webapp.web.ui.roleadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
}
