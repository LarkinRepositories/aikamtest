#Тестовое задание на вакансию Java Junior developer/стажер. Компания ООО Aйкам
Дата выполнения:31.03.2019
##Задача
Тестовое задание в файле /doc/test_Java_Junior_Developer.pdf
##Стек технологий
- Java 8
- Maven
- PostgreSQL
- Spring Boot (CommandLineRunner)
- Spring Data Jpa
- ObjectMapper
- ModelMapper
- Lombok

##Сборка приложения
Сборщиком является Maven.
mvn package создаст файл /target/aikamtest-0.0.1-SNAPSHOT.jar

##Выполнение приложения
Перед запуском необходимо развернуть базу данных по адресу localhost:5437 с именем aikam. 
В проекте использован liquibase, поэтому достаточно просто развернуть базу данных PostgreSQL с данным именем по указанному выше адресу.
При запуске приложения таблицы и наполнение базы произойдет автоматически.
Дамп базы данных, если потребуется, здесь: db_dump/aikam.sql

При иных параметрах доступа к базе данных необходимо прописать их в файле src/main/resourses/application.properties и пересобрать приложение.

Демонстрационные файлы search-input.json для операции поиска и stat-import.json для операции вывода статистики находятся в папке files в корне проекта.
Демонстрационный jar файл находится в папке jar в корне проекта.
####Примеры запуска приложения:
- java -jar aikamtest-0.0.1-SNAPSHOT.jar search search-input.json search-output.json
- java -jar aikamtest-0.0.1-SNAPSHOT.jar stat stat-input.json stat-output.json

---------
- Файл приложения: aikamtest-0.0.1-SNAPSHOT.jar
- Тип операции: search / stat
- Абсолютный путь к входному файлу: search-input.json / stat-input.json
- Абсолютный путь к выходному файлу: search-output.json / stat-output.json   



 


