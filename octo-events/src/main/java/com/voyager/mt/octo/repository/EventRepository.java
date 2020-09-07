package com.voyager.mt.octo.repository;


import com.voyager.mt.octo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
