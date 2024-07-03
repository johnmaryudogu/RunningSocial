package com.Johnmary.MyFitnessApp.impl;

import com.Johnmary.MyFitnessApp.Model.ClubModel;
import com.Johnmary.MyFitnessApp.Model.EventModel;
import com.Johnmary.MyFitnessApp.Repository.ClubRepository;
import com.Johnmary.MyFitnessApp.Repository.EventRepository;
import com.Johnmary.MyFitnessApp.dto.Eventdto;
import com.Johnmary.MyFitnessApp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.Johnmary.MyFitnessApp.Mapper.EventMapper.mapToEvent;
import static com.Johnmary.MyFitnessApp.Mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
private EventRepository eventRepository;
private ClubRepository clubRepository;


    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, Eventdto eventdto) {
        ClubModel clubModel = clubRepository.findById(clubId).get();
        EventModel eventModel = mapToEvent(eventdto);
        eventModel.setClubModel(clubModel);
        eventRepository.save(eventModel);

    }

    @Override
    public List<Eventdto> findAllEvents() {
        List<EventModel> eventModelsList = eventRepository.findAll();
        return eventModelsList.stream().map(eventModel -> mapToEventDto(eventModel)).collect(Collectors.toList());
    }

    @Override
    public Eventdto findByEventId(Long eventId) {
        EventModel eventModel = eventRepository.findById(eventId).get();
        return mapToEventDto(eventModel);
    }

    @Override
    public void updateEvent(Eventdto eventdto) {
        EventModel eventModel = mapToEvent(eventdto);
        eventRepository.save(eventModel);

    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }
}
