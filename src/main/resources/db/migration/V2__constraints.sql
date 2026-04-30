ALTER TABLE atividade
    ADD CONSTRAINT ck_atividade_tipo
        CHECK (tipo IN ('INSUMO', 'COLHEITA', 'PLANTIO', 'OUTRO'));

ALTER TABLE local
    ADD CONSTRAINT ck_local_tipo
        CHECK (tipo IN ('CANTEIRO', 'TALHAO', 'ESTUFA', 'OUTRO'));


ALTER TABLE programa_comercializacao
    ADD CONSTRAINT ck_programa_tipo
        CHECK (tipo IN ('PAA', 'PNAE', 'FEIRA', 'OUTRO'));

ALTER TABLE produtor_propriedade
    ADD CONSTRAINT uc_produtor_propriedade
        UNIQUE (produtor_id, propriedade_id);