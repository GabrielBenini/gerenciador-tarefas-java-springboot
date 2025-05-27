
# 📚 Sistema de Gerenciador de Tarefas – API REST

Este é um projeto Java com Spring Boot que simula um sistema básico de gerenciamento de tarefas. Ele permite o cadastro, listagem, atualização e remoção de tarefas, com algumas regras de negócio aplicadas.

## 🚀 Tecnologias Utilizadas


- Java 17

- Spring Boot

- Spring Data JPA

- PostgreSQL

- Maven

- Lombok

- Postman (para testes)

- Docker (para banco local, opcional)

## 🏛️ Entidades

### 📘 Tarefas

- id: Long

- titulo: String

- descricao: String

- status: StatusEnum

- dataCriacao: LocalDateTime


## 📂 Estrutura do Projeto

- model: Entidades JPA (Tarefas)

- repository: Interfaces do Spring Data JPA

- service: Regras de negócio implementadas

- controller: Endpoints da API REST

- dto: Camada de transferência de dados (Request e Response)

## 🔄 Endpoints Principais

### Tarefas
- POST /tarefas: Cadastrar autor

- GET /tarefas: Listar todos

- GET /tarefas/{id}: Buscar por ID

- PUT /tarefas/{id}: Atualizar

- DELETE /tarefas/{id}: Remover

## 🧪 Testes

Os testes foram realizados via Postman, utilizando dados simulados.

## 🧾 Observações
- A API utiliza o padrão DTO para comunicação.

- Exceções são tratadas com mensagens claras de erro.

- Projeto com foco em boas práticas de arquitetura em camadas.

