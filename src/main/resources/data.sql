INSERT INTO UNIDADE(nome) VALUES ('Ala Califórnia');
INSERT INTO UNIDADE(nome) VALUES ('Ala Fátima');
INSERT INTO UNIDADE(nome) VALUES ('Ala Lomanto');
INSERT INTO UNIDADE(nome) VALUES ('Ala São Caetano');
INSERT INTO UNIDADE(nome) VALUES ('Ala Itabuna');
INSERT INTO UNIDADE(nome) VALUES ('Ala Nelson Costa');

INSERT INTO MEMBRO(nome, sexo, unidade_id) VALUES ('Fábio Brandão Bacelar', 'M', 1);
INSERT INTO MEMBRO(nome, sexo, unidade_id) VALUES ('Rosana Barros de Melo Bacelar', 'F', 1);
INSERT INTO MEMBRO(nome, sexo, unidade_id) VALUES ('Ellen Barros Bacelar', 'F', 1);
INSERT INTO MEMBRO(nome, sexo, unidade_id) VALUES ('Bruno Barros Bacelar', 'M', 1);
INSERT INTO MEMBRO(nome, sexo, unidade_id) VALUES ('Fábio Brandão Bacelar Jr', 'M', 1);

INSERT INTO CHAMADO(nome) VALUES ('Membro do Sumo Conselho da estaca');
INSERT INTO CHAMADO(nome) VALUES ('Presidente das moças');
INSERT INTO CHAMADO(nome) VALUES ('Membro do coro');
INSERT INTO CHAMADO(nome) VALUES ('Presidente do Quórum de Mestres');
INSERT INTO CHAMADO(nome) VALUES ('Presidente do Quórum de Diáconos');
INSERT INTO CHAMADO(nome) VALUES ('Casal Mais Missionários');

INSERT INTO MEMBRO_CHAMADOS(membros_id, chamados_id) VALUES (1, 1);
INSERT INTO MEMBRO_CHAMADOS(membros_id, chamados_id) VALUES (2, 2);
INSERT INTO MEMBRO_CHAMADOS(membros_id, chamados_id) VALUES (3, 3);
INSERT INTO MEMBRO_CHAMADOS(membros_id, chamados_id) VALUES (4, 4);
INSERT INTO MEMBRO_CHAMADOS(membros_id, chamados_id) VALUES (5, 5);
INSERT INTO MEMBRO_CHAMADOS(membros_id, chamados_id) VALUES (1, 6);
