# SistemaLoginJava

Sistema de login desenvolvido em Java utilizando Java Swing e MySQL.

## Sobre o projeto

Este projeto foi desenvolvido para praticar conceitos de desenvolvimento Java, conexao com banco de dados e criacao de uma interface grafica.

O sistema permite:

- Cadastro de usuarios
- Login com e-mail e senha
- Validacao dos campos
- Armazenamento de senha utilizando hash SHA-256
- Tela principal personalizada
- Logout
- Conexao com banco de dados MySQL

## Tecnologias utilizadas

- Java
- Java Swing
- MySQL
- JDBC
- Eclipse IDE
- Git
- GitHub

## Estrutura do projeto

O projeto esta organizado nos seguintes pacotes:

- **connection** - conexao com o banco de dados
- **dao** - acesso e operacoes com o banco de dados
- **model** - modelo dos usuarios
- **util** - funcoes auxiliares, como o hash da senha
- **view** - telas do sistema

## Seguranca

As senhas nao sao armazenadas diretamente no banco de dados.

Antes de serem salvas, elas passam por um processo de hash utilizando SHA-256.

A senha de conexao com o banco de dados e obtida atraves da variavel de ambiente `MYSQL_SENHA`, evitando deixar credenciais diretamente no codigo.

## Funcionalidades

### Cadastro

O usuario informa:

- Nome
- E-mail
- Senha
- Confirmacao da senha

O sistema verifica se os campos foram preenchidos e se as senhas sao iguais antes de realizar o cadastro.

### Login

O sistema verifica o e-mail e a senha no banco de dados.

A senha digitada passa pelo mesmo processo de hash utilizado no cadastro.

Caso os dados estejam corretos, o usuario e direcionado para a tela principal.

### Tela principal

Apos o login, o sistema exibe uma mensagem personalizada:

> Bem-vindo, usuario!

Tambem existe um botao **Sair**, que retorna para a tela de login.

## Banco de dados

O projeto utiliza um banco de dados MySQL chamado `login_db`.

A tabela utilizada pelo sistema e `usuarios`.

Campos:

- id
- nome
- email
- senha

## Objetivo

Projeto desenvolvido para praticar:

- Java
- Programacao Orientada a Objetos
- Java Swing
- JDBC
- MySQL
- Conexao com banco de dados
- Hash de senhas
- Organizacao de projetos
- Git e GitHub

## Aprendizado

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Criacao de interfaces graficas
- Eventos de botoes
- Navegacao entre telas
- Cadastro e autenticacao de usuarios
- Comunicacao entre Java e MySQL
- Uso do padrao DAO
- Separacao entre model, view, DAO e conexao
- Protecao de credenciais
- Controle de versao com Git

---

**Desenvolvido por Gabriel Lopes.**
