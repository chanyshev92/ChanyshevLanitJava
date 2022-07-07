#language:ru
@ticketUiTest
Функционал:
  -Создание нового тикета
  -Авторизация
  -поиск тикета
  -редактирование созданного тикета
  -проверка созданного тикета

  Сценарий: Позитивная проверка

    * открыть url "https://at-sandbox.workbench.lanit.ru/"
    * инициализация страницы "Helpdesk"
    * кликнуть на элемент "New Ticket"

    * в выпадающем списке "Queue" выбрать "Django Helpdesk"
    * ввести в поле "Summary of the problem" значение "More Data"
    * ввести в поле "Description of your issue" значение "))"
    * в выпадающем списке "Priority" выбрать "1. Critical"
    * ввести в поле "Due on" значение "2022-07-26 00:00:00"
    * ввести в поле "Your E-Mail Address" значение "123@rb.ru"
    * кликнуть на элемент "Submit Ticket"

    * кликнуть на элемент "Log In"
    * проверить что текущий url содержит текст "login"
    * ввести в поле "Username" значение "admin"
    * ввести в поле "Password" значение "adminat"
    * кликнуть на элемент "Login"

    * ввести в поле "Search..." значение "More Data"
    * кликнуть на элемент "GO"

    * кликнуть на элемент "Query Results"
    * кликнуть на элемент "Edit details"
    * кликнуть на элемент "Status Closed"
    * кликнуть на элемент "Attach file(s)"
    * прикрепить файл "file.txt"
    * кликнуть на элемент "Update This Ticket"

    * на странице присутствует текст "Closed"
    * на странице присутствует текст "1. Critical"
    * на странице присутствует текст "123@rb.ru"
    * на странице присутствует текст "Queue: Django Helpdesk"
    * на странице присутствует текст "Ticket Opened Via Web"
    * подождать 5 сек