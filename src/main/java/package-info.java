/*
 * Singleton:   Сделала создание генераторов на одиночку, чтобы не  создавать много реализаций классов. Конструкторы приватные, чтобы нельзя было создать реализацию стандартным методом
 * Factory:     Уже реализован с использованием интерфейса Generator, т.к. есть общий интерфейс для объектов. Изменен класс Person, чтобы FioGenerator мог имплементироваться от Generator
 * Builder:     Реализован в методах генераторов, когда один метод заполняет данные, а другой отдает результат.
 * Adapter:     Не нашла применение
 * Bridge:      Уже реализован для хранения типа волос
 * Facade:      реализован метод, который скрывает в себе 2 метода для более короткой записи
 * DTO:         удален неиспользуемый код
 * Шаблон:      Тип при создании реализации генераторов заменен на общий, чтобы был общий шаблон
 */