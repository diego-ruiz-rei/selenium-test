# REISystems-GSA-SGA-Selenium
CFDA modernization UI Selenium E2E Tests

## Prerequisites:
- Java SDK 1.8
- Maven
- driver for [phantomJS](http://phantomjs.org/download.html) or [chrome](https://sites.google.com/a/chromium.org/chromedriver/)

## Running Tests
Currently supported with Chrome and phantomJS. Will add more browser support soon

#### Run with Chrome
1. Add 'chromedriver' to this project
2. Run the following command:
```
mvn test -DsiteTarget="TARGETSITE_URL"
```

#### Run headless with phantomJS
Run the following command:
```
mvn test -Dphantomjsbin="PHANTOMJS_BINARY_LOCATION" -DsiteTarget="TARGETSITE_URL"
```