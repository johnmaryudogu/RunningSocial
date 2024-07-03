package com.Johnmary.MyFitnessApp.controller;

import com.Johnmary.MyFitnessApp.Model.EventModel;
import com.Johnmary.MyFitnessApp.dto.Clubdto;
import com.Johnmary.MyFitnessApp.dto.Eventdto;
import com.Johnmary.MyFitnessApp.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model){
        List<Eventdto> eventdto = eventService.findAllEvents();
        model.addAttribute("events",eventdto);
        return "events-list";
    }

    @GetMapping("/events/{eventId}")
    public String ViewEvent(@PathVariable ("eventId") Long eventId, Model model ){
        Eventdto eventdto = eventService.findByEventId(eventId);
        model.addAttribute("event",eventdto);
        return  "events-detail";

    }


    @GetMapping("/events/{clubId}/new")
    public String creatEventForm (@PathVariable("clubId") Long clubId, Model model){
        EventModel eventModel = new EventModel();
        model.addAttribute("clubId",clubId);
        model.addAttribute("event",eventModel);
        return "events-create";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") long eventId, Model model){
        Eventdto event = eventService.findByEventId(eventId);
        model.addAttribute("event",event);
        return "events-edit";
    }


    @PostMapping("events/{clubId}")
    public String createEvent (@PathVariable("clubId") Long clubId, @ModelAttribute("event")Eventdto eventdto,
                               @Valid  BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("events",eventdto);
            return "clubs-create";
        }
        eventService.createEvent(clubId,eventdto);
        return "redirect:/clubs/"+clubId;
    }

    @PostMapping("/eventss/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") long eventId,
                             @Valid @ModelAttribute("event") Eventdto eventdto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("events",eventdto);
            return "events-edit";
        }
        Eventdto eventdto1 = eventService.findByEventId(eventId);

        eventdto.setId(eventId);
        eventdto.setClubModel(eventdto1.getClubModel());
        eventService.updateEvent(eventdto);
        return "redirect:/events";

    }


    @GetMapping("events/{eventId}/delete")
    public String deleteEvent(@PathVariable ("eventId") long eventId){
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }
}
