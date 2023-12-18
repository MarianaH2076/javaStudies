# Trabalhando com datas
## Conceitos importantes

* Data-[hora] local:
  * A hora é opcional e a hora local é armazenada sem fuso horário
  * ano - mês - dia - [hora] sem fuso horário
  * [hora] opcional
* Data-hora global:
  * aqui pede o armazenamento ano-mês-dia com fuso horário
* Duração:
  * tempo decorrido entre duas data-horas

* Exemplos:
  * Banco de dados, API:
    * 2022-07-23T14:30:00Z
      * ano-mês-diaT (*indicando que vem o tempo*) hora-horário local
      * Para os usuários que estão em seus respectivos locais, o programa lê a data, vê que é o horário de Londres e calcula

* Quando usar?
  * Data-[hora] local:
    * Quando o momento exato não interessa a pessoas de outro fuso-horário
    * Uso comum: em sistemas de região única e Excel, por exemplo
      * Data de nascimento: "15/06/2001"
      * Data-hora da venda: "13/08/2022 às 15:32" (presumindo que o fuso não é importante)
  * Data-hora global:
    * Quando o momento exato interessa a pessoas de outros fusos
    * Uso comum: sistemas multi-região, web...
      * Quando será o sorteio? "21/08/2023 às 20h (horário de Brasília)"
      * Quando o comentário foi postado? "há 17 minutos"
      * Quando foi realizada a venda? "13/08/2022 às 15:54 (horário de Brasília)"
      * Início e fim do evento? "21/08/2023 de 14h até 16h"

## Timezone (fuso horário)

* GMT - Greenwich Mean Time
  * Horário de Londres
  * Horário do padrão UTC - Coordinated Universal Time
  * Também chamado de "Z" time ou Zulu time
* Outros fusos relativos ao GMT/UTC:
  * SP: GMT-3
  * Manaus: GMT-4
  * Portugal: GMT+1
* Muitas linguagens ou tecnologias usam nomes para as timezones:
  * "US/Pacific"
  * "America/Sao_Paulo"...

## Padrão ISO 8601
* Data-[hora] local:
  * 2022-07-21 (ano-mês-dia)
  * 2022-07-21T14:52 (ano-mês-diaTIMEhora)
  * 2022-07-21T14:52:09 (ano-mês-diaTIMEhora)
  * 2022-07-21T14:52:09.4073 (idem, mas com fração de segundos)
* Data-hora global:
  * 2022-07-21T14:52:09Z (zulu time)
  * 2022-07-21T14:52:09.254935Z (com fração de segundos)
  * 2022-07-21T14:52:09-03:00 (com indicação do fuso horário _diferente_ do gmt)

## Operações importantes com data-hora
* Instanciação
  * (agora) -> data-hora
  * Texto ISO 8601 -> data-hora
  * Texto formato customizado -> data-hora
  * dia, mês, ano, [horário] -> data-hora local
* Formatação
  * Data-hora -> Texto ISO 8601
  * Data-hora -> Texto formato customizado
* Obter dados de uma data-hora local
  * Data-hora local -> dia, mês, ano, horário
* Converter data-hora global para local
  * Data-hora global, timezone (sistema local) -> data-hora local
* Cálculos com data-hora
  * Data-hora +/- tempo -> data-hora
  * Data-hora 1, Data-hora 2 -> duração

## Principais tipos Java
* Data-hora local
  * LocalDate
  * LocalDateTime
* Data-hora global
  * Instant (representa um instante no tempo)
* Duração
  * Duration
* Outros
  * ZoneId
  * ChronoUnit