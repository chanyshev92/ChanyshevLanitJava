#language:ru
@ticketUiTest
Функционал:
  - Сохранение поискового запроса

  Сценарий: Позитивная проверка

    * открыть url "https://at-sandbox.workbench.lanit.ru/"
    * инициализация страницы "Helpdesk"
    * кликнуть на элемент "Log In"

    * ввести в поле "Username" значение "admin"
    * ввести в поле "Password" значение "adminat"
    * кликнуть на элемент "Login"

    * ввести в поле "Search..." значение "chRn"
    * кликнуть на элемент "GO"

    * кликнуть на элемент "Save Query"
    * ввести в поле "Query Name" значение "chRnQ"
    * установить чекбокс на элементе "Shared?"
    * кликнуть на элемент "Save Query Button"

    * кликнуть на элемент "Saved Queries"
    * подождать 5 сек
    * проверить что какой-то элемент из "Saved Queries List" содержит текст:"chRnQ"
