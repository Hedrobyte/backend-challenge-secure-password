# Secure Password Validator

Secure Password Validator é um serviço que valida se uma senha atende a critérios específicos de segurança. Este projeto foi desenvolvido como parte de um [desafio técnico](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md).

## Índice

- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Exemplo de Uso](#exemplo-de-uso)
- [Estrutura do Projeto](#estrutura-do-projeto)


## Funcionalidades

O serviço oferece um endpoint que recebe uma senha e verifica se ela atende aos seguintes critérios de segurança:
- Pelo menos 08 caracteres.
- Pelo menos uma letra maiúscula.
- Pelo menos uma letra minúscula.
- Pelo menos um dígito numérico.
- Pelo menos um caractere especial (e.g, !@#$%).

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.1**
- **JUnit 5** para testes dos requisitos

## Exemplo de Uso

Envie uma requisição POST para `http://localhost:8080/validate-password` com o seguinte JSON no corpo da requisição:
~~~JSON
{
    "password": "Val1dPa55word!"
}
~~~
- Se a senha for válida, a resposta será 204 No Content. Se a senha for inválida, a resposta será 400 Bad Request com uma lista de erros.

- Exemplo de resposta de erro:
~~~ JSON
{
    "errors": [
        "A senha deve conter pelo menos 8 caracteres",
        "A senha deve conter pelo menos uma letra maiúscula"
    ]
}
~~~

## Estrutura do Projeto

- **Controller**: Responsável por receber as requisições e retornar as respostas.
    - ApiController.java
- **Service**: Contém a lógica de validação da senha.
    - PasswordService.java
- **Tests**: Contém os testes unitários para garantir que o serviço está funcionando corretamente.
    - PasswordServiceTest.java
- **Model**: Define a estrutura do request body.
    - BodyRequest.java