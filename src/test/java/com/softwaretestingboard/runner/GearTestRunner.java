package com.softwaretestingboard.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.softwaretestingboard",
        features = "src/test/java/resources/featurefile/Gear.feature",
        tags = "@regression",
        plugin = {"pretty", "html:target/cucuber-report/cucumber.html"}
)

public class GearTestRunner {
}
