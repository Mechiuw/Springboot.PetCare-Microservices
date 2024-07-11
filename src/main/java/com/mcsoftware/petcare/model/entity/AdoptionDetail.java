package com.mcsoftware.petcare.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_adoption_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AdoptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JoinColumn(referencedColumnName = "id",name = "pet_id",nullable = false)
    @ManyToOne
    @JsonBackReference
    private Pet petId;

    @Column(name = "message")
    private String message;

    @JoinColumn(referencedColumnName = "id",name = "adoption_id",nullable = false)
    @ManyToOne
    @JsonBackReference
    private Adoption adoptionId;
}
