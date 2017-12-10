--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2017-12-10 23:06:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 188 (class 1259 OID 17193)
-- Name: Cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Cities" (
    id integer NOT NULL,
    name character varying NOT NULL,
    code integer NOT NULL,
    country_id integer
);


ALTER TABLE "Cities" OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 17191)
-- Name: Cities_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Cities_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Cities_id_seq" OWNER TO postgres;

--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 187
-- Name: Cities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Cities_id_seq" OWNED BY "Cities".id;


--
-- TOC entry 186 (class 1259 OID 17182)
-- Name: Countries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Countries" (
    id integer NOT NULL,
    name character varying NOT NULL,
    code integer NOT NULL
);


ALTER TABLE "Countries" OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 17180)
-- Name: Countries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Countries_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Countries_id_seq" OWNER TO postgres;

--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 185
-- Name: Countries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Countries_id_seq" OWNED BY "Countries".id;


--
-- TOC entry 192 (class 1259 OID 17241)
-- Name: Products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Products" (
    id integer NOT NULL,
    name character varying NOT NULL,
    unit_price integer NOT NULL,
    detail character varying(150)
);


ALTER TABLE "Products" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 17270)
-- Name: Products_In_Stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Products_In_Stock" (
    stock_id integer,
    serial integer NOT NULL
)
INHERITS ("Products");


ALTER TABLE "Products_In_Stock" OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 17268)
-- Name: Products_In_Stock_serial_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Products_In_Stock_serial_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Products_In_Stock_serial_seq" OWNER TO postgres;

--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 195
-- Name: Products_In_Stock_serial_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Products_In_Stock_serial_seq" OWNED BY "Products_In_Stock".serial;


--
-- TOC entry 191 (class 1259 OID 17239)
-- Name: Products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Products_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Products_id_seq" OWNER TO postgres;

--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 191
-- Name: Products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Products_id_seq" OWNED BY "Products".id;


--
-- TOC entry 190 (class 1259 OID 17209)
-- Name: Roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Roles" (
    id integer NOT NULL,
    role_name character varying NOT NULL
);


ALTER TABLE "Roles" OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 17207)
-- Name: Roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Roles_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Roles_id_seq" OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 189
-- Name: Roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Roles_id_seq" OWNED BY "Roles".id;


--
-- TOC entry 194 (class 1259 OID 17252)
-- Name: Stocks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Stocks" (
    id integer NOT NULL,
    name character varying,
    product_id integer NOT NULL,
    quantity integer DEFAULT 0,
    unit_price integer NOT NULL
);


ALTER TABLE "Stocks" OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 17250)
-- Name: Stocks_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Stocks_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Stocks_id_seq" OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 193
-- Name: Stocks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Stocks_id_seq" OWNED BY "Stocks".id;


--
-- TOC entry 198 (class 1259 OID 17293)
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Users" (
    id integer NOT NULL,
    first_name character varying,
    last_name character varying,
    user_name character varying,
    password character varying,
    address character varying(100),
    phone_number character varying(12),
    role_id integer NOT NULL,
    city_id integer NOT NULL,
    birthday date
);


ALTER TABLE "Users" OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 17291)
-- Name: Users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Users_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Users_id_seq" OWNER TO postgres;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 197
-- Name: Users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Users_id_seq" OWNED BY "Users".id;


--
-- TOC entry 2045 (class 2604 OID 17196)
-- Name: Cities id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Cities" ALTER COLUMN id SET DEFAULT nextval('"Cities_id_seq"'::regclass);


--
-- TOC entry 2044 (class 2604 OID 17185)
-- Name: Countries id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Countries" ALTER COLUMN id SET DEFAULT nextval('"Countries_id_seq"'::regclass);


--
-- TOC entry 2047 (class 2604 OID 17244)
-- Name: Products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products" ALTER COLUMN id SET DEFAULT nextval('"Products_id_seq"'::regclass);


--
-- TOC entry 2050 (class 2604 OID 17273)
-- Name: Products_In_Stock id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products_In_Stock" ALTER COLUMN id SET DEFAULT nextval('"Products_id_seq"'::regclass);


--
-- TOC entry 2051 (class 2604 OID 17274)
-- Name: Products_In_Stock serial; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products_In_Stock" ALTER COLUMN serial SET DEFAULT nextval('"Products_In_Stock_serial_seq"'::regclass);


--
-- TOC entry 2046 (class 2604 OID 17212)
-- Name: Roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Roles" ALTER COLUMN id SET DEFAULT nextval('"Roles_id_seq"'::regclass);


--
-- TOC entry 2048 (class 2604 OID 17255)
-- Name: Stocks id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Stocks" ALTER COLUMN id SET DEFAULT nextval('"Stocks_id_seq"'::regclass);


--
-- TOC entry 2052 (class 2604 OID 17296)
-- Name: Users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users" ALTER COLUMN id SET DEFAULT nextval('"Users_id_seq"'::regclass);


--
-- TOC entry 2190 (class 0 OID 17193)
-- Dependencies: 188
-- Data for Name: Cities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Cities" (id, name, code, country_id) FROM stdin;
1	Ankara	6	1
2	Washington	25	2
\.


--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 187
-- Name: Cities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Cities_id_seq"', 2, true);


--
-- TOC entry 2188 (class 0 OID 17182)
-- Dependencies: 186
-- Data for Name: Countries; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Countries" (id, name, code) FROM stdin;
1	Turkey	90
2	US	1
3	Iraq	65
\.


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 185
-- Name: Countries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Countries_id_seq"', 3, true);


--
-- TOC entry 2194 (class 0 OID 17241)
-- Dependencies: 192
-- Data for Name: Products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Products" (id, name, unit_price, detail) FROM stdin;
1	product1	62	detail1
2	product2	85	detail2
\.


--
-- TOC entry 2198 (class 0 OID 17270)
-- Dependencies: 196
-- Data for Name: Products_In_Stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Products_In_Stock" (id, name, unit_price, detail, stock_id, serial) FROM stdin;
\.


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 195
-- Name: Products_In_Stock_serial_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Products_In_Stock_serial_seq"', 1, false);


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 191
-- Name: Products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Products_id_seq"', 2, true);


--
-- TOC entry 2192 (class 0 OID 17209)
-- Dependencies: 190
-- Data for Name: Roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Roles" (id, role_name) FROM stdin;
1	Customer
2	Employee
\.


--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 189
-- Name: Roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Roles_id_seq"', 2, true);


--
-- TOC entry 2196 (class 0 OID 17252)
-- Dependencies: 194
-- Data for Name: Stocks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Stocks" (id, name, product_id, quantity, unit_price) FROM stdin;
1	stock1	1	123	87
2	stock2	2	125	98
\.


--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 193
-- Name: Stocks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Stocks_id_seq"', 3, true);


--
-- TOC entry 2200 (class 0 OID 17293)
-- Dependencies: 198
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Users" (id, first_name, last_name, user_name, password, address, phone_number, role_id, city_id, birthday) FROM stdin;
1	maho	oham	user1	pass1	address1	phone1	1	1	2001-10-28
2	fname2	lname2	user2	pass2	address2	phone2	2	2	1994-05-05
\.


--
-- TOC entry 2219 (class 0 OID 0)
-- Dependencies: 197
-- Name: Users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Users_id_seq"', 2, true);


--
-- TOC entry 2056 (class 2606 OID 17201)
-- Name: Cities Cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Cities"
    ADD CONSTRAINT "Cities_pkey" PRIMARY KEY (id);


--
-- TOC entry 2054 (class 2606 OID 17190)
-- Name: Countries Countries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Countries"
    ADD CONSTRAINT "Countries_pkey" PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 17249)
-- Name: Products Products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products"
    ADD CONSTRAINT "Products_pkey" PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 17217)
-- Name: Roles Roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Roles"
    ADD CONSTRAINT "Roles_pkey" PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 17261)
-- Name: Stocks Stocks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Stocks"
    ADD CONSTRAINT "Stocks_pkey" PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 17301)
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (id);


--
-- TOC entry 2065 (class 2606 OID 17202)
-- Name: Cities Cities_country_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Cities"
    ADD CONSTRAINT "Cities_country_id_fk" FOREIGN KEY (country_id) REFERENCES "Countries"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2067 (class 2606 OID 17278)
-- Name: Products_In_Stock Products_In_Stock_stock_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products_In_Stock"
    ADD CONSTRAINT "Products_In_Stock_stock_id_fk" FOREIGN KEY (stock_id) REFERENCES "Stocks"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2066 (class 2606 OID 17262)
-- Name: Stocks Stocks_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Stocks"
    ADD CONSTRAINT "Stocks_product_id_fk" FOREIGN KEY (product_id) REFERENCES "Products"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2069 (class 2606 OID 17307)
-- Name: Users Users_city_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "Users_city_id_fk" FOREIGN KEY (city_id) REFERENCES "Cities"(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2068 (class 2606 OID 17302)
-- Name: Users Users_role_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "Users_role_id_fk" FOREIGN KEY (role_id) REFERENCES "Roles"(id) ON UPDATE SET NULL ON DELETE SET NULL;


-- Completed on 2017-12-10 23:06:32

--
-- PostgreSQL database dump complete
--

