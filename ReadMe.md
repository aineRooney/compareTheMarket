README

Framework
* Java 
* Selenium
* Serenity http://www.thucydides.info/docs/serenity/
* Maven
* Junit

To Run the tests using maven from command line type the following
mvn verify -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver={location of your chromedriver}

To run test from IDE add the following vm arguments
-Dwebdriver.driver=chrome -Dwebdriver.chrome.driver={location of your chromedriver}

When running with maven, a test report is generated in target/site/thucydides.
Open the index.html file, this will show test cases, user can navigate to test steps and will display timings for each step.

The setup method is in Abstract Test, this will go to the url, maximise the screen and assert the supplier header is displayed

The 3 test cases are compareTheMarketTest.java

All dependencies version should be automatically downloaded if maven is correctly configured

I have also attached the version of the chrome driver that I have used, it is located in src/main/resources