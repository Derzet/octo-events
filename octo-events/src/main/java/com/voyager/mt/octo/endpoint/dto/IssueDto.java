package com.voyager.mt.octo.endpoint.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {
    private Long id;
    private List<EventDto> events;

}