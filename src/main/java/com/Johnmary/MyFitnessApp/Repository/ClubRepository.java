package com.Johnmary.MyFitnessApp.Repository;

import com.Johnmary.MyFitnessApp.Model.ClubModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<ClubModel , Long> {
    Optional<ClubModel> findByTitle(String url);
    @Query("SELECT c from ClubModel c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<ClubModel> searchClubs(String query);
}
