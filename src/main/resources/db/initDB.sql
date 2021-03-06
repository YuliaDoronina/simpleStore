/*USE storeDB;*/

DROP TABLE IF EXISTS summary;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS producer;
DROP TABLE IF EXISTS subcategory;
DROP TABLE IF EXISTS category;

CREATE TABLE category (
  id_category   INTEGER PRIMARY KEY AUTO_INCREMENT,
  type_category VARCHAR(100) NOT NULL
);

CREATE TABLE subcategory (
  id_subcategory   INTEGER PRIMARY KEY AUTO_INCREMENT,
  name_subcategory VARCHAR(100) NOT NULL,
  id_category      INTEGER      NOT NULL,
  FOREIGN KEY (id_category) REFERENCES category (id_category)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE product (
  id_product          INTEGER PRIMARY KEY AUTO_INCREMENT,
  name_product        VARCHAR(100) NOT NULL,
  price_product       VARCHAR(100) NOT NULL,
  description_product VARCHAR(200) NOT NULL,
  flag_product        BIT          NOT NULL,
  id_subcategory      INTEGER      NOT NULL,
  FOREIGN KEY (id_subcategory) REFERENCES subcategory (id_subcategory)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE producer (
  id_producer   INTEGER PRIMARY KEY AUTO_INCREMENT,
  name_producer VARCHAR(100) NOT NULL
);

CREATE TABLE summary (
  id_product  INTEGER NOT NULL,
  id_producer INTEGER NOT NULL,
  PRIMARY KEY (id_product, id_producer),
  FOREIGN KEY (id_product) REFERENCES product (id_product)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (id_producer) REFERENCES producer (id_producer)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

SELECT
  producer.id_producer,
  producer.name_producer
FROM producer
  INNER JOIN summary ON producer.id_producer = summary.id_producer
  JOIN product ON summary.id_product = product.id_product
  JOIN subcategory ON product.id_subcategory = subcategory.id_subcategory
  JOIN category ON subcategory.id_category = category.id_category
WHERE category.id_category = 4
GROUP BY producer.id_producer;

SELECT
  product.id_product,
  product.name_product,
  product.price_product,
  product.description_product,
  product.flag_product,
  producer.name_producer
FROM product
  INNER JOIN summary ON product.id_product = summary.id_product
  JOIN producer ON summary.id_producer = producer.id_producer
  INNER JOIN subcategory ON product.id_subcategory = subcategory.id_subcategory
  JOIN category ON subcategory.id_category = category.id_category
WHERE producer.id_producer = 5 AND category.id_category = 4;