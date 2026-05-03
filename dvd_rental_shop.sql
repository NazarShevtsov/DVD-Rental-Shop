--
-- PostgreSQL database dump
--

\restrict jPSpxXKowqkVhLdruosOxzL8aB1W6fa7cuno7p0q0sDPQXYD4VhJjwWb2DWCp6v

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-03 16:13:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 222 (class 1259 OID 16798)
-- Name: clients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clients (
    id_client integer NOT NULL,
    client_first_name character varying(30) NOT NULL,
    client_last_name character varying(50) CONSTRAINT clients_client_second_name_not_null NOT NULL,
    client_birth_date date CONSTRAINT clients_client_date_of_birth_not_null NOT NULL,
    client_phone character varying(20),
    client_email character varying(100)
);


ALTER TABLE public.clients OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16797)
-- Name: clients_id_client_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.clients ALTER COLUMN id_client ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.clients_id_client_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 220 (class 1259 OID 16787)
-- Name: movies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movies (
    id_movie integer CONSTRAINT films_id_film_not_null NOT NULL,
    movie_title character varying(100) CONSTRAINT films_film_name_not_null NOT NULL,
    movie_year integer CONSTRAINT films_film_year_not_null NOT NULL,
    movie_country character varying(50) CONSTRAINT films_film_country_not_null NOT NULL,
    movie_price numeric(5,2) CONSTRAINT films_film_price_not_null NOT NULL,
    id_genre integer
);


ALTER TABLE public.movies OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16786)
-- Name: films_id_film_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.movies ALTER COLUMN id_movie ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.films_id_film_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 230 (class 1259 OID 16863)
-- Name: genres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genres (
    id_genre integer CONSTRAINT genre_id_genre_not_null NOT NULL,
    genre_name character varying(50) CONSTRAINT genre_genre_name_not_null NOT NULL
);


ALTER TABLE public.genres OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16862)
-- Name: genre_id_genre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.genres ALTER COLUMN id_genre ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.genre_id_genre_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 224 (class 1259 OID 16808)
-- Name: rentals; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rentals (
    id_order integer CONSTRAINT order_list_id_order_list_not_null NOT NULL,
    id_movie integer,
    id_client integer,
    rented_due_to date CONSTRAINT order_list_rented_due_to_not_null NOT NULL
);


ALTER TABLE public.rentals OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16807)
-- Name: order_list_id_order_list_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.rentals ALTER COLUMN id_order ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.order_list_id_order_list_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 228 (class 1259 OID 16844)
-- Name: reviews; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reviews (
    id_review integer CONSTRAINT revue_id_revue_not_null NOT NULL,
    id_movie integer,
    id_client integer,
    review character varying(255) CONSTRAINT revue_revue_not_null NOT NULL,
    review_date date CONSTRAINT revue_revue_date_not_null NOT NULL
);


ALTER TABLE public.reviews OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16843)
-- Name: revue_id_revue_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.reviews ALTER COLUMN id_review ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.revue_id_revue_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 16826)
-- Name: wish_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wish_list (
    id_order integer CONSTRAINT want_to_order_list_id_order_list_not_null NOT NULL,
    id_movie integer,
    id_client integer,
    rent_when date CONSTRAINT want_to_order_list_to_rent_when_not_null NOT NULL
);


ALTER TABLE public.wish_list OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16825)
-- Name: want_to_order_list_id_order_list_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.wish_list ALTER COLUMN id_order ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.want_to_order_list_id_order_list_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 5050 (class 0 OID 16798)
-- Dependencies: 222
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clients (id_client, client_first_name, client_last_name, client_birth_date, client_phone, client_email) FROM stdin;
1	John	Smith	1990-05-14	+48 501 234 567	john.smith@example.com
2	Emma	Johnson	1988-11-02	+48 502 345 678	emma.johnson@example.com
3	Michael	Brown	1995-03-22	+48 503 456 789	michael.brown@example.com
4	Olivia	Davis	2000-07-10	+48 504 567 890	olivia.davis@example.com
5	William	Miller	1992-01-18	+48 505 678 901	william.miller@example.com
6	Sophia	Wilson	1998-09-25	+48 506 789 012	sophia.wilson@example.com
7	James	Moore	1985-12-30	+48 507 890 123	james.moore@example.com
8	Isabella	Taylor	1993-06-15	+48 508 901 234	isabella.taylor@example.com
9	Daniel	Anderson	1991-04-08	+48 509 012 345	daniel.anderson@example.com
10	Mia	Thomas	1999-10-27	+48 510 123 456	mia.thomas@example.com
\.


--
-- TOC entry 5058 (class 0 OID 16863)
-- Dependencies: 230
-- Data for Name: genres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genres (id_genre, genre_name) FROM stdin;
1	Sci-Fi
2	Action
3	Cyberpunk
4	Drama
5	Historical
6	Thriller
7	Mystery
8	War
9	Fantasy
10	Tech Thriller
11	Adventure
20	Shonen
\.


--
-- TOC entry 5048 (class 0 OID 16787)
-- Dependencies: 220
-- Data for Name: movies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movies (id_movie, movie_title, movie_year, movie_country, movie_price, id_genre) FROM stdin;
1	The Last Horizon	2019	USA	12.99	1
2	Shadow Hunters	2021	UK	9.99	2
3	Neon City	2020	Japan	14.50	3
4	Frozen Path	2018	Canada	8.99	4
5	Golden Empire	2022	USA	15.99	5
6	Silent River	2017	France	7.50	6
7	Dark Matter	2023	Germany	16.99	1
8	Lost Signal	2016	Australia	6.99	7
9	Crimson Sky	2020	USA	13.49	8
10	Echo World	2021	South Korea	11.99	9
11	Broken Time	2019	Italy	10.50	4
12	Final Code	2024	USA	17.99	10
13	Ocean Void	2015	Spain	5.99	11
14	Steel Hearts	2022	UK	14.99	2
15	Night Protocol	2023	USA	18.50	6
\.


--
-- TOC entry 5052 (class 0 OID 16808)
-- Dependencies: 224
-- Data for Name: rentals; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rentals (id_order, id_movie, id_client, rented_due_to) FROM stdin;
1	1	1	2026-05-02
2	2	2	2026-05-05
3	3	3	2026-04-30
4	4	4	2026-05-10
5	5	5	2026-05-03
6	6	6	2026-05-08
7	7	7	2026-05-01
8	8	8	2026-05-12
\.


--
-- TOC entry 5056 (class 0 OID 16844)
-- Dependencies: 228
-- Data for Name: reviews; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reviews (id_review, id_movie, id_client, review, review_date) FROM stdin;
1	1	1	Great sci-fi movie with amazing visuals.	2026-05-05
2	2	2	Good action scenes but weak story.	2026-05-06
3	3	3	Very interesting and unique atmosphere.	2026-05-07
4	4	4	Emotional and well-acted drama.	2026-05-08
5	5	5	A bit slow but visually stunning.	2026-05-09
\.


--
-- TOC entry 5054 (class 0 OID 16826)
-- Dependencies: 226
-- Data for Name: wish_list; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.wish_list (id_order, id_movie, id_client, rent_when) FROM stdin;
1	1	1	2026-05-03
2	2	2	2026-05-18
3	3	3	2026-05-11
4	4	4	2026-05-07
5	5	5	2026-05-21
6	6	6	2026-05-14
7	7	7	2026-05-09
8	8	8	2026-05-24
9	9	9	2026-05-16
10	10	1	2026-05-05
11	11	2	2026-05-12
12	12	3	2026-05-20
13	13	4	2026-05-08
14	14	5	2026-05-23
15	15	6	2026-05-15
\.


--
-- TOC entry 5064 (class 0 OID 0)
-- Dependencies: 221
-- Name: clients_id_client_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clients_id_client_seq', 22, true);


--
-- TOC entry 5065 (class 0 OID 0)
-- Dependencies: 219
-- Name: films_id_film_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.films_id_film_seq', 19, true);


--
-- TOC entry 5066 (class 0 OID 0)
-- Dependencies: 229
-- Name: genre_id_genre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genre_id_genre_seq', 21, true);


--
-- TOC entry 5067 (class 0 OID 0)
-- Dependencies: 223
-- Name: order_list_id_order_list_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_list_id_order_list_seq', 11, true);


--
-- TOC entry 5068 (class 0 OID 0)
-- Dependencies: 227
-- Name: revue_id_revue_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.revue_id_revue_seq', 10, true);


--
-- TOC entry 5069 (class 0 OID 0)
-- Dependencies: 225
-- Name: want_to_order_list_id_order_list_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.want_to_order_list_id_order_list_seq', 17, true);


--
-- TOC entry 4884 (class 2606 OID 16806)
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id_client);


--
-- TOC entry 4882 (class 2606 OID 16796)
-- Name: movies films_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movies
    ADD CONSTRAINT films_pkey PRIMARY KEY (id_movie);


--
-- TOC entry 4892 (class 2606 OID 16869)
-- Name: genres genre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genre_pkey PRIMARY KEY (id_genre);


--
-- TOC entry 4886 (class 2606 OID 16814)
-- Name: rentals order_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rentals
    ADD CONSTRAINT order_list_pkey PRIMARY KEY (id_order);


--
-- TOC entry 4890 (class 2606 OID 16851)
-- Name: reviews revue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT revue_pkey PRIMARY KEY (id_review);


--
-- TOC entry 4888 (class 2606 OID 16832)
-- Name: wish_list want_to_order_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wish_list
    ADD CONSTRAINT want_to_order_list_pkey PRIMARY KEY (id_order);


--
-- TOC entry 4893 (class 2606 OID 16870)
-- Name: movies films_id_genre_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movies
    ADD CONSTRAINT films_id_genre_fkey FOREIGN KEY (id_genre) REFERENCES public.genres(id_genre);


--
-- TOC entry 4894 (class 2606 OID 16820)
-- Name: rentals order_list_id_client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rentals
    ADD CONSTRAINT order_list_id_client_fkey FOREIGN KEY (id_client) REFERENCES public.clients(id_client);


--
-- TOC entry 4895 (class 2606 OID 16815)
-- Name: rentals order_list_id_film_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rentals
    ADD CONSTRAINT order_list_id_film_fkey FOREIGN KEY (id_movie) REFERENCES public.movies(id_movie);


--
-- TOC entry 4898 (class 2606 OID 16857)
-- Name: reviews revue_id_client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT revue_id_client_fkey FOREIGN KEY (id_client) REFERENCES public.clients(id_client);


--
-- TOC entry 4899 (class 2606 OID 16852)
-- Name: reviews revue_id_film_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT revue_id_film_fkey FOREIGN KEY (id_movie) REFERENCES public.movies(id_movie);


--
-- TOC entry 4896 (class 2606 OID 16838)
-- Name: wish_list want_to_order_list_id_client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wish_list
    ADD CONSTRAINT want_to_order_list_id_client_fkey FOREIGN KEY (id_client) REFERENCES public.clients(id_client);


--
-- TOC entry 4897 (class 2606 OID 16833)
-- Name: wish_list want_to_order_list_id_film_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wish_list
    ADD CONSTRAINT want_to_order_list_id_film_fkey FOREIGN KEY (id_movie) REFERENCES public.movies(id_movie);


-- Completed on 2026-05-03 16:13:44

--
-- PostgreSQL database dump complete
--

\unrestrict jPSpxXKowqkVhLdruosOxzL8aB1W6fa7cuno7p0q0sDPQXYD4VhJjwWb2DWCp6v

