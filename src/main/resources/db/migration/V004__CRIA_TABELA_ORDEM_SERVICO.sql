/*
 * Muller Mendes
 * 19/02/2021
 * Adicionado tabea de ordem de serviço.
 * Tabela que registra ordem de serviço.
 */

DO $$

BEGIN

CREATE SEQUENCE core.sq_tb_ordem_servico
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS core.tb_ordem_servico
(
  id integer NOT NULL DEFAULT nextval('core.sq_tb_ordem_servico'::regclass),
  id_usuario integer NOT NULL,
  descricao text NOT NULL,
  preco decimal(60,2) NOT NULL,
  status varchar(20) NOT NULL,
  data_abertura timestamp (without time zone NOT NULL,
  data_finalizacao timestamp without time zone NOT NULL
  CONSTRAINT tb_ordem_servico_pkey PRIMARY KEY (id),
  CONSTRAINT tb_ordem_servico_id_usuario_fkey FOREIGN KEY (id_usuario)
    REFERENCES acess.tb_usuario (id) MATCH SIMPL
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

	COMMENT ON TABLE core.tb_ordem_servico
		IS 'Tabela utilizada para registros de ordens de serviço.';
END $$;
