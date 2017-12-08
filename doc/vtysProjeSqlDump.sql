--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2017-12-08 23:39:20

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
-- TOC entry 188 (class 1259 OID 16975)
-- Name: Cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Cities" (
    id integer NOT NULL,
    name character varying NOT NULL,
    code integer NOT NULL,
    "countryId" integer
);


ALTER TABLE "Cities" OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16973)
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
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 187
-- Name: Cities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Cities_id_seq" OWNED BY "Cities".id;


--
-- TOC entry 186 (class 1259 OID 16964)
-- Name: Countries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Countries" (
    id integer NOT NULL,
    name character varying NOT NULL,
    code integer NOT NULL
);


ALTER TABLE "Countries" OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 17023)
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
-- TOC entry 197 (class 1259 OID 17036)
-- Name: Products_In_Stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Products_In_Stock" (
    id integer NOT NULL,
    "productId" integer NOT NULL,
    serial_number integer NOT NULL,
    defective_status boolean
);


ALTER TABLE "Products_In_Stock" OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 17032)
-- Name: Products_In_Stock_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Products_In_Stock_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Products_In_Stock_id_seq" OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 195
-- Name: Products_In_Stock_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Products_In_Stock_id_seq" OWNED BY "Products_In_Stock".id;


--
-- TOC entry 196 (class 1259 OID 17034)
-- Name: Products_In_Stock_serial_number_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Products_In_Stock_serial_number_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Products_In_Stock_serial_number_seq" OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 196
-- Name: Products_In_Stock_serial_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Products_In_Stock_serial_number_seq" OWNED BY "Products_In_Stock".serial_number;


--
-- TOC entry 193 (class 1259 OID 17021)
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
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 193
-- Name: Products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Products_id_seq" OWNED BY "Products".id;


--
-- TOC entry 190 (class 1259 OID 16991)
-- Name: Roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Roles" (
    id integer NOT NULL,
    role_name character varying NOT NULL
);


ALTER TABLE "Roles" OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16989)
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
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 189
-- Name: Roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Roles_id_seq" OWNED BY "Roles".id;


--
-- TOC entry 199 (class 1259 OID 17050)
-- Name: Stocks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Stocks" (
    id integer NOT NULL,
    "productId" integer NOT NULL,
    quantity integer DEFAULT 0,
    unit_price integer NOT NULL
);


ALTER TABLE "Stocks" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 17048)
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
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 198
-- Name: Stocks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Stocks_id_seq" OWNED BY "Stocks".id;


--
-- TOC entry 192 (class 1259 OID 17002)
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
    role integer NOT NULL,
    "cityId" integer NOT NULL
);


ALTER TABLE "Users" OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 17000)
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
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 191
-- Name: Users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Users_id_seq" OWNED BY "Users".id;


--
-- TOC entry 185 (class 1259 OID 16962)
-- Name: countries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE countries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE countries_id_seq OWNER TO postgres;

--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 185
-- Name: countries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE countries_id_seq OWNED BY "Countries".id;


--
-- TOC entry 2045 (class 2604 OID 16978)
-- Name: Cities id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Cities" ALTER COLUMN id SET DEFAULT nextval('"Cities_id_seq"'::regclass);


--
-- TOC entry 2044 (class 2604 OID 16967)
-- Name: Countries id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Countries" ALTER COLUMN id SET DEFAULT nextval('countries_id_seq'::regclass);


--
-- TOC entry 2048 (class 2604 OID 17026)
-- Name: Products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products" ALTER COLUMN id SET DEFAULT nextval('"Products_id_seq"'::regclass);


--
-- TOC entry 2049 (class 2604 OID 17039)
-- Name: Products_In_Stock id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products_In_Stock" ALTER COLUMN id SET DEFAULT nextval('"Products_In_Stock_id_seq"'::regclass);


--
-- TOC entry 2050 (class 2604 OID 17040)
-- Name: Products_In_Stock serial_number; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products_In_Stock" ALTER COLUMN serial_number SET DEFAULT nextval('"Products_In_Stock_serial_number_seq"'::regclass);


--
-- TOC entry 2046 (class 2604 OID 16994)
-- Name: Roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Roles" ALTER COLUMN id SET DEFAULT nextval('"Roles_id_seq"'::regclass);


--
-- TOC entry 2051 (class 2604 OID 17053)
-- Name: Stocks id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Stocks" ALTER COLUMN id SET DEFAULT nextval('"Stocks_id_seq"'::regclass);


--
-- TOC entry 2047 (class 2604 OID 17005)
-- Name: Users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users" ALTER COLUMN id SET DEFAULT nextval('"Users_id_seq"'::regclass);


--
-- TOC entry 2192 (class 0 OID 16975)
-- Dependencies: 188
-- Data for Name: Cities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Cities" (id, name, code, "countryId") FROM stdin;
\.


--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 187
-- Name: Cities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Cities_id_seq"', 1, false);


--
-- TOC entry 2190 (class 0 OID 16964)
-- Dependencies: 186
-- Data for Name: Countries; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Countries" (id, name, code) FROM stdin;
\.


--
-- TOC entry 2198 (class 0 OID 17023)
-- Dependencies: 194
-- Data for Name: Products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Products" (id, name, unit_price, detail) FROM stdin;
\.


--
-- TOC entry 2201 (class 0 OID 17036)
-- Dependencies: 197
-- Data for Name: Products_In_Stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Products_In_Stock" (id, "productId", serial_number, defective_status) FROM stdin;
\.


--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 195
-- Name: Products_In_Stock_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Products_In_Stock_id_seq"', 1, false);


--
-- TOC entry 2219 (class 0 OID 0)
-- Dependencies: 196
-- Name: Products_In_Stock_serial_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Products_In_Stock_serial_number_seq"', 1, false);


--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 193
-- Name: Products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Products_id_seq"', 1, false);


--
-- TOC entry 2194 (class 0 OID 16991)
-- Dependencies: 190
-- Data for Name: Roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Roles" (id, role_name) FROM stdin;
\.


--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 189
-- Name: Roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Roles_id_seq"', 1, false);


--
-- TOC entry 2203 (class 0 OID 17050)
-- Dependencies: 199
-- Data for Name: Stocks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Stocks" (id, "productId", quantity, unit_price) FROM stdin;
\.


--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 198
-- Name: Stocks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Stocks_id_seq"', 1, false);


--
-- TOC entry 2196 (class 0 OID 17002)
-- Dependencies: 192
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Users" (id, first_name, last_name, user_name, password, address, phone_number, role, "cityId") FROM stdin;
\.


--
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 191
-- Name: Users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Users_id_seq"', 1, false);


--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 185
-- Name: countries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('countries_id_seq', 1, false);


--
-- TOC entry 2056 (class 2606 OID 16983)
-- Name: Cities Cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Cities"
    ADD CONSTRAINT "Cities_pkey" PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 17042)
-- Name: Products_In_Stock Products_In_Stock_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products_In_Stock"
    ADD CONSTRAINT "Products_In_Stock_pkey" PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 17031)
-- Name: Products Products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products"
    ADD CONSTRAINT "Products_pkey" PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 16999)
-- Name: Roles Roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Roles"
    ADD CONSTRAINT "Roles_pkey" PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 17056)
-- Name: Stocks Stocks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Stocks"
    ADD CONSTRAINT "Stocks_pkey" PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 17010)
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (id);


--
-- TOC entry 2054 (class 2606 OID 16972)
-- Name: Countries countries_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Countries"
    ADD CONSTRAINT countries_pk PRIMARY KEY (id);


--
-- TOC entry 2067 (class 2606 OID 16984)
-- Name: Cities Cities_countryId_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Cities"
    ADD CONSTRAINT "Cities_countryId_fk" FOREIGN KEY ("countryId") REFERENCES "Countries"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2070 (class 2606 OID 17043)
-- Name: Products_In_Stock Products_In_Stock_productId_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Products_In_Stock"
    ADD CONSTRAINT "Products_In_Stock_productId_fk" FOREIGN KEY ("productId") REFERENCES "Products"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2071 (class 2606 OID 17057)
-- Name: Stocks Stocks_productId_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Stocks"
    ADD CONSTRAINT "Stocks_productId_fk" FOREIGN KEY ("productId") REFERENCES "Products_In_Stock"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2069 (class 2606 OID 17016)
-- Name: Users Users_cityId_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "Users_cityId_fk" FOREIGN KEY ("cityId") REFERENCES "Cities"(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2068 (class 2606 OID 17011)
-- Name: Users Users_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "Users_role_fk" FOREIGN KEY (role) REFERENCES "Roles"(id) ON UPDATE SET NULL ON DELETE SET NULL;


-- Completed on 2017-12-08 23:39:20

--
-- PostgreSQL database dump complete
--

