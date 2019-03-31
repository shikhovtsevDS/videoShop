INSERT INTO users (last_name, first_name, middle_name, email, password) VALUES
('userLast1', 'userFirst1', 'userMiddle1', 'user@mail.ru', '$2a$10$Gh/w43nz5tIk08Mj3XIoXucAXkcxviTkTTauBDc9DazXCsYY1K4yW'), --user
('adminLast2', 'adminFirst2', 'adminMiddle2', 'admin@mail.ru', '$2a$10$Av8UQiYGiQIXZ7FtsL5H6.nVs4kUoUAbHyKDwIae5YWVjSrKLthRy'), --admin
('managlast3', 'managFirst3', 'managMiddle3', 'manager@mail.ru', '$2a$10$yNYcpx8Ucc.kjimb8j6.peYgoY0mAe/0EmG.x66RYDXAE7ncEzLGu'); --123
-- ('Last4', 'First4', 'Middle4', 'first4@mail.ru', '$2a$10$yNYcpx8Ucc.kjimb8j6.peYgoY0mAe/0EmG.x66RYDXAE7ncEzLGu'); //123

INSERT INTO products (name, description, cost) VALUES
('Movie 1', '1', 10),
('Movie 2', '2', 20),
('Movie 3', '3', 30),
('Movie 4', '4', 40),
('Movie 5', '5', 50),
('Movie 6', '6', 60),
('Movie 7', '7', 70);

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

INSERT INTO category (name) VALUES
('CAMERA'),
('TV'),
('MOVIE'),
('PHOTO');