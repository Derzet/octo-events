package com.voyager.mt.octo.service.github;

import com.voyager.mt.octo.config.error.exception.IssueNotFoundException;
import com.voyager.mt.octo.entity.Event;
import com.voyager.mt.octo.entity.Issue;
import com.voyager.mt.octo.repository.IssueRepository;
import com.voyager.mt.octo.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IssueServiceGithub implements IssueService {

    @Autowired
    IssueRepository issueRepository;

    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> listByEvents(Long issueId) {
        return issueRepository.findById(issueId).orElseThrow(()-> new IssueNotFoundException(issueId)).getEvents();
    }

}
