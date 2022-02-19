CREATE TABLE public.clientes (
    codigo integer NOT NULL,
    nome character varying(120),
    cpf character varying(14),
    rg character varying(12),
    email character varying(100),
    endereco character varying(225),
    numero character varying(20),
    bairro character varying(80),
    cep character varying(9),
    complemento character varying(50),
    telefone character varying(20),
    celular character varying(20),
    notifica_whats character(1),
    observacao character varying(255),
    data_cadastro timestamp without time zone,
    data_alteracao timestamp without time zone
);


--
-- Name: configuracoes; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.configuracoes (
    cod_configuracao integer NOT NULL,
    nm_razaosocial character varying(255),
    nm_responsavel character varying(255),
    nu_cnpj character varying(20),
    ds_email character varying(100),
    ds_senha_email character varying(80),
    ds_smtp character varying(80),
    ds_porta_smtp character varying(20),
    ds_ssl character varying(1),
    ds_tls character varying(1),
    ds_mensagem_padrao character varying(255),
    dt_configuracao timestamp without time zone
);


--
-- Name: counters; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.counters (
    nome character varying(50),
    valor integer
);


--
-- Name: funcionario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.funcionario (
    codigo integer NOT NULL,
    nome character varying(120),
    data_cadastro timestamp without time zone,
    cpf character varying(14),
    rg character varying(12),
    email character varying(100),
    endereco character varying(255),
    numero character varying(6),
    bairro character varying(80),
    cep character varying(9),
    complemento character varying(50),
    telefone character varying(20),
    celular character varying(20),
    observacao character varying(255),
    data_alteracao timestamp without time zone
);


--
-- Name: itens_vendas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.itens_vendas (
    cod_produtos integer NOT NULL,
    cod_venda integer NOT NULL,
    qt_servico_vendido integer NOT NULL,
    vl_unitario_produto_vendido double precision
);


--
-- Name: produtos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.produtos (
    cod_produtos integer NOT NULL,
    preco double precision,
    data_cadastro timestamp without time zone,
    data_alteracao timestamp without time zone,
    usuario character varying(50),
    observacao character varying(255),
    inativo character varying(1),
    descricao character varying(150)
);


--
-- Name: relatorios; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.relatorios (
    cod_relatorio integer NOT NULL,
    descricao character varying(50),
    diretorio character varying(240),
    categoria character varying(100)
);


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usuarios (
    cod_usuario integer NOT NULL,
    usuario character varying(30) NOT NULL,
    senha character varying(80) NOT NULL,
    gerencia character varying(1) NOT NULL
);


--
-- Name: vendas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.vendas (
    cod_venda integer NOT NULL,
    dt_venda timestamp without time zone,
    vl_total_venda double precision,
    cod_funcionario integer,
    cod_cliente integer,
    dt_alteracao timestamp without time zone
);


--
-- Name: vwmovimentacao; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.vwmovimentacao AS
 SELECT v.cod_venda,
    c.nome AS nomecliente,
    c.cpf AS cpfcliente,
    c.rg AS rgcliente,
    v.vl_total_venda,
    v.dt_venda,
    v.dt_alteracao,
    c.codigo AS cod_cliente,
    f.codigo AS cod_funcionario,
    f.nome AS nomefuncionario
   FROM ((public.vendas v
     JOIN public.clientes c ON ((v.cod_cliente = c.codigo)))
     JOIN public.funcionario f ON ((v.cod_funcionario = f.codigo)));


--
-- Name: usuarios pk_cod_usuario; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT pk_cod_usuario PRIMARY KEY (cod_usuario);


--
-- Name: clientes pk_codigo; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT pk_codigo PRIMARY KEY (codigo);


--
-- Name: configuracoes pk_configuracao; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.configuracoes
    ADD CONSTRAINT pk_configuracao PRIMARY KEY (cod_configuracao);


--
-- Name: funcionario pk_funcionario; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT pk_funcionario PRIMARY KEY (codigo);


--
-- Name: produtos pk_produtos; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT pk_produtos PRIMARY KEY (cod_produtos);


--
-- Name: relatorios pk_relatorio; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relatorios
    ADD CONSTRAINT pk_relatorio PRIMARY KEY (cod_relatorio);


--
-- Name: vendas pk_vendas; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT pk_vendas PRIMARY KEY (cod_venda);


--
-- Name: usuarios usuarios_usuario_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_usuario_key UNIQUE (usuario);


--
-- Name: idx_dt_venda; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_dt_venda ON public.vendas USING btree (dt_venda);


--
-- Name: nome_funcionario_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX nome_funcionario_idx ON public.funcionario USING btree (nome);


--
-- Name: produtos_idx_descricao; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX produtos_idx_descricao ON public.produtos USING btree (descricao);


--
-- Name: vendas fk_clientes; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT fk_clientes FOREIGN KEY (cod_cliente) REFERENCES public.clientes(codigo);


--
-- Name: vendas fk_funcionario; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT fk_funcionario FOREIGN KEY (cod_funcionario) REFERENCES public.funcionario(codigo);


--
-- Name: itens_vendas fk_produtos; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.itens_vendas
    ADD CONSTRAINT fk_produtos FOREIGN KEY (cod_produtos) REFERENCES public.produtos(cod_produtos);


--
-- Name: itens_vendas fk_venda; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.itens_vendas
    ADD CONSTRAINT fk_venda FOREIGN KEY (cod_venda) REFERENCES public.vendas(cod_venda);


--
-- PostgreSQL database dump complete
--

