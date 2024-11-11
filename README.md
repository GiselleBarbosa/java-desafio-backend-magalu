### **Resolveremos o Desafio Backend da Magalu e aprenderemos:**

- Como criar um microserviço com Spring Boot
- Como realizar tasks agendadas com Spring Scheduler
- Como comunicar com o banco de dados MySQL via Docker
- Queries customizadas com Spring Data JPA
- Relacionamento ManyToOne com JoinColumn
- Como efetuar logs com o SLF4J

### Lista de tarefas:

Introdução:

- [x]  Qual é o desafio que vamos resolver?

---

#### Comunicação com o banco e dados:

- [x]  Iniciando o projeto Java (Web, Spring Data JPA, MySQL)
- [x]  Configurando o MySQL no Docker
- [x]  Configurando a comunicacao do Spring Boot com o MySQL

---

#### Funcionalidade de solicitação de agendamento de notificação:

- [x]  Mapear as entidades (Notification, Channel e Status)
- [x]  Criar config de inicialização das tabelas (Channel e Status)
- [x]  Criar API de solicitação de agendamento de notificação
- [x]  Criar serviço de persistência da solicitação
- [x]  Testar o fluxo (api → service → mysql)

---

#### Funcionalidade de consultar a situação de agendamento de notificação:

- [x]  Criar API de consulta de solicitação de agendamento de notificação
- [x]  Criar serviço de consulta
- [x]  Testar a API

---

#### Funcionalidade de cancelamento de agendamento de notificação:

- [x]  Criar API de cancelamento de agendamento de notificação
- [x]  Criar serviço de cancelamento
- [x]  Testar a API

---

#### Rotina de checagem e envio de notificação:

- [x]  Criar rotina de checagem via Spring Scheduler
- [x]  Testar se a rotina está funcionado
- [x]  Criar serviço de consulta de notificações disponíveis para envio
- [x]  Criar mock de envio de notificação com logging
- [x]  Criar serviço que atualiza o status da notificação
- [x]  Testar o fluxo completo (api → agendamento → rotina → envia notificacao → atualiza base)

