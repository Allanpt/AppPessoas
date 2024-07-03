
# App de Pessoas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-003545?style=for-the-badge&logo=h2&logoColor=white)
![OpenAPI](https://img.shields.io/badge/OpenAPI-6BA539?style=for-the-badge&logo=openapi-initiative&logoColor=white)

## Descrição

O **App de Pessoas** é uma aplicação desenvolvida em Java utilizando Spring Boot, JPA, e seguindo o padrão arquitetural MVC (Model-View-Controller). A aplicação permite adicionar, atualizar, excluir e buscar Pessoas e seus respectivos Contatos. 

## Estrutura do Projeto

- **Model**: Representa as entidades do banco de dados.
- **Service**: Contém a lógica de negócio da aplicação.
- **Controller**: Expõe as APIs REST para interação com as entidades.

### Links para os pacotes principais:

- [Model](src/main/java/br/com/allanpt/AppPessoas/model)
- [Service](src/main/java/br/com/allanpt/AppPessoas/service)
- [Controller](src/main/java/br/com/allanpt/AppPessoas/resource)

## Requisitos

- Java 17 ou superior
- Maven 3.6.3 ou superior

## Configuração do Banco de Dados

A aplicação utiliza o banco de dados em memória H2, que está configurado para rodar na porta 8080 localmente.

## Como Executar a Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/AppPessoas.git
   cd AppPessoas
   ```

2. Compile e execute a aplicação utilizando Maven:
   ```bash
   mvn spring-boot:run
   ```

3. Acesse o banco de dados H2:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User Name: `sa`
   - Password: `password`

## Documentação da API

A documentação da API está disponível no formato OpenAPI (Swagger). Para acessar a documentação, utilize o seguinte link:
- [Documentação OpenAPI Swagger](http://localhost:8080/swagger-ui.html)

## Exemplos de Requisições

### Adicionar uma Pessoa

**Requisição:**
```bash
POST /api/pessoas
```

**Body:**
```json
{
  "nome": "João Silva",
  "endereco": "Rua das Flores, 123",
  "cep": "12345-678",
  "cidade": "São Paulo",
  "uf": "SP"
}
```

### Buscar uma Pessoa por ID

**Requisição:**
```bash
GET /api/pessoas/{id}
```

### Atualizar uma Pessoa

**Requisição:**
```bash
PUT /api/pessoas/{id}
```

**Body:**
```json
{
  "nome": "João Silva",
  "endereco": "Rua das Flores, 123",
  "cep": "12345-678",
  "cidade": "São Paulo",
  "uf": "SP"
}
```

### Excluir uma Pessoa

**Requisição:**
```bash
DELETE /api/pessoas/{id}
```

### Buscar Contatos por Pessoa

**Requisição:**
```bash
GET /api/contatos/pessoa/{id}
```

---
