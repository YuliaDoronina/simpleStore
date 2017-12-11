package org.store.webapp.repository;

import org.springframework.stereotype.Component;
import org.store.webapp.model.Product;

@Component
public class DataClass {

    final static Product PRODUCT1 = new Product(1, "tablet1", "14534", "description tablet1", true, 1);
    final static Product PRODUCT2 = new Product(2, "tablet2", "134", "description tablet2", false, 1);
    final static Product PRODUCT3 = new Product(3, "Monitors1", "134", "description Monitors1", true, 1);

}
