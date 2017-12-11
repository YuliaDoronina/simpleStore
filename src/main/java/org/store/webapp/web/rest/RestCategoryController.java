package org.store.webapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.store.webapp.model.Category;
import org.store.webapp.service.ICategoryService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/rest/categories")
public class RestCategoryController {

    @Autowired
    private ICategoryService service;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Category> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public Category getById(@PathVariable(value = "id") Integer id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Category create(@Valid @RequestBody Category category) {
        return service.save(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable Integer id, @RequestBody Category category) {
        category.setIdCategory(id);
        service.save(category);
    }
}
