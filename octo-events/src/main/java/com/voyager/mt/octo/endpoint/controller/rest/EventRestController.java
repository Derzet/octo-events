package com.voyager.mt.octo.endpoint.controller.rest;

import com.voyager.mt.octo.endpoint.controller.EventController;
import com.voyager.mt.octo.endpoint.dto.EventDto;
import com.voyager.mt.octo.endpoint.mapper.EventMapper;
import com.voyager.mt.octo.endpoint.mapper.IssueMapper;
import com.voyager.mt.octo.entity.Event;
import com.voyager.mt.octo.service.EventService;
import com.voyager.mt.octo.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class EventRestController implements EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private IssueService issueService;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private IssueMapper issueMapper;

    public ResponseEntity<EventDto> save(@Valid @RequestBody EventDto eventDto) {
        Event event = eventService.save(eventMapper.map(eventDto));
        return ResponseEntity.ok(eventMapper.map(event));
    }

}
