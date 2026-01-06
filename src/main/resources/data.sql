-- Restaurants
INSERT INTO restaurant (name, address, contact, cuisine) VALUES
('Spice Hub','MG Road','9810001111','Indian'),
('Noodle House','Park Street','9810002222','Chinese'),
('Pizza Palace','Main Square','9810003333','Italian'),
('Green Bowl','College Lane','9810004444','Healthy'),
('Grill Master','Market Road','9810005555','BBQ');

-- Customers
INSERT INTO customer (name, email, contact, address) VALUES
('Amit Kumar','amit.k@example.com','9876500011','123 MG Road'),
('Priya Singh','priya.s@example.com','9876500022','45 Park Street'),
('Rohit Verma','rohit.v@example.com','9876500033','7 Main Square'),
('Sneha Joshi','sneha.j@example.com','9876500044','12 College Lane'),
('Karan Patel','karan.p@example.com','9876500055','22 Market Road');

-- MenuItems (note restaurant ids assume insertion order 1..5)
INSERT INTO menu_item (name, description, price, available, restaurant_id) VALUES
('Butter Chicken','Creamy tomato gravy',220.0, true, 1),
('Paneer Tikka','Cottage cheese cubes',180.0, true, 1),
('Hakka Noodles','Veg noodles',150.0, true, 2),
('Chilli Paneer','Spicy paneer',170.0, true, 2),
('Margherita Pizza','Classic cheese',250.0, true, 3),
('Pepperoni Pizza','Pepperoni & cheese',320.0, true, 3),
('Quinoa Salad','Healthy grain salad',200.0, true, 4),
('Grilled Chicken Salad','Protein-rich salad',250.0, true, 4),
('BBQ Ribs','Slow-cooked ribs',450.0, true, 5),
('Grilled Veg Platter','Mixed veg grill',280.0, true, 5),
('Veg Spring Rolls','Crispy rolls',120.0, true, 2),
('Garlic Bread','Toasted garlic bread',90.0, true, 3),
('Dal Tadka','Yellow dal tempered',140.0, true, 1),
('Veg Biryani','Spiced rice with veg',160.0, true, 1),
('Chicken Biryani','Aromatic chicken biryani',260.0, true, 3);

-- Orders (basic orders referencing customer_id). OrderEntity maps to 'orders' table
INSERT INTO orders (order_date, status, total_amount, customer_id) VALUES
('2025-02-01','Delivered',440.0,1),
('2025-02-03','Placed',320.0,2),
('2025-02-04','Preparing',250.0,3),
('2025-02-05','Delivered',520.0,4),
('2025-02-06','Cancelled',0.0,5);

-- Order Items (order_id referencing orders inserted above)
INSERT INTO order_item (item_name, quantity, price, order_id) VALUES
('Butter Chicken',2,440.0,1),
('Pepperoni Pizza',1,320.0,2),
('Grilled Chicken Salad',1,250.0,3),
('BBQ Ribs',1,450.0,4),
('Garlic Bread',1,90.0,4),
('Margherita Pizza',1,250.0,5);
 