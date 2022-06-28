--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-06-28 16:38:18 WIB

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3386 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 24665)
-- Name: feature; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.feature (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    created_by character varying(255),
    updated_at timestamp without time zone NOT NULL,
    updated_by character varying(255),
    name character varying(255)
);


--
-- TOC entry 213 (class 1259 OID 24664)
-- Name: feature_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.feature_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3387 (class 0 OID 0)
-- Dependencies: 213
-- Name: feature_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.feature_id_seq OWNED BY public.feature.id;


--
-- TOC entry 210 (class 1259 OID 16474)
-- Name: indikator; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.indikator (
    id bigint NOT NULL,
    kode character varying(255),
    uraian character varying(255),
    level integer NOT NULL,
    deleted boolean
);


--
-- TOC entry 209 (class 1259 OID 16473)
-- Name: indikator_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.indikator_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3388 (class 0 OID 0)
-- Dependencies: 209
-- Name: indikator_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.indikator_id_seq OWNED BY public.indikator.id;


--
-- TOC entry 212 (class 1259 OID 16483)
-- Name: penilaian; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.penilaian (
    id bigint NOT NULL,
    file_upload character varying(255),
    tahun integer NOT NULL,
    id_indikator bigint
);


--
-- TOC entry 211 (class 1259 OID 16482)
-- Name: penilaian_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.penilaian_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 211
-- Name: penilaian_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.penilaian_id_seq OWNED BY public.penilaian.id;


--
-- TOC entry 216 (class 1259 OID 24674)
-- Name: role; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    created_by character varying(255),
    updated_at timestamp without time zone NOT NULL,
    updated_by character varying(255),
    name character varying(255)
);


--
-- TOC entry 218 (class 1259 OID 24683)
-- Name: role_feature; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.role_feature (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    created_by character varying(255),
    updated_at timestamp without time zone NOT NULL,
    updated_by character varying(255),
    feature_id bigint,
    role_id bigint
);


--
-- TOC entry 217 (class 1259 OID 24682)
-- Name: role_feature_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.role_feature_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3390 (class 0 OID 0)
-- Dependencies: 217
-- Name: role_feature_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.role_feature_id_seq OWNED BY public.role_feature.id;


--
-- TOC entry 215 (class 1259 OID 24673)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3391 (class 0 OID 0)
-- Dependencies: 215
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 220 (class 1259 OID 24692)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    created_by character varying(255),
    updated_at timestamp without time zone NOT NULL,
    updated_by character varying(255),
    activation_token character varying(255),
    active boolean,
    email character varying(255),
    image character varying(255),
    name character varying(255),
    nip character varying(255),
    password character varying(255),
    phone character varying(255),
    reset_password_token character varying(255),
    status integer,
    username character varying(255),
    role_id bigint
);


--
-- TOC entry 219 (class 1259 OID 24691)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3392 (class 0 OID 0)
-- Dependencies: 219
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3210 (class 2604 OID 24668)
-- Name: feature id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.feature ALTER COLUMN id SET DEFAULT nextval('public.feature_id_seq'::regclass);


--
-- TOC entry 3208 (class 2604 OID 16477)
-- Name: indikator id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.indikator ALTER COLUMN id SET DEFAULT nextval('public.indikator_id_seq'::regclass);


--
-- TOC entry 3209 (class 2604 OID 16486)
-- Name: penilaian id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.penilaian ALTER COLUMN id SET DEFAULT nextval('public.penilaian_id_seq'::regclass);


--
-- TOC entry 3211 (class 2604 OID 24677)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 3212 (class 2604 OID 24686)
-- Name: role_feature id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role_feature ALTER COLUMN id SET DEFAULT nextval('public.role_feature_id_seq'::regclass);


--
-- TOC entry 3213 (class 2604 OID 24695)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3374 (class 0 OID 24665)
-- Dependencies: 214
-- Data for Name: feature; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.feature VALUES (1, '2022-06-28 15:57:05.424762', 'System', '2022-06-28 15:57:05.424762', 'System', 'MENU_INDIKATOR');
INSERT INTO public.feature VALUES (2, '2022-06-28 15:57:30.573126', 'System', '2022-06-28 15:57:30.573126', 'System', 'CRUD_INDIKATOR');


--
-- TOC entry 3370 (class 0 OID 16474)
-- Dependencies: 210
-- Data for Name: indikator; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.indikator VALUES (3, 'A2', 'Uraian A2', 2, false);
INSERT INTO public.indikator VALUES (4, 'B2', 'Uraian B2', 2, false);
INSERT INTO public.indikator VALUES (5, 'C1', 'Uraian C1', 1, false);
INSERT INTO public.indikator VALUES (6, 'C4', 'Uraian C4', 1, false);
INSERT INTO public.indikator VALUES (1, 'A19', 'Uraian A19', 1, false);
INSERT INTO public.indikator VALUES (2, 'B1', 'Uraian B1', 1, true);
INSERT INTO public.indikator VALUES (12, 'Test', 'test', 1, false);


--
-- TOC entry 3372 (class 0 OID 16483)
-- Dependencies: 212
-- Data for Name: penilaian; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3376 (class 0 OID 24674)
-- Dependencies: 216
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.role VALUES (1, '2022-06-28 15:58:05.393538', 'System', '2022-06-28 15:58:05.393538', 'System', 'Admin');
INSERT INTO public.role VALUES (2, '2022-06-28 15:58:05.401385', 'System', '2022-06-28 15:58:05.401385', 'System', 'Staff');


--
-- TOC entry 3378 (class 0 OID 24683)
-- Dependencies: 218
-- Data for Name: role_feature; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.role_feature VALUES (1, '2022-06-28 15:58:25.646077', 'System', '2022-06-28 15:58:25.646077', 'System', 1, 1);
INSERT INTO public.role_feature VALUES (2, '2022-06-28 15:58:47.730172', 'System', '2022-06-28 15:58:47.730172', 'System', 2, 1);
INSERT INTO public.role_feature VALUES (3, '2022-06-28 15:59:03.316141', 'System', '2022-06-28 15:59:03.316141', 'System', 1, 2);


--
-- TOC entry 3380 (class 0 OID 24692)
-- Dependencies: 220
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES (1, '2022-06-28 15:59:38.712039', 'System', '2022-06-28 15:59:38.712039', 'System', NULL, true, NULL, NULL, 'Adit', NULL, '$2a$10$Y1GqDwdOaB.Me9mtTe20Hu8qHvWCCjdNNMV1vpWwyqJV6CHbf3xqa', NULL, NULL, NULL, 'adit-admin', 1);
INSERT INTO public.users VALUES (2, '2022-06-28 16:00:14.308502', 'System', '2022-06-28 16:00:14.308502', 'System', NULL, true, NULL, NULL, 'Aul', NULL, '$2a$10$Y1GqDwdOaB.Me9mtTe20Hu8qHvWCCjdNNMV1vpWwyqJV6CHbf3xqa', NULL, NULL, NULL, 'aul-staf', 2);


--
-- TOC entry 3393 (class 0 OID 0)
-- Dependencies: 213
-- Name: feature_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.feature_id_seq', 1, true);


--
-- TOC entry 3394 (class 0 OID 0)
-- Dependencies: 209
-- Name: indikator_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.indikator_id_seq', 12, true);


--
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 211
-- Name: penilaian_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.penilaian_id_seq', 1, false);


--
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 217
-- Name: role_feature_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.role_feature_id_seq', 3, true);


--
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 215
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.role_id_seq', 2, true);


--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 219
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- TOC entry 3219 (class 2606 OID 24672)
-- Name: feature feature_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.feature
    ADD CONSTRAINT feature_pkey PRIMARY KEY (id);


--
-- TOC entry 3215 (class 2606 OID 16481)
-- Name: indikator indikator_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.indikator
    ADD CONSTRAINT indikator_pkey PRIMARY KEY (id);


--
-- TOC entry 3217 (class 2606 OID 16488)
-- Name: penilaian penilaian_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.penilaian
    ADD CONSTRAINT penilaian_pkey PRIMARY KEY (id);


--
-- TOC entry 3223 (class 2606 OID 24690)
-- Name: role_feature role_feature_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role_feature
    ADD CONSTRAINT role_feature_pkey PRIMARY KEY (id);


--
-- TOC entry 3221 (class 2606 OID 24681)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 3225 (class 2606 OID 24699)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3226 (class 2606 OID 16489)
-- Name: penilaian fk1kqo9kstwdfhsp34xhrakxrn8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.penilaian
    ADD CONSTRAINT fk1kqo9kstwdfhsp34xhrakxrn8 FOREIGN KEY (id_indikator) REFERENCES public.indikator(id);


--
-- TOC entry 3229 (class 2606 OID 24710)
-- Name: users fk4qu1gr772nnf6ve5af002rwya; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk4qu1gr772nnf6ve5af002rwya FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 3227 (class 2606 OID 24700)
-- Name: role_feature fk602jkws28uc62gtuyokf4ke07; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role_feature
    ADD CONSTRAINT fk602jkws28uc62gtuyokf4ke07 FOREIGN KEY (feature_id) REFERENCES public.feature(id);


--
-- TOC entry 3228 (class 2606 OID 24705)
-- Name: role_feature fkkvt34970jxowf984hrm3loqlg; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role_feature
    ADD CONSTRAINT fkkvt34970jxowf984hrm3loqlg FOREIGN KEY (role_id) REFERENCES public.role(id);


-- Completed on 2022-06-28 16:38:18 WIB

--
-- PostgreSQL database dump complete
--

