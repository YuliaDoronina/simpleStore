package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Category extends BaseEntity {

    private Set<Subcategory> subcategories = new HashSet<>();

    public Category() {
    }

    public Category(Integer id, String name) {
        super(id, name);
    }

    public Category(String name) {
        super(name);
    }

    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
