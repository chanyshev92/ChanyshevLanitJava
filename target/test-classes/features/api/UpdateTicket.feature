#language:ru
@ticketTestApi
Функционал:
  -Создание тикета с высоким приоритетом.
  -Перевод статуса тикета из "Закрыт" в "Открыт".

Сценарий:  Негативная проверка

  #Создаем новый тикет
  * создать контекстные переменные
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
    | id | $.id |
  * извлечь данные
    | status1 | $.status |

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
  * статус код 200
  #* статус код 422

