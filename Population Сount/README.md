## Простой веб-сервис для получения списка стран и посчета населения используя World Population API.

## Как запустить:
#### Необходимые инструменты:
* [JDK 8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Apache Maven 3+](<https://maven.apache.org/download.cgi>)

#### 1. Скачать репозиторий и перейти в папку с проектом
    $ cd SpringProjects/Population\ Сount/

#### 2. Выполнить следующие команды в терминале:
    $ mvn compile
    $ mvn package
    
#### 3. Запустить проект:
    $ java -jar target/artifact-1.0.jar
    
## Работа сервиса (из терминала):
#### 1. Получить список всех стран
    $ curl localhost:8080/countries
    
#### 2. Получить данные популяции Италии на 01.02.2016
    $ curl http://localhost:8080/population?country=Italy&date=2016-02-01
#### Все данные предоставляются в формате JSON
________________
### Тиркия Гога
