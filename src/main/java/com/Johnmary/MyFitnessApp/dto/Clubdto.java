package com.Johnmary.MyFitnessApp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Clubdto {

    private Long id;
    @NotEmpty(message ="Club Title should not be empty")
    private String title;
    @NotEmpty(message ="Phot link should not be empty")
    private String photoUrl;
    @NotEmpty(message ="Content should not be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    private List<Eventdto> eventdtoList;

}
