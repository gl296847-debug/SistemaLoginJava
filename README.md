# SistemaLoginJava 🔐

Sistema de login desenvolvido em Java utilizando Java Swing e MySQL.

## 📌 Sobre o projeto

Este projeto foi desenvolvido para praticar conceitos de desenvolvimento Java, conexão com banco de dados e criação de uma interface gráfica.

O sistema permite:

- Cadastro de usuários
- Login com e-mail e senha
- Validação dos campos
- Armazenamento de senha utilizando hash SHA-256
- Tela principal personalizada
- Logout
- Conexão com banco de dados MySQL

## 🛠️ Tecnologias utilizadas

- Java
- Java Swing
- MySQL
- JDBC
- Eclipse IDE
- Git
- GitHub

## 📂 Estrutura do projeto

O projeto está organizado nos seguintes pacotes:

- **connection** — conexão com o banco de dados
- **dao** — acesso e operações com o banco de dados
- **model** — modelo dos usuários
- **util** — funções auxiliares, como o hash da senha
- **view** — telas do sistema

## 🔐 Segurança

As senhas não são armazenadas diretamente no banco de dados.

Antes de serem salvas, elas passam por um processo de hash utilizando SHA-256.

A senha de conexão com o banco de dados é obtida através da variável de ambiente `MYSQL_SENHA`, evitando deixar credenciais diretamente no código.

## 🚀 Funcionalidades

### Cadastro

O usuário informa:

- Nome
- E-mail
- Senha
- Confirmação da senha

O sistema verifica se os campos foram preenchidos e se as senhas são iguais antes de realizar o cadastro.

### Login

O sistema verifica o e-mail e a senha no banco de dados.

A senha digitada passa pelo mesmo processo de hash utilizado no cadastro.

Caso os dados estejam corretos, o usuário é direcionado para a tela principal.

### Tela principal

Após o login, o sistema exibe uma mensagem personalizada:

> Bem-vindo, usuário!

Também existe um botão **Sair**, que retorna para a tela de login.

## 🗄️ Banco de dados

O projeto utiliza um banco de dados MySQL chamado `login_db`.

A tabela utilizada pelo sistema é `usuarios`.

Campos:

- id
- nome
- email
- senha

## 🎯 Objetivo

Projeto desenvolvido para praticar:

- Java
- Programação Orientada a Objetos
- Java Swing
- JDBC
- MySQL
- Conexão com banco de dados
- Hash de senhas
- Organização de projetos
- Git e GitHub

## 📚 Aprendizado

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Criação de interfaces gráficas
- Eventos de botões
- Navegação entre telas
- Cadastro e autenticação de usuários
- Comunicação entre Java e MySQL
- Uso do padrão DAO
- Separação entre model, view, DAO e conexão
- Proteção de credenciais
- Controle de versão com Git

---

**Desenvolvido por Gabriel Lopes.**