# REISystems-GSA-CFDA-Selenium
CFDA modernization UI Selenium E2E Tests

## Prerequisites:
- Java SDK 1.7
- Maven
- driver for phantomJS or chrome

## Running Tests
Currently supported with Chrome and phantomJS. Will add more browser support soon

#### Run with Chrome
1. Add 'chromedriver' to this project
2. Run the following command:
```
mvn package -DsiteTarget="TARGETSITE_URL"
```

#### Run headless with phantomJS
Run the following command:
```
mvn package -Dphantomjsbin="PHANTOMJS_BINARY_LOCATION" -DsiteTarget="TARGETSITE_URL"
```