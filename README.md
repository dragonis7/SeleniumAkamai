Author: Dariusz Zdybski (dariusz.zdybski@gmail.com)

This project includes tests for searching job post in Akamai website.

It checks three main things:
    -total amount of searched results

    -the number of jobs in the first result page that have "Software Development Engineer in Test" in their title

    -creation date of "Software Development Engineer in Test - LUNA" advert

Technology stack:
    Java 8, Maven, Selenium WebDriver, JUnit

To run the project you need to have Java 8, maven and chrome browser, chrome webdriver (provided in repo) installed

Running for windows:
    mvn clean test
