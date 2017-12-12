package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Producer {

    private Integer idProducer;
    private String nameProducer;
    private Set<Product> productSet = new HashSet<>();

    public Producer() {
    }

    public Producer(Integer idProducer, String nameProducer) {
        this.idProducer = idProducer;
        this.nameProducer = nameProducer;
    }

    public Producer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    public Integer getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(Integer idProducer) {
        this.idProducer = idProducer;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
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

        Producer producer = (Producer) o;

        if (idProducer != null ? !idProducer.equals(producer.idProducer) : producer.idProducer != null) return false;
        return nameProducer != null ? nameProducer.equals(producer.nameProducer) : producer.nameProducer == null;
    }

    @Override
    public int hashCode() {
        int result = idProducer != null ? idProducer.hashCode() : 0;
        result = 31 * result + (nameProducer != null ? nameProducer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "idProducer=" + idProducer +
                ", nameProducer='" + nameProducer + '\'' +
                '}';
    }
}
