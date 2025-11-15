# FuturePath

## Descrição do problema e solução proposta
Problema: necessidade de uma plataforma simples para cadastrar trilhas, módulos e gerenciar inscrições com autenticação JWT. Solução: A FuturePath, uma plataforma que conecta pessoas a trilhas de aprendizagem destinadas ao desenvolvimento de competências essenciais para o mercado de trabalho de 2030 em diante. O foco é estimular a educação contínua, o upskilling e o reskilling, alinhada às demandas de transformação digital, IA, automação e novas economias.

## Versões e principais dependências
- Java: 21
- Spring Boot: 3.5.7
- Porta: localhost:8081
### Principais dependências:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-validation
- auth0 java-jwt (JWT)
- springdoc-openapi-starter-webmvc-ui (Swagger)
- flyway-core (migrations)
- spring-boot-starter-test, spring-security-test (testes)

## Passo a passo para configurar o ambiente

1. Instalar dependências
- `mvn clean install`
2. Configurar o banco de dados (PostgreSQL)
- `CREATE DATABASE futurepath;`
3. Configurar credenciais no `application.properties`  
```
spring.application.name=FuturePath
server.port=8081
spring.datasource.url=jdbc:postgresql://localhost:5432/FuturePath
spring.datasource.username=${USERNAME_BANCO}
spring.datasource.password=${SENHA_BANCO}
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

spring.flyway.enabled=none
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true

api.security.token.secret = ${SECRET_JWT}
```
4. Variáveis de Ambiente

Para manter senhas e chaves sensíveis fora do código-fonte, o projeto utiliza variáveis de ambiente. Antes de executar a aplicação, configure:
- Como definir (Windows PowerShell)
```
setx USERNAME_BANCO "seu_usuario_postgre"
setx SENHA_BANCO "sua_senha_postgre"
setx SECRET_JWT "sua_chave_secreta_segura"

```
5. Executar aplicação
- `mvn spring-boot:run`
6. Após iniciar, a API estará disponível em:
`http://localhost:8081`

## Endpoints
### Autenticação
- POST /login
- POST /user/novo — criar usuário (público)

### Trilha:
- GET /trilhas
- GET /trilhas/{id}
- POST /trilhas/novo
- PUT /trilhas/edita/{id}
- DELETE /trilhas/excluir/{id}
### Módulo:
- GET /modulos
- GET /modulos/{id}
- POST /modulos/novo
- PUT /modulos/edita/{id}
- DELETE /modulos/excluir/{id}
### Inscrições:
- GET /inscricoes
- GET /inscricoes/{id}
- POST /inscricoes/nova
- DELETE /inscricoes/excluir/{id}

Observações de segurança: os endpoints POST /login e POST /user/novo são permitidos sem autenticação; demais rotas exigem header Authorization: Bearer <token>.

## Payload JSON de exemplo para requisições POST e PUT.
- POST para /login e /user/novo
```
{
  "login": "usuario1",
  "senha": "Senha123!"
}

{
  "login": "usuario1",
  "senha": "Senha123!",
  "nome": "Nome Exemplo"
}
```
- POST e PUT para trilhas
```
{
  "titulo": "Trilha Java Backend",
  "descricao": "Trilha focada em desenvolvimento backend com Java"
}

{
  "titulo": "Trilha Java Backend (atualizada)",
  "descricao": "Descrição atualizada da trilha"
}
```
- POST e PUT para modulos
```
{
  "titulo": "Introdução ao Spring",
  "descricao": "Visão geral do Spring Boot",
  "capitulo": 1,
  "tipo": "video",
  "trilha": {
    "id": 1
  }
}

{
  "titulo": "Introdução ao Spring (atualizado)",
  "descricao": "Conteúdo atualizado",
  "capitulo": 1,
  "tipo": "video",
  "trilha": {
    "id": 1
  }
}

```

- POST para inscricoes
```
{
  "usuario": {
    "id": 1
  },
  "trilha": {
    "id": 1
  },
  "status": "INSCRITO",
  "progresso": 0
}
```

## Como testar com Postman
1. Registrar usuário (gera conta para login)
- POST `http://localhost:8081/user/novo`
```
{
  "nome": "Pedro",
  "email": "pedro@example.com",
  "senha": "123456"
}
```
2. Fazer login (obter token JWT)
- POST `http://localhost:8081/login`
```
{
  "email": "pedro@example.com",
  "senha": "123456"
}
```
o retorno será
`{ "token": "SEU_TOKEN" }`

3. Usar o token nos endpoints protegidos
Em qualquer requisição protegida, adicionar Header: `Authorization: Bearer SEU_TOKEN`

4. Exemplos de testes rápidos
- Listar trilhas GET `http://localhost:8081/trilhas`

- Criar Trilha POST `http://localhost:8081/trilhas/novo`

Body:
```
{
  "nome": "Java Web",
  "descricao": "Trilha backend"
}

```
