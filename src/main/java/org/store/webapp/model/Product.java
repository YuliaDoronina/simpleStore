package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Product {

    private Integer idProduct;
    private String nameProduct;
    private String priceProduct;
    private String descriptionProduct;
    private Boolean flagProduct;
    private Integer valueSubcategory;
    private Set<Producer> producerSet = new HashSet<>();

    public Product() {
    }

    public Product(Integer idProduct, String nameProduct, String priceProduct, String descriptionProduct, Boolean flagProduct, Integer valueSubcategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.flagProduct = flagProduct;
        this.valueSubcategory = valueSubcategory;
    }

    public Product(String nameProduct, String priceProduct, String descriptionProduct, Boolean flagProduct, Integer valueSubcategory) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.flagProduct = flagProduct;
        this.valueSubcategory = valueSubcategory;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Boolean getFlagProduct() {
        return flagProduct;
    }

    public void setFlagProduct(Boolean flagProduct) {
        this.flagProduct = flagProduct;
    }

    public Integer getValueSubcategory() {
        return valueSubcategory;
    }

    public void setValueSubcategory(Integer valueSubcategory) {
        this.valueSubcategory = valueSubcategory;
    }

    public Set<Producer> getProducerSet() {
        return producerSet;
    }

    public void setProducerSet(Set<Producer> producerSet) {
        this.producerSet = producerSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (idProduct != null ? !idProduct.equals(product.idProduct) : product.idProduct != null) return false;
        if (nameProduct != null ? !nameProduct.equals(product.nameProduct) : product.nameProduct != null) return false;
        if (priceProduct != null ? !priceProduct.equals(product.priceProduct) : product.priceProduct != null)
            return false;
        if (descriptionProduct != null ? !descriptionProduct.equals(product.descriptionProduct) : product.descriptionProduct != null)
            return false;
        if (flagProduct != null ? !flagProduct.equals(product.flagProduct) : product.flagProduct != null) return false;
        return valueSubcategory != null ? valueSubcategory.equals(product.valueSubcategory) : product.valueSubcategory == null;
    }

    @Override
    public int hashCode() {
        int result = idProduct != null ? idProduct.hashCode() : 0;
        result = 31 * result + (nameProduct != null ? nameProduct.hashCode() : 0);
        result = 31 * result + (priceProduct != null ? priceProduct.hashCode() : 0);
        result = 31 * result + (descriptionProduct != null ? descriptionProduct.hashCode() : 0);
        result = 31 * result + (flagProduct != null ? flagProduct.hashCode() : 0);
        result = 31 * result + (valueSubcategory != null ? valueSubcategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct='" + priceProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", flagProduct=" + flagProduct +
                ", valueSubcategory=" + valueSubcategory +
                '}';
    }

}
