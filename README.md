# Финальный проект по курсу "Автоматизированное тестирование на Java" в "Образовательном центре программирования и высоких технологий IT-Academy"
## Проект для онлайн-гипермаркет [21век](https://www.21vek.by/)
21vek.by появилась на рынке в 2004 году. Сегодня это крупнейший белорусский онлайн-гипермаркет непродовольственных товаров с огромным выбором товаров для дома, работы и отдыха, а также доставкой в любую точку Республики Беларусь.

____

### Описание:  Проект содержит набор автоматизированных тестов, написанных на языке программирования Java.
- Используемые библиотеки в проекте: 
  - selenium
  - log4j
  - rest-assured
  - json-schema-validator
  - testng
  - allure-testng

- Содержание проекта (Packeges)
  - main
     - enums
     - listeners
     - pages
     - service
     - utils
       - retry
     - resources

  - test
    - api_tests (4 API TESTS)
    - ui_tests (8 UI TESTS)
      - add_to_cart (2)
      - authorization (4)
      - search (2)
    - resources
       - json
       - test_suites
____

Для запуска проекта необходимо: 
1. Установить IntelliJ IDEA и Java 21
2. Скачать проект, выполнив команду 
   ```git
   git clone git@github.com:YmkoVlad/final_project.git
   ```
3. Открыть проект в IntelliJ IDEA
4. Выполнить команду в console IntelliJ IDEA
   ```mvn
   mvn test -Dsuiet=suite_name -Dbrowser=%broswer%
   ```
доступные suites 
- apitest
- uitest

для UI тестов можно выбрать браузер (по умолчанию chrome)
- chrome
- firefox




