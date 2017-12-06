package org.store.webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Producer extends BaseEntity {

    private Set<Product> products = new HashSet<>();

    public Producer() {
    }

    public Producer(Integer id, String name) {
        super(id, name);
    }

    public Producer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Producer{" +
                super.toString() +
                "products=" + products +
                '}';
    }
}
