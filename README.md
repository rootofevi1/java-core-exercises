# Основы Java — алгоритмы, коллекции и файловый ввод-вывод
Java Core practice: console applications, arrays, recursion, file I/O and Stream API.

[![Build](https://github.com/rootofevi1/java-core-exercises/actions/workflows/build.yml/badge.svg)](https://github.com/rootofevi1/java-core-exercises/actions/workflows/build.yml)

Десять консольных программ. Проект показывает базовые навыки Java: обработку ввода, работу с числами, массивами, строками, файлами и объектами. Эти навыки использую как основу для автоматизации тестирования.

## Что внутри

| Модуль | Что делает | Что демонстрирует |
|---|---|---|
| [exercise1](src/exercise1/src/main/java/exercise1/Main.java) | Вычисляет периметр треугольника по координатам | Вещественные числа, методы, проверка существования треугольника |
| [exercise2](src/exercise2/src/main/java/exercise/Main.java) | Переводит секунды в `hh:mm:ss` | Разделение ввода, вычисления и вывода |
| [exercise3](src/exercise3/src/main/java/exercise/Main.java) | Вычисляет число Фибоначчи | Рекурсия, ограничение диапазона `int` |
| [exercise4](src/exercise4/src/main/java/exercise/Main.java) | Находит среднее отрицательных элементов | Массивы, циклы, целочисленное деление |
| [exercise5](src/exercise5/src/main/java/exercise/Main.java) | Выбирает числа с одинаковыми первой и последней цифрами | Арифметика, фильтрация массива |
| [exercise6](src/exercise6/src/main/java/exercise/Main.java) | Сортирует числа по возрастанию | Собственная сортировка выбором |
| [exercise7](src/exercise7/src/main/java/exercise/Main.java) | Читает числа из файла и сохраняет минимум и максимум | `Path`, `BufferedReader`, `PrintWriter`, обработка ошибок |
| [exercise8](src/exercise8/src/main/java/exercise/Main.java) | Проверяет строгое возрастание последовательности | Разбор строки, поиск первого нарушения порядка |
| [exercise9](src/exercise9/src/main/java/exercise/Main.java) | Ищет строки, содержащие подстроку | `List`, `String.contains`, фильтрация без Stream API |
| [exercise10](src/exercise10/src/main/java/exercise/Main.java) | Выбирает имена совершеннолетних пользователей | Класс `User`, Stream API, `filter`, `map`, `joining` |

## Стек и структура

Java 21 · Gradle 9.3.0 · Kotlin DSL. Внешние сервисы не нужны.

Один Gradle Wrapper в корне запускает десять независимых модулей `src/exercise1` … `src/exercise10`. Исходники каждого модуля расположены в `src/main/java`. Одинаковые имена классов в разных модулях не конфликтуют.

## Запуск

Нужны JDK 21 и настроенный `JAVA_HOME`. Для первого запуска Wrapper необходим интернет.

```bash
git clone https://github.com/rootofevi1/java-core-exercises.git
cd java-core-exercises
./gradlew build
./gradlew :exercise2:run --console=plain -q
```

Введите `3665` и нажмите Enter. Результат: `01:01:05`.

Windows PowerShell:

```powershell
.\gradlew.bat build
.\gradlew.bat :exercise2:run --console=plain -q
```

Замените `exercise2` в команде на нужный модуль. Консольные программы читают данные из стандартного ввода; запускать их следует из терминала.

### Работа с файлом

Запустите `:exercise7:run` и введите `src/main/resources/sample.txt`. Пути отсчитываются от каталога модуля `src/exercise7`. Программа читает количество элементов и числа, затем создаёт `src/exercise7/result.txt`. Файл результата исключён из Git.

## Происхождение

Для портфолио добавлены общая сборка и команды `run`, выбран JDK 21, путь выходного файла в седьмом модуле сделан относительно каталога. Демонстрационный файл создан отдельно для публичного примера.

Тексты заданий, комментарии с условиями и исходными тестовыми данными, служебные материалы и история учебного репозитория не включены.

Александр · Junior QA/AQA Engineer · [Email](mailto:a@samoylov-qa.ru) · [Telegram](https://t.me/samoylov_av)
