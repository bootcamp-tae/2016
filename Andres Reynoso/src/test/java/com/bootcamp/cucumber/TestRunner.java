package com.bootcamp.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Colegio on 28/12/2016.
 */

@CucumberOptions(features = "src/test/features", glue = {"classpath:com/bootcamp/cucumber/steps"})
@RunWith(Cucumber.class)
public class TestRunner {

}
