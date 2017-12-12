/*VALUES FOR TEST:*/

INSERT INTO category (type_category) VALUES ('testCategory1'), ('testCategory2');

INSERT INTO subcategory (name_subcategory, id_category) VALUES ('testSubcategory1', 1), ('testSubcategory2', 2);

INSERT INTO product (name_product, price_product, description_product, flag_product, id_subcategory)
VALUES ('testProduct1', '111', 'testProduct1', TRUE, 1), ('testProduct2', '222', 'testProduct2', FALSE, 2);

INSERT INTO producer (name_producer) VALUES ('testProducer1'), ('testProducer2');

INSERT INTO summary VALUES (2, 1), (1, 2);