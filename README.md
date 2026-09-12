# Spring Boot Learning Project 🚀

Projeto desenvolvido com o objetivo de **aprender e praticar Spring Boot**, construindo uma API REST desde os conceitos fundamentais até a integração com banco de dados.

Este projeto faz parte da minha jornada de aprendizado em **Java e desenvolvimento Back-End**, e será evoluído conforme novos conceitos de Spring Boot forem estudados.

---

## 🎯 Objetivo

O principal objetivo deste projeto é colocar em prática os fundamentos do desenvolvimento de APIs REST utilizando Spring Boot.

Atualmente, a aplicação possui um CRUD de usuários utilizando uma lista em memória como armazenamento.

> **Este projeto ainda não utiliza banco de dados.**
> A persistência em memória será substituída posteriormente por **Spring Data JPA** e um banco de dados.

---

## 🛠️ Tecnologias

* Java
* Spring Boot
* Spring Web
* Maven
* Git / GitHub

---

## 📚 Conceitos praticados

Durante o desenvolvimento deste projeto, estou praticando:

* Estrutura de uma aplicação Spring Boot
* Injeção de dependências
* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`
* `@RequestBody`
* `@PathVariable`
* `ResponseEntity`
* Códigos de status HTTP
* Separação de responsabilidades
* Arquitetura em camadas
* CRUD
* Validação de dados
* `Optional`
* Streams e operações sobre coleções

---

## 🏗️ Estrutura do projeto

A aplicação utiliza uma arquitetura dividida em camadas:

```text
src/main/java/com/learning/project1
│
├── controller
│   └── UsuarioController
│
├── service
│   └── UsuarioService
│
├── repository
│   └── UsuarioRepository
│
└── entity
    └── Usuario
```

### Controller

Responsável por receber as requisições HTTP e construir as respostas da API.

```text
HTTP Request
     ↓
Controller
     ↓
Service
```

### Service

Responsável pelas regras e validações da aplicação.

```text
Controller
     ↓
Service
     ↓
Repository
```

### Repository

Atualmente, o Repository utiliza uma `List<Usuario>` para simular o armazenamento dos dados.

```java
private List<Usuario> usuarios = new ArrayList<>();
```

Em uma etapa futura, essa implementação será substituída por um Repository utilizando **Spring Data JPA**.

### Entity

A classe `Usuario` representa o objeto utilizado pela aplicação.

Atualmente possui:

* `id`
* `nome`
* `idade`

---

## 🌐 Endpoints

A API possui atualmente os seguintes endpoints:

| Método   | Endpoint         | Descrição                | Status esperado            |
| -------- | ---------------- | ------------------------ | -------------------------- |
| `POST`   | `/usuarios`      | Cria um usuário          | `201 Created`              |
| `GET`    | `/usuarios`      | Lista todos os usuários  | `200 OK`                   |
| `GET`    | `/usuarios/{id}` | Busca um usuário pelo ID | `200 OK` / `404 Not Found` |
| `PUT`    | `/usuarios`      | Atualiza um usuário      | `204 No Content`           |
| `DELETE` | `/usuarios/{id}` | Remove um usuário        | `204 No Content`           |

---

## 📌 Exemplo de requisição

### Criar usuário

```http
POST /usuarios
Content-Type: application/json
```

```json
{
  "id": 1,
  "nome": "Igor",
  "idade": 18
}
```

Resposta:

```http
201 Created
```

---

### Buscar usuário por ID

```http
GET /usuarios/1
```

Se o usuário existir:

```http
200 OK
```

```json
{
  "id": 1,
  "nome": "Igor",
  "idade": 18
}
```

Caso não exista:

```http
404 Not Found
```

---

## 🧠 Arquitetura atual

O fluxo básico da aplicação funciona da seguinte maneira:

```text
Cliente
   │
   │ HTTP Request
   ▼
Controller
   │
   │ chama
   ▼
Service
   │
   │ aplica regras
   ▼
Repository
   │
   │ manipula dados
   ▼
Lista em memória
```

E o resultado retorna pelo caminho inverso:

```text
Lista em memória
       ↓
Repository
       ↓
Service
       ↓
Controller
       ↓
ResponseEntity
       ↓
HTTP Response
```

---

## 🚧 Próximos passos

Este projeto será utilizado como base para continuar meus estudos de Spring Boot.

### Concluído / Em estudo

* [x] Estrutura básica do Spring Boot
* [x] Controllers
* [x] Services
* [x] Repository
* [x] CRUD em memória
* [x] Injeção de dependências
* [x] ResponseEntity
* [x] Status Codes HTTP
* [x] Optional

### Próximos objetivos

* [ ] Spring Data JPA
* [ ] Hibernate
* [ ] Entidades JPA
* [ ] Relacionamentos entre entidades
* [ ] Banco de dados
* [ ] PostgreSQL
* [ ] Tratamento global de exceções
* [ ] Bean Validation
* [ ] DTOs
* [ ] Paginação
* [ ] Testes
* [ ] Documentação com Swagger/OpenAPI
* [ ] Autenticação e autorização

---

## 📖 Sobre o projeto

Este não é um projeto desenvolvido com o objetivo de ser uma aplicação pronta para produção.

Ele é principalmente um **projeto de estudos**, no qual estou construindo uma API passo a passo para entender como as diferentes partes do ecossistema Spring Boot se conectam.

A ideia é continuar evoluindo o mesmo projeto conforme novos conceitos forem aprendidos.

---

## 👨‍💻 Autor

**Igor Alcântara**

Estudante de Engenharia de Software e desenvolvedor interessado em **Java, Spring Boot e desenvolvimento Back-End**.

Este projeto representa parte da minha jornada de aprendizado em desenvolvimento de software.
