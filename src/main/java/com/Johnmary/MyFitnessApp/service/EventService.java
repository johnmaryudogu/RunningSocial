package com.Johnmary.MyFitnessApp.service;

import com.Johnmary.MyFitnessApp.dto.Eventdto;

import java.util.List;

public interface EventService {
    void createEvent (Long clubId, Eventdto eventdto);

    List<Eventdto> findAllEvents();

    Eventdto findByEventId(Long eventId);

    void updateEvent(Eventdto eventdto);

    void deleteEvent(long eventId);
}
