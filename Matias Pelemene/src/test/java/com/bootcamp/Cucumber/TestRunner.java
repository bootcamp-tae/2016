package com.bootcamp.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Colegio on 28/12/2016.
 */
@CucumberOptions(features = "src/test/resources/features",
        glue = {"classpath:com.bootcamp.Cucumber.Steps"}

)
@RunWith(Cucumber.class)
public class TestRunner {


}
