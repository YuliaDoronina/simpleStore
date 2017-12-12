package org.store.webapp;

import org.springframework.stereotype.Component;
import org.store.webapp.model.Category;
import org.store.webapp.model.Producer;
import org.store.webapp.model.Product;
import org.store.webapp.model.Subcategory;

@Component
public class DataClass {

    /*For category:*/
    public final static Category CATEGORY1 = new Category(1, "testCategory1");
    public final static Category CATEGORY2 = new Category(2, "testCategory2");
    public final static Category CATEGORY3 = new Category(3, "/");

    /*For producer:*/
    public final static Producer PRODUCER1 = new Producer(1, "testProducer1");
    public final static Producer PRODUCER2 = new Producer(2, "testProducer2");
    public final static Producer PRODUCER3 = new Producer(3, "/");

    /*For product:*/
    public final static Product PRODUCT1 = new Product(1, "testProduct1", "111", "testProduct1", true);
    public final static Product PRODUCT2 = new Product(2, "testProduct2", "222", "testProduct2", false);
    public final static Product PRODUCT3 = new Product(0, "/", "/", "/", false, 1);

    /*For subcategory:*/
    public final static Subcategory SUBCATEGORY1 = new Subcategory(1, "testSubcategory1");
    public final static Subcategory SUBCATEGORY2 = new Subcategory(2, "testSubcategory2");
    public final static Subcategory SUBCATEGORY3 = new Subcategory(0, "/", 1);
}
