# Back-end:

* Banco de Dados usado foi o H2;
* Java 17;
* Spring Boot;
* Maven;
* Testes unitários realizado

<h2 align="center"> Instruções para reproduzir o projeto</h2>

* Clonar repositório em sua máquina
* Importar em uma IDE de sua preferência (Sugiro Intellij)
* Rodar aplicação VivoApplication
* Link do banco de dados http://localhost:8080/h2-console/
* Endpoints
  1. http://localhost:8080/users GET (Find All Users)
  2. http://localhost:8080/users/{email} GET (Find User by Email)
  3. http://localhost:8080/users POST (Insert User)
  4. http://localhost:8080/users/{email} PUT (Update User)

* Ex: body para os endpoints POST e PUT:<br>
  {<br>
    "name": "name",<br>
    "email": "email@email.com",<br>
    "document": "doc"<br>
}
