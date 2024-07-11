package com.mcsoftware.petcare.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "t_vaccination")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class VaccinatePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "first_vaccine_date",nullable = false)
    private Date firstVaccineDate;

    @Column(name = "second_vaccine_date",nullable = false)
    private Date secondVaccineDate;

    @JoinColumn(name = "wild_animal_id",nullable = false,referencedColumnName = "id")
    @OneToOne
    @JsonBackReference
    private WildAnimal wildAnimalId;

    @JoinColumn(name = "shelter_id",nullable = false, referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private Shelter shelterId;

    @JoinColumn(name = "serviceProviderId",nullable = false,referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private ServiceProvider serviceProviderId;

}
