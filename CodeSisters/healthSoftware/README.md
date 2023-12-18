# Gestão de pacientes e relatórios

Esse é o início de um projeto de uma ferramenta que irá auxiliar psicólogos e profissionais da saúde a gerenciarem as informações de seus pacientes e relatórios.

## Documentação da API

### Regras de negócio

##### Funcionalidades
* Cadastro e atualização de pacientes
* Cadastro e atualização de relatórios de sessão

##### Cadastro e atualização de pacientes
###### Requisitos Funcionais:
* o  usuário deve poder cadastrar e atualizar os dados dos pacientes
* o usuário deve poder buscar pacientes pelo seu id ou pelo seu nome

###### Requisitos Não Funcionais:
* deve ser criada uma tabela para clientes
* devem ser criado os campos: CPF (char), que será o ID; name (varchar), com o nome completo; birthDate (Date); phoneNumber (char); city (varchar); startDate (Date) com a data de início da terapia

###### Regras de negócio:
* Nenhum dos campos poderá ser nulo
* Cada paciente deve ter um id único que não pode ser repetido
* O usuário deve confirmar seu login e senha para acessar os dados

##### Cadastro e atualização de relatórios de sessão
###### Requisitos funcionais:
* deve ser criada uma tabela para relatórios
* devem ser criados os campos: id de sessão (UUID); data da sessão (Date); anotações (varchar); técnicas utilizadas (pode ser um campo nulo); anotações para a próxima sessão (varchar)

### Tabelas

##### clients:
```
Table: clients
Columns:
client_id char(36) PK 
cpf varchar(255) 
birth_date date 
phone_number varchar(20) 
city varchar(50) 
uf enum('AC','AL','AP','AM','BA','CE',
    'DF','ES','GO','MA','MT','MS','MG',
    'PA','PB','PR','PE','PI','RJ','RN',
    'RO','RR','SC','SP','SE','TO')
start_date date 
name varchar(255)
```

##### reports:
```
Table: reports
Columns:
report_id char(36) PK 
session_date date 
notes varchar(255) 
techniques varchar(255) 
future_notes varchar(255) 
fk_client_id char(36) 
```

### Requisições - Clients

#### Salva um novo registro de cliente

```http
  POST /clients
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `client`      | `Client` | **Obrigatório**. Os dados do cliente a ser registrado. |

#### Retorna todos os clientes

```http
  GET /clients
```

#### Retorna um cliente pelo seu ID

```http
  GET /clients/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `clientId`      | `string` | **Obrigatório**. O ID do cliente que se deseja buscar. |

#### Retorna um cliente pelo seu nome

```http
  GET /clients/findByName/{name}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | **Obrigatório**. O nome do cliente que se deseja buscar. |

#### Atualiza os dados de um cliente pelo seu ID

```http
  PUT /clients/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O id do cliente que se deseja buscar. |

#### Deleta o registro de um cliente pelo seu ID

```http
  DELETE /clients/delete/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O id do cliente que se deseja excluir. |

### Requisições - Reports

#### Salva um novo registro de relatório

```http
  POST /reports/{clientId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `clientId`      | `String` | **Obrigatório**. O ID do cliente referente à criação do novo relatório de sessão |
| `report`      | `Report` | **Obrigatório**. Os dados do relatório que está sendo criado. |

#### Retorna todos os relatórios

```http
  GET /reports
```

#### Retorna um relatório pelo seu ID

```http
  GET /reports/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` | **Obrigatório**. O ID do relatório que se deseja buscar |

#### Atualiza um relatório pelo seu ID

```http
  PUT /reports/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `report`      | `Report` | **Obrigatório**. Os dados do relatório a ser atualizado. |

#### Deleta o registro de um relatório pelo seu ID

```http
  DELETE /reports/delete/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `reportId`      | `string` | **Obrigatório**. O id do relatório a ser deletado. |