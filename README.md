# Gerenciamento_Projetos
Projeto para Java na disciplina de Projeto de Software - Uso do Intellij para desenvolvimento do Projeto

## Aluno
* Gabriel Lucas Bento Germano

## Módulos do projeto

* Main do projeto
  *[Main](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/blob/main/src/ProjectManager.java)
* Classe de Usuarios
  * [Users](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/blob/main/src/Users.java)
* Classe de Atividades
  * [Activities](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/blob/main/src/Atividades.java)
* Classe de Projetos
  * [Projects](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/blob/main/src/Project.java)
* Classe de Ações
  *[Ações](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/blob/main/src/Acoes.java)
  
  ## Como executar?
  
 Para compilar o projeto entre na pasta src
 ```bash
    cd src
 ```
 e digite o comando
  ```bash
    javac ProjectManager.java
 ```
 Agora executando o programa
  ```bash
    java ProjectManager
 ```
 
 ## Como funciona o programa?
 Optei por utilizar Lista encadeadas como o ArrayList para poder armazenar os dados do programa. Infelizmente não consegui criar um arquivo como banco de dados para poder obter as informações então todo o programa armazena em tempo de execução. Ademais, a forma de utilizar o undo/redo foi feita pela classe Acoes que serve para armazenar duas pilhas, uma para ir adicionando qualquer alteração feita pelo usuário e a outra pilha para pegar o dado que foi removido da pilha e armazena-lo caso haja alguma ação para refazer.
