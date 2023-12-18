# Módulo 13

## Enumerações

* Um tipo esepcial que serve para especificar de forma literam um conjunto de constantes relacionadas
* palavra-chave: enum
* vantagens:
  * melhor semântica
  * código mais legível e auxiliado pelo compilador
* Exemplo: o ciclo de vida de um pedido:
  * pendingPayment
    * billing
  * Processing
    * dispatch
  * Shipped
    * deliver
  * Delivered
* Para otimizar, dá pra declarar um enum aula146.entities.enums.OrderStatus {};
  * dentro das {}, define os status possíveis do pedido (os que estão acima)
  * com isso, dá pra criar uma classe Pedido e, dentro dela, declarar um private aula146.entities.enums.OrderStatus (que foram os enums que declaramos lá nas entidades)

### Aula 147 - design
* Mesmo que em OO a gente pense em tudo, de modo geral, como objetos, podemos pensar em classes enquanto categorias:
  * views: telas do sistema
  * controllers: 'meio de campo' entre a tela e o sistema
  * entities: entidades de negócio como produtos, pedidos...
  * services
  * repositories: objetos responsáveis por acessar os dados de um BD
* Isso acontece por questões de design, organização flexibilidade, reuso, delegalçao...
* Sabendo disso, nos primeiros exemplos vamos trabalhar basicamente com entities

### Aula 148 - composição
* um tipo de associação que permite que um objeto contenha outra
* é uma relação 'tem um' ou 'tem vários'
* vantagens:
  * organização: divisão de responsabilidades
  * coesão: cada objeto é responsável por uma única coisa
    * responsabilidade simples e bem definida
  * flexibilidade: trabalhar com algo dividido em partes é mais flexível do que trabalhar com algo muito grande
  * reuso: o mesmo objeto pode ser reaproveitado em mais de um lugar
* OBS: embora o símbolo UML pra composição (todo-parte) seja o diamante preto, nesse contexto é qualquer associação dos tipos
  * tem-um e
  * tem-vários

### Aula 149 - Exercício resolvido
* A ideia é ler os dados de um trabalhador com N contratos, sendo N fornecido pelo usuário
* Depois, será solicitado um mês e será mostrado qual foi o salário do funcionário nesse mês
* Modelo:
  * Worker
    * atributos:
      * name
      * level: WorkerLevel
      * baseSalary
    * métodos:
      * addContract
      * removeContract
      * income
  * HourContract
    * atributos:
      * date
      * valuePorHour
      * hours
    * métodos:
      * totalValue
  * Department
    * name
  * WorkerLevel
    * JUNIOR
    * MID_LEVEL
    * SENIOR
* Quando temos uma composição do tipo tem-vários, não colocamos a lista no nosso construtor e sim a inicializamos!
* 