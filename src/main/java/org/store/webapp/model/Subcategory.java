package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Subcategory extends BaseEntity {

    private Integer idCategory;
    private Category category;
    private Set<Product> products = new HashSet<>();

    public Subcategory() {
    }

    public Subcategory(Integer id, String name) {
        super(id, name);
    }

    public Subcategory(Integer id, String name, Integer idCategory) {
        super(id, name);
        this.idCategory = idCategory;
    }

    public Subcategory(String name, Integer idCategory) {
        super(name);
        this.idCategory = idCategory;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Subcategory that = (Subcategory) o;

        return idCategory != null ? idCategory.equals(that.idCategory) : that.idCategory == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (idCategory != null ? idCategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                super.toString() +
                "idCategory=" + idCategory +
                '}';
    }

}
