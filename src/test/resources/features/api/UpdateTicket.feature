#language:ru
@ticketTestApi
Функционал:
  -Создание тикета с высоким приоритетом.
  -Перевод статуса тикета из "Закрыт" в "Открыт".

Сценарий:  Негативная проверка

  #Создаем новый тикет
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
    | priority        | 5                        |
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
    | id               | $.id              |
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
  #Даты создания, модификации неверны(старые), поэтому не должны совпадать
  * сравнить значения
    | {id1}               | != | {id}               |
    | ${due_date}         | == | ${due_date1}       |
    | ${assigned_to}      | == | ${assigned_to}     |
    | ${title1}           | == | ${title}           |
    | ${created}          | != | ${created1}        |
    | ${modified}         | != | ${modified1}       |
    | ${submitter_email1} | == | ${submitter_email} |
    | ${status1}          | == | ${status}          |
    | ${on_hold1}         | == | ${on_hold}         |
    | ${description1}     | == | ${description}     |
    | ${resolution1}      | == | ${resolution}      |
    | ${priority1}        | == | ${priority}        |
    | ${secret_key1}      | == | ${secret_key}      |
    | ${queue1}           | == | ${queue}           |
    | ${kbitem1}          | == | ${kbitem}          |
    | ${merged_to1}       | == | ${merged_to}       |

  #Авторизация
  * создать запрос
    | method | path       | body       |
    | POST   | /api/login | logIn.json |
  * добавить header
    | Content-Type | application/json |
  * отправить запрос
  * статус код 200
  * извлечь данные
    | token | $.token |
  * сравнить значения
    | ${token} | == | 0979e0b6ce2e2d74f7c0ffbf4d28cdfe9dd1cb47 |


  #Смена статусов:
  * создать контекстные переменные
    | status | 1 |

  * создать запрос
    | method | path               | body              |
    | PUT    | /api/tickets/${id} | createTicket.json |

  * добавить header
    | Content-Type  | application/json |
    | Authorization | token ${token}   |

  * отправить запрос
  * статус код 422

