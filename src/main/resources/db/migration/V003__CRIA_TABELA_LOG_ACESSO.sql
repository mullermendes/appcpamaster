/*
 * Muller Mendes
 * 19/02/2021
 * Adicionado acesso por login e senha AppCpaMaster.
 * Tabela q armazenara as tentativas de logon do usuário
 */


DO $$

BEGIN

CREATE SEQUENCE acess.sq_tb_log_acesso
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE acess.tb_log_acesso
(
  id integer NOT NULL DEFAULT nextval('acess.sq_tb_log_acesso'::regclass),
  data_acesso timestamp without time zone NOT NULL,
  in_bem_sucedido boolean NOT NULL,
  id_usuario integer NOT NULL,
  CONSTRAINT tb_registro_logon_pkey PRIMARY KEY (id),
  CONSTRAINT tb_registro_logon_id_usuario FOREIGN KEY (id_usuario)
      REFERENCES acess.tb_usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
	COMMENT ON TABLE acess.tb_log_acesso
		IS 'Tabela registra tentativas de log do usuário.';
END $$;
