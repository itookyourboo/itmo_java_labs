## Лабораторная работа №8
### Вариант 312327

Доработать программу из лабораторной работы №7 следующим образом:<br>
Заменить консольный клиент на клиент с графическим интерфейсом пользователя(GUI).<br>
В функционал клиента должно входить:

1. Окно с авторизацией/регистрацией.
2. Отображение текущего пользователя.
3. Таблица, отображающая все объекты из коллекции<br>
    a. Каждое поле объекта - отдельная колонка таблицы.<br>
    b. Строки таблицы можно фильтровать/сортировать по значениям любой из колонок. Сортировку и фильтрацию значений столбцов реализовать с помощью Streams API.<br>
4. Поддержка всех команд из предыдущих лабораторных работ.
5. Область, визуализирующую объекты коллекции<br>
    a. Объекты должны быть нарисованы с помощью графических примитивов с использованием Graphics, Canvas или аналогичных средств графической библиотеки.<br>
    b. При визуализации использовать данные о координатах и размерах объекта.<br>
    c. Объекты от разных пользователей должны быть нарисованы разными цветами.<br>
    d. При нажатии на объект должна выводиться информация об этом объекте.<br>
    e. При добавлении/удалении/изменении объекта, он должен автоматически появиться/исчезнуть/измениться  на области как владельца, так и всех других клиентов.<br> 
    f. При отрисовке объекта должна воспроизводиться согласованная с преподавателем анимация.<br>
6. Возможность редактирования отдельных полей любого из объектов (принадлежащего пользователю). Переход к редактированию объекта возможен из таблицы с общим списком объектов и из области с визуализацией объекта.
7. Возможность удаления выбранного объекта (даже если команды remove ранее не было).

Перед непосредственной разработкой приложения необходимо согласовать прототип интерфейса с преподавателем. Прототип интерфейса должен быть создан с помощью средства для построения прототипов интерфейсов(mockplus, draw.io, etc.)<br><br>

Интерфейс должен быть реализован с помощью библиотеки **Swing**<br>
Графический интерфейс клиентской части должен поддерживать **русский**, **чешский**, **болгарский** и **испанский (Колумбия)** языки / локали. Должно обеспечиваться корректное отображение чисел, даты и времени в соответстии с локалью. Переключение языков должно происходить без перезапуска приложения. Локализованные ресурсы должны храниться в **классе**.