package com.bootcamp.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"classpath:com.bootcamp/cucumber/steps"}
)

@RunWith(Cucumber.class)
public class TestRunner {
}
