
CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    ocupacao_atual VARCHAR(100)
);

CREATE TABLE trilha (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    area VARCHAR(100),
    carga_horaria INTEGER CHECK (carga_horaria > 0)
);

CREATE TABLE modulo (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    capitulo INTEGER CHECK (capitulo > 0),
    tipo VARCHAR(50) CHECK (tipo IN ('video', 'leitura', 'quiz')),
    trilha_id BIGINT NOT NULL,
    CONSTRAINT fk_modulo_trilha FOREIGN KEY (trilha_id) REFERENCES trilha (id) ON DELETE CASCADE
);

CREATE TABLE inscricao (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    trilha_id BIGINT NOT NULL,
    data_inscricao DATE DEFAULT CURRENT_DATE,
    status VARCHAR(20) CHECK (status IN ('INSCRITO', 'EM_PROGRESSO', 'CONCLUIDO', 'CANCELADO')),
    progresso INTEGER DEFAULT 0 CHECK (progresso >= 0 AND progresso <= 100),
    CONSTRAINT fk_inscricao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE,
    CONSTRAINT fk_inscricao_trilha FOREIGN KEY (trilha_id) REFERENCES trilha (id) ON DELETE CASCADE
);