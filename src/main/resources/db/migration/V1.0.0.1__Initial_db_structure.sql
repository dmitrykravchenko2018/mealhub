CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE SCHEMA IF NOT EXISTS mealhub;

CREATE SEQUENCE IF NOT EXISTS mealhub.user_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: user_entity; Type: TABLE; Schema: mealhub; Owner: user
--

CREATE TABLE IF NOT EXISTS mealhub.user_entity (
    id integer DEFAULT nextval('mealhub.user_entity_id_seq'::regclass) NOT NULL PRIMARY KEY,
    username character varying(20) NOT NULL,
    password character varying(100) NOT NULL,
    email character varying(50) NOT NULL
);