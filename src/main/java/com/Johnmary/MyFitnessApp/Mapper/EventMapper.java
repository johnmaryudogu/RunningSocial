package com.Johnmary.MyFitnessApp.Mapper;

import com.Johnmary.MyFitnessApp.Model.EventModel;
import com.Johnmary.MyFitnessApp.dto.Eventdto;

public class EventMapper {


    public static EventModel mapToEvent(Eventdto eventdto) {

        return EventModel.builder()
                .id(eventdto.getId())
                .name(eventdto.getName())
                .startTime(eventdto.getStartTime())
                .endTime(eventdto.getEndTime())
                .type(eventdto.getType())
                .photoUrl(eventdto.getPhotoUrl())
                .createdOn(eventdto.getCreatedOn())
                .updatedOn(eventdto.getUpdatedOn())
                .clubModel(eventdto.getClubModel())
                .build();



    }

    public static Eventdto mapToEventDto(EventModel eventModel) {

        return Eventdto.builder()
                .id(eventModel.getId())
                .name(eventModel.getName())
                .startTime(eventModel.getStartTime())
                .endTime(eventModel.getEndTime())
                .type(eventModel.getType())
                .photoUrl(eventModel.getPhotoUrl())
                .createdOn(eventModel.getCreatedOn())
                .updatedOn(eventModel.getUpdatedOn())
                .clubModel(eventModel.getClubModel())
                .build();



    }

}
