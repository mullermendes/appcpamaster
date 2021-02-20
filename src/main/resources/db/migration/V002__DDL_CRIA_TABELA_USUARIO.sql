/*
 * Muller Mendes
 * 19/02/2021
 * Adicionado tabea de usuário.
 * Tabela q armazenara usuários do sistema
 */

DO $$

BEGIN

CREATE SEQUENCE acess.sq_tb_usuario
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS acess.tb_usuario
(
  id integer NOT NULL DEFAULT nextval('acess.sq_tb_usuario'::regclass),
  nome varchar(60) NOT NULL,
  email varchar(155) NOT NULL,
  telefone varchar(20) NOT NULL,
  CONSTRAINT tb_usuario_pkey PRIMARY KEY (id)
);

	COMMENT ON TABLE acess.tb_usuario
		IS 'Tabela utilizada para registros de usuário.';
END $$;
