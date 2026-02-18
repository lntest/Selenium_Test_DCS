package com.dept.automation.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {
                "com.dept.automation.step_definitions",
                "com.dept.automation.hooks"
        },
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"},
        tags ="@test"
)
public class TestRunner {

}
