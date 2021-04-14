
CREATE TABLE pruebazass.clients (
    id integer NOT NULL,
    shared_key character varying(100),
    businessid character varying(100),
    phone character varying(500),
    email character varying(500),
    start_date timestamp without time zone,
    end_date timestamp without time zone,
    data_added timestamp without time zone,	PRIMARY KEY (id)
);