# Projeto Beneficiário

Este projeto é uma aplicação Spring Boot para gerenciamento de beneficiários e seus documentos. A aplicação permite o cadastro e a atualização de beneficiários e documentos associados.

## Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- [Java 17](https://adoptium.net/)
- [Maven](https://maven.apache.org/download.cgi) 

## Configuração

### Banco de Dados

A aplicação está configurada para usar o H2, um banco de dados em memória para desenvolvimento. Se você deseja usar um banco de dados diferente, você precisará ajustar as configurações no arquivo `application.properties`.

### Configuração do Banco de Dados H2

```properties
spring.application.name=beneficiario
spring.datasource.url=jdbc:h2:mem:banco
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.username=admin
spring.datasource.password=admin
spring.h2.console.path=/h2
spring.h2.console.enabled=true
```

O console do H2 está disponível em [http://localhost:8080/h2](http://localhost:8080/h2) com o driver JDBC URL `jdbc:h2:mem:testdb`, usuário `sa`, e senha `password`.

## Rodando o Projeto

1. Navegue até o diretório do projeto:

    ```bash
    cd /caminho/para/seu/projeto/beneficiario
    ```

2. Compile e rode a aplicação:

    ```bash
    mvn spring-boot:run
    ```

## Endpoints da API

Aqui estão alguns dos principais endpoints disponíveis:

- **Cadastro de Beneficiário**

  `POST /beneficiario`

  Corpo da requisição:
  ```json
  {
    "nome": "Nome do Beneficiário",
    "telefone": "Telefone",
    "dataNascimento": "Data de Nascimento",
    "documentos": [
      {
        "tipoDocumento": "Tipo de Documento",
        "descricao": "Descrição do Documento"
      }
    ]
  }
  ```

- **Atualização de Beneficiário**

  `PUT /beneficiario/{id}`

  Corpo da requisição:
  ```json
  {
    "nome": "Nome Atualizado",
    "telefone": "Telefone Atualizado",
    "dataNascimento": "Data de Nascimento Atualizada",
    "documentos": [
      {
        "tipoDocumento": "Tipo de Documento Atualizado",
        "descricao": "Descrição do Documento Atualizado"
      }
    ]
  }
  ```

- **Listar Beneficiários**

  `GET /beneficiario`

- **Consultar Beneficiário por ID**

  `GET /beneficiario/{id}`

- **Excluir Beneficiário por ID**

  `DELETE /beneficiario/{id}`

## Testes

Para rodar os testes, use o comando Maven ou Gradle:

### Maven

```bash
mvn test
```

## Swagger

A documentação da API está disponível através do Swagger. Acesse:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).