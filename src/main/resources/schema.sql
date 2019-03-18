CREATE TABLE public.orders
(
    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    created_date timestamp without time zone NOT NULL,
    delivered_date timestamp without time zone NOT NULL,
    location character varying(255) COLLATE pg_catalog."default" NOT NULL,
    state integer,
    user_id integer NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE public.products
(
    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cost double precision,
    description character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    middle_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
);