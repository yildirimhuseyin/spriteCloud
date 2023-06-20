# Getting started with Cucumber BDD approach
Cucumber is a behavior-driven development (BDD) tool that promotes collaboration between stakeholders by allowing them to express software requirements in a human-readable format called Gherkin.
With Cucumber, test scenarios are written in feature files using Gherkin syntax, which describe the desired behavior of the software. 
Step definitions link these scenarios to the automation code, enabling their execution and providing detailed feedback.
By focusing on clear communication, readability, and maintaining a single source of truth, Cucumber helps teams ensure that software development aligns with business expectations.

## The spriteCloud project
The best place to start is to clone or download the spriteCloud  project on Github ([https://github.com/yildirimhuseyin/LeasePlan.git].
And reload project to upload necessary dependency
## The project directory structure
The project has build scripts for Maven, and follows the standard directory structure used in most Cucumber BDD projects:
```Gherkin
src
  + github
    + workflows
      + maven.yml
  + test
    + java
      + pojo
      + Test runners  
      + stepDefinitions
  
    + resources
      + features
  
             
```

## To trigger Test

TestRunner class used to trigger scenarios. With the tags options it allows to choose which specific scenarios to run.
`FailedTestRunner` class can be used to run only failed tests
```java

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features = "src/test/resources/features",
        glue = "spriteCloud/step_definitions",
        dryRun = false,
        tags = ""

)
public class CukesRunner {
}
```

## Test Coverage and Importance


### Add New Pet Scenario
This scenario tests the ability to add a new pet to the store via an API request.
It ensures that the system can successfully process and store pet data. 
This is an important scenario as it verifies a fundamental functionality of the application.

### Available Pets Scenario
This scenario validates the retrieval of all available pets from the store using an API request. 
It confirms that the system can return the correct status for each pet. 
This scenario is important as it verifies the accuracy of the pet availability information.

### Mouse Over Functionality Scenario
This scenario tests the mouse-over functionality of a specific UI element. 
It validates that the "click me" text is clickable and displays the correct click count on the screen. Although this scenario is UI-specific,
it is important to ensure that the interactive elements of the application are functioning as expected.

### Progress Bar Functionality Scenario
This scenario verifies the ability to start and stop a progress bar when it reaches a desired percentage. 
It ensures that the progress bar behaves correctly and halts at the intended point.
This scenario is important as it tests the accuracy and control of a visual component in the application.


## Additional information about project
### Pojo classes 

The `pojo classes` allow us to create reusable and maintainable framework structure. To implement pojo(Custom java classes) classes make sure that you have lombok and Jakson dependency in your pom.xml:

```
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.20</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.4</version>
        </dependency>
```



### CI/CD implementation
In my current project I have settled up CI/CD in Jenkins. Since it is not possible to present you Jenkins CI/CD
I have decided to create CI/CD pipeline in gitHub.
For this project `Maven.yml` file triggers CI/CD in github when ever new code added to the master branch 



