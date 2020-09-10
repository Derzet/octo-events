package com.voyager.mt.octo.service;

import com.voyager.mt.octo.entity.Event;
import com.voyager.mt.octo.entity.Issue;

import java.util.List;

public interface IssueService {

    Issue save(Issue issue);

    List<Event> listByEvents(Long issueId);
}
