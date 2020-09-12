package com.voyager.mt.octo.endpoint.controller;

import com.voyager.mt.octo.endpoint.dto.EventDto;
import com.voyager.mt.octo.entity.Event;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;


@Api(value = "events")
@RequestMapping(path = "/events")
public interface EventController {


    @ApiOperation(value = "save one event", response = Event.class, authorizations = {
            @Authorization(value = "event_auth", scopes = {
                    @AuthorizationScope(scope = "write:event", description = "save one event")
            })
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful!", response = Event.class),
            @ApiResponse(code = 400, message = "Input invalid", response = Void.class)
    })
    @PostMapping
    @ResponseBody
    ResponseEntity<EventDto> save(@RequestBody @Valid EventDto eventDto);


}
