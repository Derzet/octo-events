package com.voyager.mt.octo.endpoint.mapper;

import com.voyager.mt.octo.endpoint.dto.IssueDto;
import com.voyager.mt.octo.entity.Issue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IssueMapper {

    @Mapping(source = "events", target = "events")
    IssueDto map(Issue issue);

    @Mapping(source = "events", target = "events")
    Issue map(IssueDto issueDto);


}
