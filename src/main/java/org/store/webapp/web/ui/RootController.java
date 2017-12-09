package org.store.webapp.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.store.webapp.model.Producer;
import org.store.webapp.model.Product;
import org.store.webapp.model.Subcategory;
import org.store.webapp.service.ICategoryService;
import org.store.webapp.service.IProducerService;
import org.store.webapp.service.IProductService;
import org.store.webapp.service.ISubcategoryService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class RootController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISubcategoryService subcategoryService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IProducerService producerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("index", "categories", categoryService.getAll());
    }

    @RequestMapping(value = "/listSubcategory")
    public @ResponseBody
    List<Subcategory> getAllSubcategoryById(@RequestParam(value = "categoryId") Integer categoryId) {
        return subcategoryService.getAllById(categoryId);
    }

    @RequestMapping(value = "/listProductByCategory")
    public @ResponseBody
    List<Product> getAllProductById(@RequestParam(value = "id") Integer subcategoryId) {
        return productService.getAllById(subcategoryId);
    }

    @RequestMapping(value = "/listProductByProducer")
    public @ResponseBody
    List<Product> getAllProductByProducer(@RequestParam(value = "id") Integer producerId) {
        return productService.getAllByProducer(producerId);
    }

    @RequestMapping(value = "/listProducer")
    public @ResponseBody
    List<Producer> getAllBySubcategory(@RequestParam(value = "categoryId") Integer categoryId) {
        return producerService.getAllBySubcategory(categoryId);
    }


   /* @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public @ResponseBody
    List<Category> findAllCategories() {
        return categoryService.getAll();
    }*/

}
