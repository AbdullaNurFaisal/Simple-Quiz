--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3 (Ubuntu 13.3-1.pgdg20.04+1)
-- Dumped by pg_dump version 13.3 (Ubuntu 13.3-1.pgdg20.04+1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: quiz_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quiz_info (
    quiz_id integer,
    question character varying(255),
    option1 character varying(255),
    option2 character varying(255),
    option3 character varying(255),
    option4 character varying(255),
    answer character varying(255)
);


ALTER TABLE public.quiz_info OWNER TO postgres;

--
-- Name: user_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_info (
    username character varying(255),
    password character varying(255)
);


ALTER TABLE public.user_info OWNER TO postgres;

--
-- Data for Name: quiz_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.quiz_info (quiz_id, question, option1, option2, option3, option4, answer) FROM stdin;
\.


--
-- Data for Name: user_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_info (username, password) FROM stdin;
\.


--
-- PostgreSQL database dump complete
--

