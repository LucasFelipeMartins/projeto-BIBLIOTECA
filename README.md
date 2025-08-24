# 📚 Sistema de Biblioteca em Java  

Este repositório contém um projeto desenvolvido **100% em Java**, simulando um sistema de **biblioteca digital**.  
O sistema possui funcionalidades de **cadastro, recomendação e avaliação de livros**, com persistência de dados em arquivos **JSON**.  

---

## 🎯 Objetivo do Projeto
- Criar um sistema de biblioteca completo com foco em **boas práticas de programação**.  
- Praticar conceitos de **POO (Programação Orientada a Objetos)**.  
- Implementar **padrão MVC** e integração entre classes.  
- Trabalhar com **persistência de dados** utilizando JSON.  
- Desenvolver uma **interface gráfica** com **Swing (JFrame e JDialog)**.  
- Aplicar **princípios SOLID** para melhor organização e manutenção do código.  

---

## 🛠️ Funcionalidades
- 👤 **Cadastro de Usuários**  
- ✍️ **Cadastro de Autores**  
- 📖 **Cadastro de Livros**  
- ⭐ **Sistema de Recomendação de Livros** baseado no **gênero do usuário** e na **avaliação dos livros**  
- ✅ **Marcar livros como lidos** (usuário deve avaliar após concluir a leitura)  
- 💾 **Salvar e carregar dados em arquivos JSON** usando **FilePersistence** e **Serializador**  
- 📊 **Visualização de dados** utilizando **TableModel** no Swing  
- ⚠️ **Tratamento de erros com Exceptions personalizadas**, garantindo robustez  

---

## 🏗️ Conceitos Utilizados
- **MVC (Model-View-Controller)**  
- **POO Avançado**:  
  - Herança  
  - Polimorfismo  
  - Classe Abstrata  
- **Interface** para definição de contratos  
- **Listas (Collections)** para armazenamento dinâmico  
- **Integração entre classes** (associação e colaboração entre objetos)  
- **Swing (JFrame, JDialog)** para interface gráfica  
- **TableModel** para manipulação de tabelas  
- **Princípios SOLID** para garantir código coeso, desacoplado e extensível  
- **Exceptions** para tratamento de erros e mensagens mais claras ao usuário  

---

## 📂 Estrutura do Projeto
- `model/` → Classes de domínio (Usuário, Autor, Livro, etc.)  
- `controller/` → Regras de negócio (cadastros, recomendações, avaliações)  
- `view/` → Interface gráfica feita com **Swing**  
- `persistence/` → Serialização e FilePersistence (JSON)  
- `exceptions/` → Classes de tratamento de erros personalizados  

---

## 🚀 Como executar
1. Clone este repositório:
   git clone https://github.com/LucasFelipeMartins/projeto-BIBLIOTECA.git

📌 Observações

- O sistema é local e não utiliza banco de dados relacional. Toda persistência é feita em arquivos JSON.

- O foco principal foi praticar POO, MVC, SOLID e integração entre classes em Java.

- O tratamento de exceptions garante que erros sejam tratados de forma clara e controlada.

👨‍💻 Autor

Projeto desenvolvido por Lucas Felipe
