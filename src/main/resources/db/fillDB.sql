INSERT INTO category (type_category) VALUES ('Laptops and computers'), ('Tv and electronics'), ('Large home appliances'), ('Small household appliances');

INSERT INTO subcategory (name_subcategory, id_category) VALUES ('Laptops', 1), ('Tablets', 1), ('Monitors', 1), ('Video card', 1), ('HDD', 1), ('Motherboard', 1),
  ('Printers', 1), ('Tv', 2), ('Telephone', 2), ('Cameras', 2), ('Home theaters', 2), ('Accessories', 2),
  ('Refrigerators', 3), ('Washing machines', 3), ('Plate cook', 3), ('Dishwashers', 3), ('Blenders', 4),
  ('Electric kettle', 4), ('Coffee maker', 4), ('Mixer', 4), ('Smoothing-iron', 4);

INSERT INTO product (name_product, price_product, description_product, flag_product, id_subcategory)
VALUES ('tv1', '123', 'description tv1', TRUE, 1), ('tv2', '243', 'description tv2', TRUE, 1),
  ('tv3', '10', 'description tv3', FALSE, 1), ('tv4', '1670', 'description tv4', TRUE, 1),
  ('tv5', '1', 'description tv5', FALSE, 1), ('tablet1', '14534', 'description tablet1', TRUE, 2),
  ('tablet2', '134', 'description tablet2', TRUE, 2), ('Monitors1', '134', 'description Monitors1', TRUE, 3),
  ('Monitors2', '134', 'description Monitors2', TRUE, 3), ('Video card1', '1334', 'description Video card1', FALSE, 4),
  ('Video card2', '1334', 'description Video card2', FALSE, 4), ('HDD1', '1334', 'description HDD1', TRUE, 5),
  ('HDD2', '1334', 'description HDD2', FALSE, 5), ('Motherboard1', '14', 'description Motherboard1', TRUE, 6),
  ('Motherboard2', '145645', 'description Motherboard2', FALSE, 6),
  ('Printer1', '888', 'description Printer1', TRUE, 7), ('Printer2', '145645', 'description Printer2', TRUE, 7),
  ('Tv 1', '48', 'description Tv1', TRUE, 8), ('Tv2', '156', 'description Tv2', TRUE, 8),
  ('Telephone1', '87', 'description Telephone1', FALSE, 9), ('Telephone2', '34', 'description Telephone2', TRUE, 9),
  ('Cameras1', '35.34', 'description Cameras1', FALSE, 10), ('Cameras2', '3453', 'description Cameras2', FALSE, 10),
  ('Home theaters1', '3533.34', 'description Home theaters1', TRUE, 11),
  ('Home theaters2', '3453', 'description Home theaters2', FALSE, 11),
  ('Accessories1', '6586', 'description Accessories1', TRUE, 12),
  ('Accessories2', '44', 'description Accessories2', TRUE, 12),
  ('Refrigerators1', '567.9', 'description Refrigerators1', TRUE, 13),
  ('Refrigerators2', '567.91', 'description Refrigerators2', TRUE, 13),
  ('Washing machines1', '6586', 'description Washing machines1', TRUE, 14),
  ('Washing machines2', '44', 'description Washing machines2', TRUE, 14),
  ('Plate cook1', '6586', 'description Plate cook1', FALSE, 15),
  ('Plate cook2', '44', 'description Plate cook2', TRUE, 15),
  ('Dishwashers1', '35', 'description Dishwashers1', TRUE, 16),
  ('Dishwashers2', '44', 'description Dishwashers2', TRUE, 16),
  ('Blenders1', '126', 'description Blenders1', TRUE, 17), ('Blenders2', '637', 'description Blenders2', FALSE, 17),
  ('Electric kettle1', '166', 'description Electric kettle1', TRUE, 18),
  ('Electric kettle2', '444', 'description Electric kettle2', TRUE, 18),
  ('Coffee maker1', '567', 'description Coffee maker1', FALSE, 19),
  ('Coffee maker2', '454', 'description Coffee maker2', TRUE, 19),
  ('Mixer1', '64.6', 'description Mixer 1', TRUE, 20), ('Mixer2', '74.4', 'description Mixer 2', TRUE, 20),
  ('Accessories1', '6586', 'description Accessories1', TRUE, 21),
  ('Accessories2', '44', 'description Accessories2', TRUE, 21);

INSERT INTO producer (name_producer) VALUES ('producer 1'), ('producer 2'), ('producer 3'), ('producer 4'), ('producer 5');

INSERT INTO summary VALUES (1, 4), (4, 4), (5, 5), (12, 5), (10, 1), (43, 1), (44, 5), (45, 1), (19, 1);

