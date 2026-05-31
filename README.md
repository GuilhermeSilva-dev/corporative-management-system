# Corporative Management API (ERP Backend)

Esta é uma API REST funcional desenvolvida para o gerenciamento de ecossistemas corporativos, integrando o controle de **Clientes**, **Fornecedores** e **Funcionários**. O projeto foi estruturado seguindo os padrões mais exigidos pelo mercado de desenvolvimento backend com Java e Spring Boot.

## 🚀 Tecnologias Utilizadas

* **Java 17 / 25**
* **Spring Boot 4.x**
    * *Spring Data JPA* (Persistência de dados e ORM)
    * *Spring Web* (Criação de endpoints RESTful)
    * *Spring Validation* (Validação de payload com `@Valid`)
* **MySQL Server** (Banco de dados relacional)
* **BCrypt (Spring Security)** (Criptografia segura para senhas e dados sensíveis)
* **Lombok** (Produtividade e código limpo)
* **OpenAPI / Swagger** (Documentação interativa da API)

---

## 🏗️ Arquitetura e Boas Práticas

O projeto foi desenhado utilizando a arquitetura em camadas padrão de mercado, garantindo baixo acoplamento e alta manutenibilidade:

1.  **Controller:** Exposição dos endpoints REST e manipulação dos status HTTP corretos (`200 OK`, `201 Created`, `204 No Content`).
2.  **Service:** Camada responsável pelo isolamento de todas as regras de negócio do sistema.
3.  **Repository:** Interface de comunicação direta com o banco de dados via Spring Data JPA.
4.  **DTO (Data Transfer Object):** Divisão clara entre dados de entrada (`RequestDTO`) e dados de saída (`ResponseDTO`), garantindo que informações sensíveis (como senhas criptografadas) nunca sejam expostas.
5.  **Tratamento Global de Exceções:** Uso de `@RestControllerAdvice` para capturar erros de validação e de banco, retornando mensagens amigáveis e padronizadas para o cliente da API.

---

## 🗺️ Endpoints da API

### Clientes (`/clientes`)
* `GET /clientes` - Lista todos os clientes cadastrados.
* `POST /clientes` - Registra um novo cliente (Valida os dados de entrada).
* `PUT /clientes/{id}` - Atualiza as informações de um cliente existente.
* `DELETE /clientes/{id}` - Remove um cliente do sistema.

### Fornecedores (`/fornecedores`)
* `GET /fornecedores` - Lista todos os fornecedores.
* `GET /fornecedores/{id}` - Busca os detalhes de um fornecedor específico por ID.
* `POST /fornecedores` - Cadastra um novo parceiro/fornecedor.
* `PUT /fornecedores/{id}` - Altera dados do fornecedor.
* `DELETE /fornecedores/{id}` - Remove o fornecedor.

### Funcionários (`/funcionarios`)
* `GET /funcionarios` - Lista todo o quadro de funcionários.
* `GET /funcionarios/{id}` - Busca funcionário por ID.
* `POST /funcionarios` - Adiciona um novo colaborador (Aplica hash de segurança na senha via BCrypt).
* `PUT /funcionarios/{id}` - Atualiza cargo ou dados cadastrais.
* `DELETE /funcionarios/{id}` - Desliga/Remove o funcionário do banco de dados.

---

## 🛠️ Como Executar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone [https://github.com/GuilhermeSilva-dev/corporative-management-system.git](https://github.com/GuilhermeSilva-dev/corporative-management-system.git)
