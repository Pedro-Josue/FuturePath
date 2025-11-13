
-- USUÁRIOS

INSERT INTO usuario (login, senha, ocupacao_atual)
VALUES
('carla.santos', '$2a$10$5RvgLR0oC6pIZ9HAFW5C8ubim3hzS/E9J1APxP02CGmIkhECij54W', 'Analista Administrativo'), -- senha123
('rodrigo.melo', '$2a$10$K7yDFlMck0BLlkfqE1LkOeMc.OBz/xElxvHrW4UG5bl2YqCOOKlPa', 'Engenheiro de Produção'), -- 123456
('julia.lima', '$2a$10$8wXYcMPaEoTkfZDTK1uKBumKtOmHbboFAyHkGG8bBhgGeE8vuRhUO', 'Estudante de TI'), --segura456
('marcos.tavares', '$2a$10$eB6PE1eWPCfrqKHtD5/4CeWTIMeS1KDoOAY1am5Z50TG0X.3aX2DC', 'Técnico em Manutenção Industrial'), --abc123
('fernanda.oliveira', '$2a$10$1Bfa2DFBz70l9RbOZnfr6u1JHuwBo4vEXOaR7Izfq1gYzFUpYk8jy', 'Professora de Matemática'); --senha789


-- TRILHAS E MÓDULOS

-- TRILHA 1: Inteligência Artificial e Ética no Trabalho
INSERT INTO trilha (titulo, descricao, area, carga_horaria)
VALUES ('Inteligência Artificial e Ética no Trabalho',
 'Entenda o impacto da IA nas profissões e como aplicá-la de forma responsável no ambiente corporativo.',
 'Tecnologia e Ética Digital', 35);

INSERT INTO modulo (titulo, descricao, capitulo, tipo, trilha_id)
VALUES
('O que é Inteligência Artificial?', 'Compreenda os fundamentos e aplicações da IA no mundo do trabalho.', 1, 'video', 1),
('IA e Impacto Social', 'Analise as implicações éticas da automação e da substituição de funções humanas.', 2, 'leitura', 1),
('Desafio Ético: Decisões Automatizadas', 'Atividade prática de reflexão sobre IA e ética.', 3, 'quiz', 1);

-- TRILHA 2: Automação e Indústria 4.0
INSERT INTO trilha (titulo, descricao, area, carga_horaria)
VALUES ('Automação e Indústria 4.0',
 'Aprenda sobre sistemas automatizados, IoT e robótica, e como eles estão moldando o futuro do trabalho.',
 'Engenharia e Automação', 40);

INSERT INTO modulo (titulo, descricao, capitulo, tipo, trilha_id)
VALUES
('Fundamentos da Indústria 4.0', 'Conceitos de automação, IoT e digitalização industrial.', 1, 'video', 2),
('Sensores e Robôs Colaborativos', 'Entenda como as máquinas interagem com humanos nas fábricas modernas.', 2, 'video', 2),
('Case Prático: Linha de Produção Inteligente', 'Estudo de caso sobre automação na indústria.', 3, 'leitura', 2);

-- TRILHA 3: Análise de Dados e Tomada de Decisão
INSERT INTO trilha (titulo, descricao, area, carga_horaria)
VALUES ('Análise de Dados e Tomada de Decisão',
 'Desenvolva competências em análise de dados para embasar decisões estratégicas nas empresas do futuro.',
 'Ciência de Dados', 45);

INSERT INTO modulo (titulo, descricao, capitulo, tipo, trilha_id)
VALUES
('Introdução à Análise de Dados', 'Aprenda a coletar, tratar e visualizar dados.', 1, 'video', 3),
('Ferramentas de BI e Python', 'Utilize ferramentas modernas para análise de dados.', 2, 'leitura', 3),
('Projeto Prático: Tomada de Decisão Baseada em Dados', 'Desafio final com dataset real.', 3, 'quiz', 3);

-- TRILHA 4: Soft Skills para a Era Digital
INSERT INTO trilha (titulo, descricao, area, carga_horaria)
VALUES ('Soft Skills para a Era Digital',
 'Aprimore suas habilidades humanas: comunicação, empatia, colaboração e pensamento crítico.',
 'Desenvolvimento Humano', 25);

INSERT INTO modulo (titulo, descricao, capitulo, tipo, trilha_id)
VALUES
('Comunicação Efetiva e Empatia', 'Como se comunicar bem em times híbridos.', 1, 'video', 4),
('Liderança Humanizada', 'O papel do líder em ambientes digitais.', 2, 'leitura', 4),
('Autogestão e Resiliência', 'Atividade prática para desenvolvimento pessoal.', 3, 'quiz', 4);

-- TRILHA 5: Trabalho Híbrido e Gestão Remota
INSERT INTO trilha (titulo, descricao, area, carga_horaria)
VALUES ('Trabalho Híbrido e Gestão Remota',
 'Descubra como liderar e colaborar em ambientes híbridos e remotos de maneira produtiva.',
 'Gestão e Inovação', 30);

INSERT INTO modulo (titulo, descricao, capitulo, tipo, trilha_id)
VALUES
('Modelos de Trabalho do Futuro', 'Conheça as principais tendências e boas práticas.', 1, 'video', 5),
('Ferramentas de Produtividade e Gestão', 'Como usar tecnologia para gerenciar times remotos.', 2, 'leitura', 5),
('Cultura Organizacional no Mundo Híbrido', 'Como manter o engajamento e pertencimento da equipe.', 3, 'video', 5);

-- INSCRIÇÕES (USUÁRIO -> TRILHA)

INSERT INTO inscricao (usuario_id, trilha_id, data_inscricao, status, progresso)
VALUES
(1, 1, CURRENT_DATE, 'EM_PROGRESSO', 50),
(2, 2, CURRENT_DATE, 'INSCRITO', 0),
(3, 3, CURRENT_DATE, 'CONCLUIDO', 100),
(4, 4, CURRENT_DATE, 'EM_PROGRESSO', 60),
(5, 5, CURRENT_DATE, 'INSCRITO', 0);
