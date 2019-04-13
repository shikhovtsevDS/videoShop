INSERT INTO users (last_name, first_name, middle_name, email, password) VALUES
('userLast1', 'userFirst1', 'userMiddle1', 'user@mail.ru', '$2a$10$Gh/w43nz5tIk08Mj3XIoXucAXkcxviTkTTauBDc9DazXCsYY1K4yW'), --user
('adminLast2', 'adminFirst2', 'adminMiddle2', 'admin@mail.ru', '$2a$10$Av8UQiYGiQIXZ7FtsL5H6.nVs4kUoUAbHyKDwIae5YWVjSrKLthRy'), --admin
('managlast3', 'managFirst3', 'managMiddle3', 'manager@mail.ru', '$2a$10$yNYcpx8Ucc.kjimb8j6.peYgoY0mAe/0EmG.x66RYDXAE7ncEzLGu'); --123
-- ('Last4', 'First4', 'Middle4', 'first4@mail.ru', '$2a$10$yNYcpx8Ucc.kjimb8j6.peYgoY0mAe/0EmG.x66RYDXAE7ncEzLGu'); //123

INSERT INTO products (name, description, cost) VALUES
('Camera TheBEST', 'Best camera', 100),
('Camera betterThenNothing', 'Removes and oh well', 20),
('Camera', 'Just camera', 34),
('Camera Professional', 'Camera for professional photographers', 34),
('Camera User', 'Camera for people from people', 34),
('TV Family', 'Big TV for many people', 70),
('TV Everyone', 'TV for every human in the world', 10),
('TV Travel Version', 'Small TV for travelers', 40);


--Потом можно удалить
INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES
('EKB', '2019-01-01', '2019-02-05', 1, 100000),
('EKB', '2019-01-02', '2019-02-06', 2, 100000),
('EKB', '2019-01-03', '2019-02-07', 3, 100000),
('EKB', '2019-01-04', '2019-02-08', 4, 100001),
('EKB', '2019-01-05', '2019-02-09', 5, 100001),
('EKB', '2019-01-06', '2019-02-10', 1, 100001),
('EKB', '2019-01-07', '2019-02-11', 2, 100001);

INSERT INTO user_roles (role, user_id) VALUES
  ('USER', 100000),
  ('ADMIN', 100001),
  ('USER', 100001);

INSERT INTO category (name, description) VALUES
('NO', 'No category'),
('CAMERA', 'Camera equipment'),
('TV', 'Equipment for television'),
('PHOTO', 'Equipment for photograph');


INSERT INTO products_category VALUES
((SELECT id FROM products WHERE name = 'Camera TheBEST'), (SELECT id FROM products WHERE name = 'CAMERA')),
((SELECT id FROM products WHERE name = 'Camera betterThenNothing'), (SELECT id FROM products WHERE name = 'CAMERA')),
((SELECT id FROM products WHERE name = 'Camera'), (SELECT id FROM products WHERE name = 'PHOTO')),
((SELECT id FROM products WHERE name = 'Camera Professional'), (SELECT id FROM products WHERE name = 'PHOTO')),
((SELECT id FROM products WHERE name = 'Camera User'), (SELECT id FROM products WHERE name = 'PHOTO')),
((SELECT id FROM products WHERE name = 'TV Family'), (SELECT id FROM products WHERE name = 'TV')),
((SELECT id FROM products WHERE name = 'TV Everyone'), (SELECT id FROM products WHERE name = 'TV')),
((SELECT id FROM products WHERE name = 'TV Travel Version'), (SELECT id FROM products WHERE name = 'TV'));