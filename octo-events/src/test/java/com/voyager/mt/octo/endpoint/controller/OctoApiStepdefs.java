package com.voyager.mt.octo.endpoint.controller;

import com.voyager.mt.SpringApplicationStarter;
import com.voyager.mt.octo.endpoint.dto.EventDto;
import com.voyager.mt.octo.endpoint.dto.IssueDto;
import com.voyager.mt.octo.endpoint.dto.IssueRelationDto;
import com.voyager.mt.octo.entity.Event;
import com.voyager.mt.octo.entity.Issue;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.net.URL;
import java.time.LocalDateTime;


@ContextConfiguration
@SpringBootTest(classes = SpringApplicationStarter.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OctoApiStepdefs implements En {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;
    private URL base;
    private ResponseEntity response;


    public OctoApiStepdefs() {

        Given("application has acess to the issues API", () -> {
            base = new URL("http://localhost:" + port + "/");
        });

        Given("application has acess to the events API",()->{
            base = new URL("http://localhost:" + port + "/");
        });


        When("application calls GET issues {int} events", (Integer id) -> {
            response = testRestTemplate.getForEntity(base.toString() + "issues/" + id + "/events",
                    IssueDto.class);
        });

        When("application calls POST events with mandatory fields {long} , {string}", (Long idIssue,String action) -> {
            Issue issue = Issue.builder().id(idIssue).build();

            IssueRelationDto issueRelationDto = new IssueRelationDto();
            issueRelationDto.setId(idIssue);
            Event event = new Event();
            event.setCreatedAt(LocalDateTime.now());
            event.setAction(action);
            event.setIssue(issue);

            HttpEntity<Event> httpEntity = new HttpEntity<>(event);
            response = testRestTemplate.postForEntity(base.toString() + "events", httpEntity, EventDto.class);
        });

        Then("application receives status code {int}", (Integer status) -> {
            if (response != null) {
                Assert.assertEquals(response.getStatusCode().value(), status.intValue());
            }
        });

        Then("application receives message containing the id of the newly created event with {int}", (Integer status) -> {
            if (response != null) {
                Assert.assertEquals(response.getStatusCode().value(), status.intValue());
            }
        });



    }


}
