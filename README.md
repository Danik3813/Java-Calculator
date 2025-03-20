# SwingUI-Calculator
![calc](https://github.com/user-attachments/assets/90ef8955-eade-4589-ae4e-23a8329d3da3)

## Описание
Данный репозиторий - графический калькулятор, написанный на языке программирования Java с использованием фреймворка SwingUI в рамках практической работы по дисциплине "Объектно-ориентированное программирование" и курса на Java-разработчика от Цифровой Кафедры НИЯУ МИФИ.

## Структура проекта
Проект построен на основе паттерна проектирования MVC (Model - Viev - Controller).
Исходный код содержится в src, ресурсы - в resources.

### Пакет controller
Отвечает за связь графического интерфейса калькулятора и методов обработки данных.
- _filehandlers_: класс _ConfigHandlers_ отвечает за работу с конфигурационным файлом, который хранит в себе постоянную память калькулятора;
- _listeners_: пакет с классами слушателей событий нажатия на кнопки работы с памятью или вычислениями;
- _parsers_: пакет с классом парсинга строки с графического интерфейса, а также с утилитарным классом _ParserUtils_.

### Пакет model
Отвечает за вычисления и работу с постоянной памятью калькулятора.
- _utils_: утилитарный класс, выполняющий непосредственные вычисления или работу с данными;
- _остальные классы_: классы, передающие вычислтельные данные контроллеру.

### Пакет view
Реализация динамического графического интерфейса.
- _utils_: наследники _JButton_ с указанием уникального индекса для осуществления связи данных с графическим отображением;
- _CalculatorGUI_: графический интерфейс калькулятора. 

## Запуск проекта
Используте данную команду в терминале по пути к JAR-файлу.
```bash
java -jar calculator.jar
```

## Баги и недочёты
Выявлены следующие баги и недоработки проекта:
- невозможно обработать вычитание отрицательного числа (например, 23--4 не будет обработано);
- экспоненциальные числа формата 7.8E-9 не могут быть обработаны;
- вычисления с вещественными числами могут выдавать проблемы с точностью (например, 23.1 + 5.6 = 28.700000000000003);
- нажатия на цифровую клавиатуру калькулятора после произведённых вычислений не очищают строку;
- нет возможности работать непосредственно с клавиатуры.

## Версия
Текущая версия: 1.0-alpha

## Автор
Студент группы ИФСТ-21, Купцов Даниил Олегович.



