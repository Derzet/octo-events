package com.voyager.mt.octo.endpoint.controller;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/octoapi.feature",
        plugin = {"pretty",
                "json:target/reports/json/octoapi.json",
                "html:target/reports/octoapi.html",},
        glue = { "com.voyager.mt.octo.endpoint.controller" })
public class OctoApiT {
}
