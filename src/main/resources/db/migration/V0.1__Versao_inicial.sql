CREATE TABLE pais (
    id bigserial NOT NULL,
    version bigint NOT NULL,
    nome character varying(255) NOT NULL,
    sigla character varying(2) NOT NULL,
    denominacao_nacionalidade character varying(255),
    ddi character varying(2)
);

ALTER TABLE ONLY pais ADD CONSTRAINT pais_pk PRIMARY KEY (id);

ALTER TABLE ONLY pais ADD CONSTRAINT pais_sigla_uk UNIQUE (sigla);


CREATE TABLE unidade_federativa (
    id bigserial NOT NULL,
    version bigint NOT NULL,
    nome character varying(255) NOT NULL,
    sigla character varying(2) NOT NULL
);


ALTER TABLE ONLY unidade_federativa ADD CONSTRAINT uf_pk PRIMARY KEY (id);

ALTER TABLE ONLY unidade_federativa ADD CONSTRAINT uf_sigla_uk UNIQUE (sigla);

CREATE TABLE cidade (
    id bigserial NOT NULL,
    version bigint NOT NULL,
    nome character varying(255) NOT NULL,
    pais_id bigint,
    uf_id bigint
);


ALTER TABLE ONLY cidade ADD CONSTRAINT cidade_pk PRIMARY KEY (id);

ALTER TABLE ONLY cidade ADD CONSTRAINT cidade_uf_id_fk FOREIGN KEY (uf_id) REFERENCES unidade_federativa(id);

ALTER TABLE ONLY cidade ADD CONSTRAINT cidade_pais_id_fk FOREIGN KEY (pais_id) REFERENCES pais(id);


CREATE TABLE pessoa (
    id bigserial NOT NULL,
    version bigint NOT NULL,
    cpf character varying(11),
    nome character varying(255) NOT NULL,
    data_nascimento date,
    sexo character varying(1),
    passaporte character varying(255),
    naturalidade_id bigint
);


ALTER TABLE ONLY pessoa ADD CONSTRAINT pessoa_pk PRIMARY KEY (id);

ALTER TABLE ONLY pessoa ADD CONSTRAINT pessoa_cpf_uk UNIQUE (cpf);

ALTER TABLE ONLY pessoa ADD CONSTRAINT pessoa_passaporte_uk UNIQUE (passaporte);

ALTER TABLE ONLY pessoa ADD CONSTRAINT pessoa_naturalidade_id_fk FOREIGN KEY (naturalidade_id) REFERENCES cidade(id);


CREATE TABLE email (
    id bigserial NOT NULL,
    version bigint NOT NULL,
    endereco character varying(255) NOT NULL,
    pessoa_id bigint
);

ALTER TABLE ONLY email ADD CONSTRAINT email_pk PRIMARY KEY (id);

ALTER TABLE ONLY email ADD CONSTRAINT email_endereco_uk UNIQUE (endereco); 

ALTER TABLE ONLY email ADD CONSTRAINT email_pessoa_id_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


CREATE TABLE nacionalidade (
    pais_id bigint NOT NULL,
    pessoa_id bigint NOT NULL,
    version bigint NOT NULL,
    tipo character varying(12) NOT NULL
);

ALTER TABLE ONLY nacionalidade ADD CONSTRAINT nacionalidade_pk PRIMARY KEY (pais_id, pessoa_id);

ALTER TABLE ONLY nacionalidade ADD CONSTRAINT nacionalidade_pessoa_id_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);

ALTER TABLE ONLY nacionalidade ADD CONSTRAINT nacionalidade_pais_id_fk FOREIGN KEY (pais_id) REFERENCES pais(id);