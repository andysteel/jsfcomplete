CREATE DATABASE spring
  WITH OWNER = root
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

CREATE SCHEMA jsf_complete AUTHORIZATION root;

CREATE TABLE jsf_complete.grupo
(
  id bigint NOT NULL,
  descricao character varying(80) NOT NULL,
  nome character varying(40) NOT NULL,
  CONSTRAINT grupo_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE jsf_complete.grupo
  OWNER TO root;

CREATE TABLE jsf_complete.usuario
(
  id bigint NOT NULL,
  email character varying(255) NOT NULL,
  nome character varying(80) NOT NULL,
  senha character varying(100) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT uk_5171l57faosmj8myawaucatdw UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE jsf_complete.usuario
  OWNER TO root;

CREATE TABLE jsf_complete.usuario_grupo
(
  usuario_id bigint NOT NULL,
  grupo_id bigint NOT NULL,
  CONSTRAINT fk_5p20y5panoea7wc040qm6eemd FOREIGN KEY (grupo_id)
      REFERENCES jsf_complete.grupo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_m32it4c8rkf6t8nno481k43q4 FOREIGN KEY (usuario_id)
      REFERENCES jsf_complete.usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE jsf_complete.usuario_grupo
  OWNER TO root;

CREATE SEQUENCE jsf_complete.seq_grupo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9999999999
  START 1
  CACHE 20;
ALTER TABLE jsf_complete.seq_grupo
  OWNER TO root;

CREATE SEQUENCE jsf_complete.seq_usuario
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9999999999
  START 100
  CACHE 20;
ALTER TABLE jsf_complete.seq_usuario
  OWNER TO root;