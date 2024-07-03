package com.Johnmary.MyFitnessApp.Mapper;

import com.Johnmary.MyFitnessApp.Model.ClubModel;
import com.Johnmary.MyFitnessApp.dto.Clubdto;

import java.util.stream.Collectors;

import static com.Johnmary.MyFitnessApp.Mapper.EventMapper.mapToEventDto;

public class ClubMapper {

    public static ClubModel mapToClub(Clubdto club) {
        ClubModel clubDto = ClubModel.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();

        return clubDto;
    }

    public static Clubdto mapToClubDto(ClubModel club) {
        Clubdto clubdto = Clubdto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .eventdtoList(club.getEventSet().stream().map((eventModel) -> mapToEventDto(eventModel)).collect(Collectors.toList()))
                .build();
        return clubdto;
    }

}
