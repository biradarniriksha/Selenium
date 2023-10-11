package com.wipro.menu;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/NI20463611/Desktop/QET_CoE_Selenium/src/test/java/com/wipro/feature/Menu.feature",glue= {"com.wipro.menu"},monochrome = true,
plugin = {"pretty","json:target/cucumber-report/cucumber.json",
"html:target/cucumber-report/cucumber.json","junit:target/cucumber-report/cucmber.junit"})
public class MenuRunner {

}
