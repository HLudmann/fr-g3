--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: bet; Type: TABLE; Schema: public; Owner: hugo
--

CREATE TABLE bet (
    id integer NOT NULL,
    amount integer NOT NULL,
    type character(3) NOT NULL,
    first integer NOT NULL,
    second integer NOT NULL,
    third integer NOT NULL,
    competition character varying(20) NOT NULL,
    player character varying(20) NOT NULL,
    CONSTRAINT check_type CHECK (((type = 'SGL'::bpchar) OR (type = 'POD'::bpchar)))
);


ALTER TABLE bet OWNER TO hugo;

--
-- Name: competition; Type: TABLE; Schema: public; Owner: hugo
--

CREATE TABLE competition (
    name character varying(20) NOT NULL,
    date date NOT NULL
);


ALTER TABLE competition OWNER TO hugo;

--
-- Name: competitor; Type: TABLE; Schema: public; Owner: hugo
--

CREATE TABLE competitor (
    lastname character varying(100) NOT NULL,
    firstname character varying(100) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE competitor OWNER TO hugo;

--
-- Name: participate; Type: TABLE; Schema: public; Owner: hugo
--

CREATE TABLE participate (
    competitor integer NOT NULL,
    competition character varying(20) NOT NULL
);


ALTER TABLE participate OWNER TO hugo;

--
-- Name: system_user; Type: TABLE; Schema: public; Owner: hugo
--

CREATE TABLE system_user (
    lastname character varying(100) NOT NULL,
    firstname character varying(100) NOT NULL,
    password character(32) NOT NULL,
    nickname character varying(20) NOT NULL,
    type character(3) NOT NULL,
    wallet integer NOT NULL,
    CONSTRAINT check_type CHECK (((type = 'PLR'::bpchar) OR (type = 'MNG'::bpchar)))
);


ALTER TABLE system_user OWNER TO hugo;

--
-- Data for Name: bet; Type: TABLE DATA; Schema: public; Owner: hugo
--

COPY bet (id, amount, type, first, second, third, competition, player) FROM stdin;
\.


--
-- Data for Name: competition; Type: TABLE DATA; Schema: public; Owner: hugo
--

COPY competition (name, date) FROM stdin;
\.


--
-- Data for Name: competitor; Type: TABLE DATA; Schema: public; Owner: hugo
--

COPY competitor (lastname, firstname, id) FROM stdin;
\.


--
-- Data for Name: participate; Type: TABLE DATA; Schema: public; Owner: hugo
--

COPY participate (competitor, competition) FROM stdin;
\.


--
-- Data for Name: system_user; Type: TABLE DATA; Schema: public; Owner: hugo
--

COPY system_user (lastname, firstname, password, nickname, type, wallet) FROM stdin;
\.


--
-- Name: primary_key_bet; Type: CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY bet
    ADD CONSTRAINT primary_key_bet PRIMARY KEY (id);


--
-- Name: primary_key_competition; Type: CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY competition
    ADD CONSTRAINT primary_key_competition PRIMARY KEY (name);


--
-- Name: primary_key_competitor; Type: CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY competitor
    ADD CONSTRAINT primary_key_competitor PRIMARY KEY (id);


--
-- Name: primary_key_participate; Type: CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY participate
    ADD CONSTRAINT primary_key_participate PRIMARY KEY (competition, competitor);


--
-- Name: primary_key_sysuser; Type: CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT primary_key_sysuser PRIMARY KEY (nickname);


--
-- Name: foreign_key_competetiton; Type: FK CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY bet
    ADD CONSTRAINT foreign_key_competetiton FOREIGN KEY (competition) REFERENCES competition(name);


--
-- Name: foreign_key_competition; Type: FK CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY participate
    ADD CONSTRAINT foreign_key_competition FOREIGN KEY (competition) REFERENCES competition(name);


--
-- Name: foreign_key_competitor; Type: FK CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY participate
    ADD CONSTRAINT foreign_key_competitor FOREIGN KEY (competitor) REFERENCES competitor(id);


--
-- Name: foreign_key_first; Type: FK CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY bet
    ADD CONSTRAINT foreign_key_first FOREIGN KEY (first) REFERENCES competitor(id);


--
-- Name: foreign_key_player; Type: FK CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY bet
    ADD CONSTRAINT foreign_key_player FOREIGN KEY (player) REFERENCES system_user(nickname);


--
-- Name: foreign_key_second; Type: FK CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY bet
    ADD CONSTRAINT foreign_key_second FOREIGN KEY (second) REFERENCES competitor(id);


--
-- Name: foreign_key_third; Type: FK CONSTRAINT; Schema: public; Owner: hugo
--

ALTER TABLE ONLY bet
    ADD CONSTRAINT foreign_key_third FOREIGN KEY (third) REFERENCES competitor(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

