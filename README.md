## 📚 Biblioteca Virtual

Este projeto é uma aplicação Java que implementa um sistema de catálogo de biblioteca, utilizando JPA/Hibernate, padrão DAO, herança entre entidades e interação via console.
Permite cadastrar, listar, buscar e remover itens como Livros, Revistas e Álbuns.

## 🧰 Tecnologias Utilizadas

Java 17+

Jakarta Persistence API (JPA)

Hibernate

PostgreSQL / H2 (dependendo da configuração do persistence.xml)

Padrão DAO + Service

Herança entre entidades (JOINED)

Docker Compose

## 📌 Funcionalidades do Sistema
### Antes de tudo, preencha as credenciais do banco no persistence.xml e no docker-compose.yml

O menu principal oferece:

1 - Cadastrar item

2 - Remover item

3 - Listar todos os itens

4 - Procurar por nome

5 - Listar itens por autor

6 - Listar por categoria

7 - Sair

✔️ Cadastro

O usuário escolhe:

Livro

Álbum

Revista

Em seguida informa:

Título (com validação de duplicidade)

Categoria

Autor

Ano

✔️ Remoção

Remove item pelo título exato (case-insensitive).

✔️ Listagem Geral

Mostra todos os itens com separação elegante e toString() por tipo.

✔️ Busca por Nome

Pesquisa usando findByName().

✔️ Listar por Autor

Todos os itens com autor correspondente (ignora maiúsculas/minúsculas).

✔️ Listar por Categoria

Mesma lógica da busca por autor.

📊 Exemplo de Saída

--- MENU BIBLIOTECA ---

1 - Cadastrar item

2 - Remover item

3 - Listar todos os itens

4 - Procurar por nome

5 - Listar itens por autor

6 - Listar por categoria

7 - Sair

## 💾 Persistência

O DAO usa:

EntityManager

persist()

remove()

TypedQuery

Exemplo de query usada:

String jpql = "SELECT i FROM Item i ORDER BY i.id ASC";


Busca por título:

SELECT i FROM Item i WHERE LOWER(i.titulo) = LOWER(:titulo)

## 🛡️ Validações Implementadas

Não permite campos vazios

Evita cadastro de itens com títulos repetidos

Protege entradas inválidas no menu

Tratamento de exceções em remoção

## ▶️ Como Executar

Configure seu persistence.xml com o banco desejado.

Execute AppItem.

Navegue pelo menu.

