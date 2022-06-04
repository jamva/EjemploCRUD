-- Database: prueba

-- DROP DATABASE IF EXISTS prueba;

CREATE DATABASE prueba
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
-- Table: public.usuarios

-- DROP TABLE IF EXISTS public.usuarios;

CREATE TABLE IF NOT EXISTS public.usuarios
(
    id serial,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    clave character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuarios_pkey PRIMARY KEY (id),
    CONSTRAINT constraint_usuario_unico UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;