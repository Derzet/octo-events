package com.voyager.mt.octo.endpoint.controller.rest;

import com.voyager.mt.octo.endpoint.controller.IssueController;
import com.voyager.mt.octo.endpoint.dto.EventDto;
import com.voyager.mt.octo.endpoint.dto.IssueDto;
import com.voyager.mt.octo.endpoint.mapper.EventMapper;
import com.voyager.mt.octo.endpoint.mapper.IssueMapper;
import com.voyager.mt.octo.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IssueRestController implements IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private IssueMapper issueMapper;

    @Override
    public ResponseEntity<IssueDto> getIssueEvents(Long issueID) {
        List<EventDto> eventsDto = eventMapper.map(issueService.listByEvents(issueID));
        return ResponseEntity.ok(IssueDto.builder().id(issueID).events(eventsDto).build());
    }
}
