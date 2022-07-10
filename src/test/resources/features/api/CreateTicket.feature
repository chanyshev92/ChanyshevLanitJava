#language:ru
@ticketTestApi
Функционал:
  -Создание тикета с высоким приоритетом

Сценарий: Позитивная проверка

  * сгенерировать переменные
    | id              | 0                        |
    | due_date        | 2022-06-26               |
    | assigned_to     | admin                    |
    | title           | No Data                  |
    | created         | 2022-06-26T13:33:21.262Z |
    | modified        | 2022-06-26T13:33:21.262Z |
    | submitter_email | 123@rb.ru                |
    | status          | 4                        |
    | on_hold         | false                    |
    | description     | ))                       |
    | resolution      | no resolution            |
    | priority        | 1                        |
    | secret_key      | 1                        |
    | queue           | 1                        |
    | kbitem          | 1                        |
    | merged_to       | 2                        |
  * создать запрос
    | method | path         | body              |
    | POST   | /api/tickets | createTicket.json |
  * добавить header
    | Content-Type | application/json |
  * отправить запрос
  * статус код 201
  * извлечь данные
    | id1              | $.id              |
    | due_date1        | $.due_date        |
    | assigned_to1     | $.assigned_to     |
    | title1           | $.title           |
    | created1         | $.created         |
    | modified1        | $.modified        |
    | submitter_email1 | $.submitter_email |
    | status1          | $.status          |
    | on_hold1         | $.on_hold         |
    | description1     | $.description     |
    | resolution1      | $.resolution      |
    | priority1        | $.priority        |
    | secret_key1      | $.secret_key      |
    | queue1           | $.queue           |
    | kbitem1          | $.kbitem          |
    | merged_to1       | $.merged_to       |
  * создать запрос
    | method | path       | body       |
    | POST   | /api/login | logIn.json |
  * добавить header
    | Content-Type | application/json |
  * отправить запрос
  * статус код 200
  * извлечь данные
    | token | $.token |

  * создать запрос
    | method | path              |
    | GET    |/api/tickets/${id1}|
  *  добавить header
    | Content-Type  | application/json |
    | Authorization | token ${token}   |

  * отправить запрос
  * статус код 200
  * извлечь данные
    | id              | $.id              |
    | due_date        | $.due_date        |
    | assigned_to     | $.assigned_to     |
    | title           | $.title           |
    | created         | $.created         |
    | modified        | $.modified        |
    | submitter_email | $.submitter_email |
    | status          | $.status          |
    | on_hold         | $.on_hold         |
    | description     | $.description     |
    | resolution      | $.resolution      |
    | priority        | $.priority        |
    | secret_key      | $.secret_key      |
    | queue           | $.queue           |
    | kbitem          | $.kbitem          |
    | merged_to       | $.merged_to       |
  * сравнить значения
    | ${id}              | ==       | ${id1}              |
    | ${due_date}        | содержит | ${due_date1}        |
    | ${assigned_to}     | ==       | ${assigned_to1}     |
    | ${title}           | ==       | ${title1}           |
    | ${created}         | содержит | ${created1}         |
    | ${modified}        | содержит | ${modified1}        |
    | ${submitter_email} | ==       | ${submitter_email1} |
    | ${status}          | ==       | ${status1}          |
    | ${on_hold}         | ==       | ${on_hold1}         |
    | ${description}     | ==       | ${description1}     |
    | ${resolution}      | ==       | ${resolution1}      |
    | ${priority}        | ==       | ${priority1}        |
    | ${secret_key}      | ==       | ${secret_key1}      |
    | ${queue}           | ==       | ${queue1}           |
    | ${kbitem}          | ==       | ${kbitem1}          |
    | ${merged_to}       | ==       | ${merged_to1}       |