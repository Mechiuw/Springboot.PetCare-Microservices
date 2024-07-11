package com.mcsoftware.petcare.model.entity;

import com.mcsoftware.petcare.constant.EAnimal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_wild_animal")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class WildAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "breed",nullable = false)
    private String breed;

    @Column(name = "animal_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EAnimal animalType;

    @Column(name = "medical_conditions",nullable = false)
    private String medicalConditions;

    @Column(name = "location_found",nullable = false)
    private String locationFound;

    @Column(name = "is_alive",nullable = false)
    private Boolean isAlive;
}
