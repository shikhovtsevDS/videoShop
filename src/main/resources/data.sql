INSERT INTO users (last_name, first_name, middle_name, email, password) VALUES
('userLast1', 'userFirst1', 'userMiddle1', 'user@mail.ru', '$2a$10$Gh/w43nz5tIk08Mj3XIoXucAXkcxviTkTTauBDc9DazXCsYY1K4yW'), --user
('adminLast2', 'adminFirst2', 'adminMiddle2', 'admin@mail.ru', '$2a$10$Av8UQiYGiQIXZ7FtsL5H6.nVs4kUoUAbHyKDwIae5YWVjSrKLthRy'), --admin
('managlast3', 'managFirst3', 'managMiddle3', 'manager@mail.ru', '$2a$10$yNYcpx8Ucc.kjimb8j6.peYgoY0mAe/0EmG.x66RYDXAE7ncEzLGu'); --123
-- ('Last4', 'First4', 'Middle4', 'first4@mail.ru', '$2a$10$yNYcpx8Ucc.kjimb8j6.peYgoY0mAe/0EmG.x66RYDXAE7ncEzLGu'); //123

INSERT INTO products (name, description, cost, image) VALUES
('Camera TheBEST', 'Best camera', 100, 'https://app.coverr.co/s3/mp4/Steaming-Yellowstone.mp4'),
('Camera betterThenNothing', 'Removes and oh well', 20, 'https://app.coverr.co/s3/mp4/Warm-Hands.mp4'),
('Camera', 'Just camera', 34, 'https://app.coverr.co/s3/mp4/Twisting-Out.mp4'),
('Camera Professional', 'Camera for professional photographers', 34, 'https://app.coverr.co/s3/mp4/Sony-cam.mp4'),
('Camera User', 'Camera for people from people', 34, 'https://app.coverr.co/s3/mp4/Profile-pic.mp4'),
('TV Family', 'Big TV for many people', 70, 'https://app.coverr.co/s3/mp4/The-Surfers.mp4'),
('TV Everyone', 'TV for every human in the world', 10, 'https://app.coverr.co/s3/mp4/A-Director-View.mp4'),
('TV Travel Version', 'Small TV for travelers', 40, 'https://app.coverr.co/s3/mp4/Aloha-Mundo.mp4');


--Потом можно удалить
INSERT INTO orders (name, location, created_date, delivered_date, state, confirmed, user_id) VALUES
('Order 3914', 'EKB', '2019-01-01', '2019-02-05', 1, true, 100000),
('Order 393127', 'EKB', '2019-01-02', '2019-02-06', 2, true, 100000),
('Order 39235', 'EKB', '2019-01-03', '2019-02-07', 3, false, 100000),
('Order 39325', 'EKB', '2019-01-04', '2019-02-08', 4, true, 100001),
('Order 39557', 'EKB', '2019-01-05', '2019-02-09', 0, true, 100001),
('Order 39135', 'EKB', '2019-01-06', '2019-02-10', 1, true, 100001),
('Order 39536', 'EKB', '2019-01-07', '2019-02-11', 2, true, 100001);

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001),
  ('ROLE_MODER', 100002);

INSERT INTO category (name, description) VALUES
('NO', 'No category'),
('CAMERA', 'Camera equipment'),
('TV', 'Equipment for television'),
('PHOTO', 'Equipment for photograph');

INSERT INTO products_category VALUES
((SELECT id FROM products WHERE name = 'Camera TheBEST'), (SELECT id FROM category WHERE name = 'CAMERA')),
((SELECT id FROM products WHERE name = 'Camera betterThenNothing'), (SELECT id FROM category WHERE name = 'CAMERA')),
((SELECT id FROM products WHERE name = 'Camera'), (SELECT id FROM category WHERE name = 'PHOTO')),
((SELECT id FROM products WHERE name = 'Camera Professional'), (SELECT id FROM category WHERE name = 'PHOTO')),
((SELECT id FROM products WHERE name = 'Camera User'), (SELECT id FROM category WHERE name = 'PHOTO')),
((SELECT id FROM products WHERE name = 'TV Family'), (SELECT id FROM category WHERE name = 'TV')),
((SELECT id FROM products WHERE name = 'TV Everyone'), (SELECT id FROM category WHERE name = 'TV')),
((SELECT id FROM products WHERE name = 'TV Travel Version'), (SELECT id FROM category WHERE name = 'TV'));