#language:ru
@all
Функционал: Открываем депозит

  Сценарий: Открываем депозит в рублях

    Когда выбрано поле Вклады и переход на страницу Вклады

    И выбираем Валюту "Рубли"

    И Заполняем значения Вклада
      | Сумма вклада           | 300000 |
      | На срок                | 9      |
      | Ежемесячное пополнение | 50000  |

    И Отмечаем Ежемесячная капитализация

    И Проверяем значения:
      | Начислено %              | 18 056,35  |
      | Пополнение за 9 месяцев  | 400 000    |
      | К снятию через 9 месяцев | 718 056,35 |


  Сценарий: Открываем депозит в долларах

    Когда выбрано поле Вклады и переход на страницу Вклады

    И выбираем Валюту "Доллары"

    И Заполняем значения Вклада
      | Сумма вклада           | 500000 |
      | На срок                | 9      |
      | Ежемесячное пополнение | 5000   |
    И Отмечаем Ежемесячная капитализация

    И Проверяем значения:
      | Начислено % | 1 159,38   |
      | Пополнение  | 40 000     |
      | К снятию    | 541 159,38 |


