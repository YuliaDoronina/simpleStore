package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Product extends BaseEntity {

    private String price;
    private String description;
    private Boolean flag;
    private Subcategory subcategory;
    private Set<Producer> producers = new HashSet<>();

    public Product() {
    }

    public Product(Integer id, String name, String price, String description, Boolean flag) {
        super(id, name);
        this.price = price;
        this.description = description;
        this.flag = flag;
    }

    public Product(String name, String price, String description, Boolean flag) {
        super(name);
        this.price = price;
        this.description = description;
        this.flag = flag;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Set<Producer> getProducers() {
        return producers;
    }

    public void setProducers(Set<Producer> producers) {
        this.producers = producers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return flag != null ? flag.equals(product.flag) : product.flag == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                super.toString() +
                "price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", flag=" + flag +
                '}';
    }
}
