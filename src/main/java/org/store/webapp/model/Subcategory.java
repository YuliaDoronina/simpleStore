package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Subcategory {

    private Integer idSubcategory;
    private String nameSubcategory;
    private Integer valueCategory;
    private Set<Product> productSet = new HashSet<>();

    public Subcategory() {
    }

    public Subcategory(Integer idSubcategory, String nameSubcategory, Integer valueCategory) {
        this.idSubcategory = idSubcategory;
        this.nameSubcategory = nameSubcategory;
        this.valueCategory = valueCategory;
    }

    public Subcategory(String nameSubcategory, Integer valueCategory) {
        this.nameSubcategory = nameSubcategory;
        this.valueCategory = valueCategory;
    }

    public Subcategory(Integer idSubcategory, String nameSubcategory) {
        this.idSubcategory = idSubcategory;
        this.nameSubcategory = nameSubcategory;
    }

    public Integer getIdSubcategory() {
        return idSubcategory;
    }

    public void setIdSubcategory(Integer idSubcategory) {
        this.idSubcategory = idSubcategory;
    }

    public String getNameSubcategory() {
        return nameSubcategory;
    }

    public void setNameSubcategory(String nameSubcategory) {
        this.nameSubcategory = nameSubcategory;
    }

    public Integer getValueCategory() {
        return valueCategory;
    }

    public void setValueCategory(Integer valueCategory) {
        this.valueCategory = valueCategory;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subcategory that = (Subcategory) o;

        if (idSubcategory != null ? !idSubcategory.equals(that.idSubcategory) : that.idSubcategory != null)
            return false;
        if (nameSubcategory != null ? !nameSubcategory.equals(that.nameSubcategory) : that.nameSubcategory != null)
            return false;
        return valueCategory != null ? valueCategory.equals(that.valueCategory) : that.valueCategory == null;
    }

    @Override
    public int hashCode() {
        int result = idSubcategory != null ? idSubcategory.hashCode() : 0;
        result = 31 * result + (nameSubcategory != null ? nameSubcategory.hashCode() : 0);
        result = 31 * result + (valueCategory != null ? valueCategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "idSubcategory=" + idSubcategory +
                ", nameSubcategory='" + nameSubcategory + '\'' +
                ", valueCategory=" + valueCategory +
                '}';
    }
}
