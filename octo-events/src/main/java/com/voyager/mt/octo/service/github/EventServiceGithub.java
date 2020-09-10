package com.voyager.mt.octo.service.github;

import com.voyager.mt.octo.entity.Event;
import com.voyager.mt.octo.repository.EventRepository;
import com.voyager.mt.octo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EventServiceGithub implements EventService {

    @Autowired
    EventRepository eventRepository;


    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }


}
