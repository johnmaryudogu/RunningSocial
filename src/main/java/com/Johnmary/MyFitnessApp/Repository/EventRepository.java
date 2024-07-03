package com.Johnmary.MyFitnessApp.Repository;

import com.Johnmary.MyFitnessApp.Model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventModel, Long> {


}
