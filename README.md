# Sistema de Vendas para Console

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

## Sobre o Projeto

Este é um projeto desenvolvido em Java que simula um sistema de vendas simples, operado inteiramente através do console (terminal). O objetivo é aplicar e demonstrar conceitos fundamentais de Programação Orientada a Objetos (POO), como classes, objetos, encapsulamento e relacionamentos entre entidades.

O sistema permite listar produtos, registrar usuários e simular a venda de itens, com controle de estoque e histórico de transações.

---

##  Funcionalidades

-   **Menu Interativo:** Interface de texto que guia o usuário através das operações.
-   **Listagem de Produtos:** Exibe todos os produtos disponíveis, com ID, nome, preço e quantidade em estoque.
-   **Registro de Vendas:** Permite que um usuário cadastrado realize uma compra.
-   **Carrinho de Compras:** Possibilidade de adicionar múltiplos produtos e quantidades em uma única venda.
-   **Controle de Estoque:** O sistema valida se há estoque disponível antes de adicionar um produto ao carrinho e atualiza a quantidade após a conclusão da venda.
-   **Histórico de Vendas:** Exibe um resumo de todas as vendas realizadas, incluindo cliente, itens, quantidades e valor total.

---

##  Tecnologias Utilizadas

-   **Linguagem:** Java 17+
-   **IDE:** IntelliJ IDEA
-   **Build System:** IntelliJ (Padrão)

---

##  Como Executar o Projeto

Para executar este projeto, siga os passos abaixo:

1.  **Pré-requisitos:**
    -   Ter o Java Development Kit (JDK) 17 ou superior instalado.
    -   Ter o Git instalado para clonar o repositório.

2.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/RafaelT196/sistema-vendas-java
    ```

3.  **Abrir no IntelliJ IDEA:**
    -   Abra o IntelliJ IDEA.
    -   Selecione "Open" e navegue até a pasta do projeto que você acabou de clonar.
    -   A IDE irá carregar e indexar o projeto automaticamente.

4.  **Executar a aplicação:**
    -   Navegue até o arquivo `src/com/lojaonline/LojaOnline.java`.
    -   Clique no ícone de "play" (▶️) verde que aparece ao lado do método `main`.
    -   A aplicação será iniciada e o menu interativo aparecerá no painel "Run" na parte inferior da IDE.

---

##  Estrutura do Projeto

O projeto está organizado com base nos princípios da Orientação a Objetos, com cada classe tendo uma responsabilidade única:

-   `LojaOnline.java`: Classe principal que contém o método `main`. É responsável por iniciar a aplicação, exibir o menu e gerenciar a interação com o usuário.
-   `Usuario.java`: Modela os dados do cliente.
-   `Produto.java`: Modela um produto da loja, sendo responsável também por controlar seu próprio estoque.
-   `Venda.java`: Representa uma transação de venda, contendo informações do cliente, data e o valor total.
-   `ItemVenda.java`: Classe de associação que representa um item específico dentro de uma venda, ligando um `Produto` a uma `Venda` e armazenando a quantidade e o preço do momento da compra.

---

##  Próximos Passos (Possíveis Melhorias)

-   [ ] Implementar persistência de dados em arquivos (JSON).
-   [ ] Conectar o sistema a um banco de dados.
-   [ ] Adicionar funcionalidades de cadastro de novos usuários e produtos via menu.
-   [ ] Refatorar a estrutura para utilizar uma arquitetura em camadas (Service e Repository/DAO).
-   [ ] Criar uma interface gráfica (GUI) com Java Swing ou JavaFX.

---

*Desenvolvido por Rafael Tamassia*
