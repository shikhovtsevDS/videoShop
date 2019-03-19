INSERT INTO users (last_name, first_name, middle_name, email, password)
  VALUES ('Last1', 'First1', 'Middle1', 'first1@mail.ru', '123');
INSERT INTO users (last_name, first_name, middle_name, email, password)
  VALUES ('Last2', 'First2', 'Middle2', 'first2@mail.ru', '123');
INSERT INTO users (last_name, first_name, middle_name, email, password)
  VALUES ('last3', 'First3', 'Middle3', 'first3@mail.ru', '123');
INSERT INTO users (last_name, first_name, middle_name, email, password)
  VALUES ('Last4', 'First4', 'Middle4', 'first4@mail.ru', '123');

INSERT INTO products (name, description, cost) VALUES ('Movie 1', '1', 10);
INSERT INTO products (name, description, cost) VALUES ('Movie 2', '2', 20);
INSERT INTO products (name, description, cost) VALUES ('Movie 3', '3', 30);
INSERT INTO products (name, description, cost) VALUES ('Movie 4', '4', 40);
INSERT INTO products (name, description, cost) VALUES ('Movie 5', '5', 50);
INSERT INTO products (name, description, cost) VALUES ('Movie 6', '6', 60);
INSERT INTO products (name, description, cost) VALUES ('Movie 7', '7', 70);

INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES ('EKB', '2019-01-01', '2019-02-05', 1, 100000);
INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES ('EKB', '2019-01-02', '2019-02-06', 2, 100000);
INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES ('EKB', '2019-01-03', '2019-02-07', 3, 100000);
INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES ('EKB', '2019-01-04', '2019-02-08', 4, 100001);
INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES ('EKB', '2019-01-05', '2019-02-09', 5, 100001);
INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES ('EKB', '2019-01-06', '2019-02-10', 1, 100001);
INSERT INTO orders (location, created_date, delivered_date, state, user_id) VALUES ('EKB', '2019-01-07', '2019-02-11', 2, 100001);