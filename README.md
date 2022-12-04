# Gerenciamento_Projetos
Projeto para Java na disciplina de Projeto de Software - Uso do Intellij para desenvolvimento do Projeto

## Aluno
* Gabriel Lucas Bento Germano

## Módulos do projeto

* Parte 1 do projeto (Funcionalidades)
    * [Entrega 1](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/commit/7ea63af41012d88aa8c05d9f007e6844318e5b66)
* Parte 2 do projeto (Otimizado usando Orientação a Objetos)
    * [Entrega 2](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/commit/d1143de821b99e00f3e36c554dbfcc1c4850526f)
* Parte 3 do projeto (Identificação dos smells)
    * [Entrega 3](https://github.com/Gabrielgermanoo/Gerenciamento_Projetos/commit/2b47746094d204fb9b23bab21bac1dc92214e888)
* Parte 4 do projeto (Aplicação de padrões de projeto)
    * [Entrega 4]()

  ## Como executar?

Para compilar o projeto entre na pasta src
 ```bash
    cd src
 ```
e digite o comando
  ```bash
    javac Main.java
 ```
Agora executando o programa
  ```bash
    java Main
 ```

## Comentarios sobre as entregas
### Entrega 1:
Optei por utilizar Lista encadeadas como o ArrayList para poder armazenar os dados do programa. Infelizmente não consegui criar um arquivo como banco de dados para poder obter as informações então todo o programa armazena em tempo de execução. Ademais, a forma de utilizar o undo/redo foi feita pela classe Acoes que serve para armazenar duas pilhas, uma para ir adicionando qualquer alteração feita pelo usuário e a outra pilha para pegar o dado que foi removido da pilha e armazena-lo caso haja alguma ação para refazer. Nesse codigo priorizei as funcionalidades do sistema, de acordo com o diagrama passado.

### Entrega 2:
Nesta entrega, refatorei o código para torná-lo eficaz e reduzir a quantidade de código repetido, seguindo os conceitos de orientação a objetos. Seguindo o que foi pedido pelo professor, adicionei classes que herdam de uma classe superior e adicionei classes para as ações do projeto, além de criar interfaces a fim de evitar erros e padronizar as funcionalidades. Há, também, classes abstratas que são responsáveis para a manutenção dos conceitos de orientação a objetos. Ademais, os conceitos restantes foram implementados de forma natural do código, de acordo com as funcionalidades descritas na entrega 1.

### Entrega 3:
Nesta entrega, voltada para as exceções, serviu para evitar que erros run time para que o código saia legítimo e evite quebras ao executar.

## Design patterns e Code Smells
Nesse tópico iremos abordar alguns Code Smells que estão presentes no código atualmente.
* Duplicate Code
  Quando possui expressões iguais em dois métodos na mesma classe
* Data Clumps
  Quando um grupo de parametros vão juntos
* Long Method
  No caso em que há várias condicionais agrupadas e acumulo de informação para variáveis locais
* Large Class
  Quando uma classe faz mais do que devia. Presente no código ao ter vários métodos e variáveis
* Shotgun Surgery (Acredito que é um dos mais presentes)
  Acontece em uma pequena mudança no código que faz com que tenha várias pequenas mudanças em diferentes classes.
* Lazy Class
  Classe que tem apenas uma subclasse
* Data Class
  Classes que tem campos que estão fazendo apenas métodos get e set.

## Padrões de Projeto
Nesse tópico abordamos alguns padrões de projeto que foram aplicados para corrigir os smells identificados na sessão anterior

### Padrão Bridge

* Este Padrão serviu para eliminarmos o problema da large class que tinham operações com muitas linhas, resolvemos utilizar subclasses que se relacionariam mais com as funções como CRUD, consulta, processo e pilha (responsavel pelo undo/redo).


* O padrão de projeto Bridge divide a lógica de negócio ou uma enorme classe (nosso caso) em hierarquias de classe separadas que podem ser desenvolvidas independentemente. Uma dessas (as subclasses com as operações) obterá uma referência a um objeto da segunda hierarquia, agora nossas funções estão dentro das novas classes:
    * Add
    * Update
    * Remove
    * Stack
    * Reports

* Facilitando manutenção, legibilidade e resolvendo o nosso code smell. O foco foi separar nossa large class em classes menores que se relacionam mais entre si. Foi criado também uma nova classe Actions, que será nossa "Ponte (Bridge)", com funções gerais de busca e checagens que serviram pra todas as nossas classes filhas de operações que herdam as operações gerais.

![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)

### Padrão Builder

* Utilizado para resolver nosso smell de código duplicado encontrado na nossa função de criar um objeto de conta e definir seus atributos, o padrão builder tem como objetivo eliminar a complexidade na criação de objetos e também deixar esse processo mais intuitivo. Com isso conseguimos poupar várias linhas de código e o deixar mais legível, um exemplo de onde aplicamos o padrão:

![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)

### Padrão Factory Method
