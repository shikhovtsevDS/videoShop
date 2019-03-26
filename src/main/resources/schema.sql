DROP TABLE IF EXISTS orders_products;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  first_name       VARCHAR                 NOT NULL,
  last_name        VARCHAR                 NOT NULL,
  middle_name      VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE orders
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    created_date   TIMESTAMP DEFAULT now() NOT NULL,
    delivered_date TIMESTAMP DEFAULT now() NOT NULL,
    location       VARCHAR NOT NULL,
    state          INTEGER,
    user_id        INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE products
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR   NOT NULL,
  cost        INTEGER   NOT NULL,
  description VARCHAR   NOT NULL
);

CREATE TABLE orders_products
(
  order_id      INTEGER NOT NULL,
  product_id    INTEGER NOT NULL,
  CONSTRAINT order_products_idx UNIQUE (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES orders (id),
  FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE category
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR   NOT NULL
);