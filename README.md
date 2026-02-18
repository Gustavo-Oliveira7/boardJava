# 📋 Board Java - Gerenciamento de Tarefas

Projeto desenvolvido durante o curso **Java Básico - Digital Innovation One (DIO)**.

A aplicação simula um **board de gerenciamento de tarefas (estilo Kanban)**, permitindo criar boards, colunas e cards, com persistência em banco de dados e aplicação de regras de negócio.

---

## 🚀 Funcionalidades

### 📌 Board

- Criar novos boards
- Selecionar board existente
- Excluir boards

Cada board possui colunas obrigatórias:

- INITIAL (Inicial)
- PENDING (Pendente)
- FINAL (Concluído)
- CANCEL (Cancelado)

---

### 🗂️ Cards

- Criar cards
- Mover card para próxima coluna
- Cancelar card
- Bloquear card com motivo
- Desbloquear card com motivo
- Visualizar detalhes do card

---

### ⚙️ Regras de Negócio

- Cards só podem avançar para a próxima coluna
- Cards bloqueados não podem ser movidos
- Cards finalizados não podem ser alterados
- Cancelamento permitido conforme regras do board
- Histórico de bloqueios armazenado

---

## 🧱 Arquitetura

O projeto segue uma estrutura organizada em camadas:

```
br.com.dio
│
├── persistence
│   ├── config
│   ├── dao
│   ├── entity
│   └── migration
│
├── service
│
├── ui
│
└── dto
```

Principais conceitos utilizados:

- Programação Orientada a Objetos
- Separação de responsabilidades
- DAO Pattern
- Service Layer
- Liquibase para migrations

---

## 🗄️ Banco de Dados

O projeto utiliza:

- MySQL
- Liquibase (migrations automáticas)

Tabelas principais:

- BOARDS
- BOARDS_COLUMNS
- CARDS
- BLOCKS

---

## ▶️ Como executar o projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/Gustavo-Oliveira7/boardJava.git
```

---

### 2️⃣ Configurar o banco

Crie um banco MySQL e ajuste as configurações de conexão em:

```
ConnectionConfig.java
```

---

### 3️⃣ Executar aplicação

Rodar:

```
Main.java
```

As migrations serão executadas automaticamente ao iniciar.

---

## 🧑‍💻 Tecnologias utilizadas

- Java
- MySQL
- JDBC
- Liquibase
- Gradle

---
