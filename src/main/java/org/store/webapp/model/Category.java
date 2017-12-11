package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private Integer idCategory;
    private String typeCategory;
    private Set<Subcategory> infoSet = new HashSet<>();

    public Category() {
    }

    public Category(Integer idCategory, String typeCategory) {
        this.idCategory = idCategory;
        this.typeCategory = typeCategory;
    }

    public Category(String typeCategory) {
        this.typeCategory = typeCategory;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }

    public Set<Subcategory> getInfoSet() {
        return infoSet;
    }

    public void setInfoSet(Set<Subcategory> infoSet) {
        this.infoSet = infoSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (idCategory != null ? !idCategory.equals(category.idCategory) : category.idCategory != null) return false;
        return typeCategory != null ? typeCategory.equals(category.typeCategory) : category.typeCategory == null;
    }

    @Override
    public int hashCode() {
        int result = idCategory != null ? idCategory.hashCode() : 0;
        result = 31 * result + (typeCategory != null ? typeCategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", typeCategory='" + typeCategory + '\'' +
                '}';
    }
}
