package com.voyager.mt.octo.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private IssueRelationDto issue;
    private LocalDateTime createdAt;
    private String action;

}