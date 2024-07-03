package com.Johnmary.MyFitnessApp.controller;

import com.Johnmary.MyFitnessApp.Model.ClubModel;
import com.Johnmary.MyFitnessApp.dto.Clubdto;
import com.Johnmary.MyFitnessApp.service.clubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class Clubcontroller {

    private clubService clubService;
@Autowired
    public Clubcontroller(clubService clubService) {
        this.clubService = clubService;
    }


    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model){

    List<Clubdto> clubdtos = clubService.searchClubs(query);
    model.addAttribute("clubs",clubdtos);
    return "clubs-list";

    }


    @GetMapping("clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model){
    Clubdto clubdto = clubService.findClubById(clubId);
    model.addAttribute("club",clubdto);
    return "clubs-detail";
    }

    @GetMapping("clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId){
    clubService.delete(clubId);
    return "redirect:/";
    }

//Home
@GetMapping({"/", "/clubs"})
    public String listClubs (Model model){
        List<Clubdto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }

    //Creating new
    @GetMapping("clubs/new")
    public String createClubName(Model model){
        ClubModel clubModel = new ClubModel();
        model.addAttribute("club",clubModel);
        return "clubs-create";
    }

    //Adding
    @PostMapping("clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") Clubdto clubdto, BindingResult bindingResult, Model model){
    if(bindingResult.hasErrors()){
        model.addAttribute("clubs",clubdto);
        return "clubs-create";
    }
    clubService.saveClub(clubdto);
    return "redirect:/clubs";
    }


    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model){
    Clubdto club = clubService.findClubById(clubId);
    model.addAttribute("club",club);
    return "clubs-edit";
    }

//The @Valid and BindingResult here is for getting the errors ensure you have the springboot validation
// in your pom.xml and called @NotEmpty in your dto
    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") long clubId,
                             @Valid @ModelAttribute("club") Clubdto club, BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()){
        model.addAttribute("club",club);
        return "clubs-edit";
    }
    club.setId(clubId);
        clubService.updateCLub(club);
        return "redirect:/clubs";

    }

}
