# CucumberJavaFramework
Automation framework for Selenium using Cucumber Java bindings

# Executing Tests
All Scenarios will be executed in parallel with 3 Threads.  

To run the tests execute command following command.  
```mvn clean verify failsafe:integration-test -DenvName=production -DbrowserName=chrome```
