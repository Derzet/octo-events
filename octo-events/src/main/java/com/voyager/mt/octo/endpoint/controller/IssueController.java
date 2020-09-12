package com.voyager.mt.octo.endpoint.controller;

import com.voyager.mt.octo.endpoint.dto.EventDto;
import com.voyager.mt.octo.entity.Event;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "issues")
@RequestMapping(path = "/issues")
public interface IssueController {

    @ApiOperation(value = "find Events associeted by issues", response = Event.class, authorizations = {
            @Authorization(value = "issue_auth", scopes = {
                    @AuthorizationScope(scope = "write:event", description = "find Events associeted by issues")
            })
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operaton successful!", response = Event.class),
            @ApiResponse(code = 404, message = "Event not found!", response = Void.class),
    })
    @GetMapping(value = "{issueID}/events")
    @ResponseBody
    ResponseEntity<List<EventDto>> getIssueEvents(@ApiParam(value = "ID(KEY) issue",required = true) @PathVariable("issueID") Long issueID);
}
