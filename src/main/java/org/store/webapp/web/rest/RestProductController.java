package org.store.webapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.store.webapp.model.Product;
import org.store.webapp.service.IProductService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/rest/products")
public class RestProductController {

    @Autowired
    private IProductService service;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        return service.getAll();
    }
}
