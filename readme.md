# Readme

The console app will parse  html code from the url an return a JSON Array of all products on the page. That app will have test cases included.


# Requirements

- maven
- java 1.7
- JUnit

### compile run and test the app

cd moneysupermarket

mvn assembly:assembly

java -cp target/com-moneysupermarket-test-0.0.1-SNAPSHOT.jar com.moneysupermarket.test.App

mvn test