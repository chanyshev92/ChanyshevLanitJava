#language:ru
@ticketTestApi
Функционал:
  -Создание тикета с высоким приоритетом

Сценарий: Позитивная проверка
  
  * сгенерировать значение "https://at-sandbox.workbench.lanit.ru" и сохранить под именем "baseUrl"
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
