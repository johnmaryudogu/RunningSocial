package com.Johnmary.MyFitnessApp.impl;

import com.Johnmary.MyFitnessApp.Model.ClubModel;
import com.Johnmary.MyFitnessApp.Repository.ClubRepository;
import com.Johnmary.MyFitnessApp.dto.Clubdto;
import com.Johnmary.MyFitnessApp.service.clubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.Johnmary.MyFitnessApp.Mapper.ClubMapper.mapToClub;
import static com.Johnmary.MyFitnessApp.Mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements clubService {

    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Clubdto> findAllClubs() {
        List<ClubModel> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto (club)).collect(Collectors.toList());
    }

    @Override
    public ClubModel saveClub(Clubdto clubdto) {
        ClubModel clubModel = mapToClub(clubdto);
        return clubRepository.save(clubModel);
    }

    @Override
    public Clubdto findClubById(long clubId) {
        ClubModel clubModel =  clubRepository.findById(clubId).get();
        return mapToClubDto(clubModel);
    }

    @Override
    public void updateCLub(Clubdto clubdto) {
        ClubModel clubModel = mapToClub(clubdto);
        clubRepository.save(clubModel);

    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<Clubdto> searchClubs(String query) {
        List<ClubModel> clubModels = clubRepository.searchClubs(query);

        return clubModels.stream().map(clubModel -> mapToClubDto(clubModel)).collect(Collectors.toList());
    }





}
