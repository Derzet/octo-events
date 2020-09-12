package com.voyager.mt.octo.endpoint.mapper;

import com.voyager.mt.octo.endpoint.dto.EventDto;
import com.voyager.mt.octo.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "action", target = "action")
    EventDto map(Event event);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "action", target = "action")
    @Mapping(source = "issue", target = "issue")
    Event map(EventDto eventDto);

    List<EventDto> map(List<Event> event);

}
