package com.Johnmary.MyFitnessApp.service;

import com.Johnmary.MyFitnessApp.Model.ClubModel;
import com.Johnmary.MyFitnessApp.dto.Clubdto;

import java.util.List;

public interface clubService {

    List<Clubdto> findAllClubs();

    ClubModel saveClub(Clubdto clubdto);

    Clubdto findClubById(long clubId);

    void updateCLub(Clubdto club);

    void delete(Long clubId);


    List<Clubdto> searchClubs(String query);
}
