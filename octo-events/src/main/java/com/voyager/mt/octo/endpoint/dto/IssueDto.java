package com.voyager.mt.octo.endpoint.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueDto {
    private Long id;
    private List<EventDto> events;

}