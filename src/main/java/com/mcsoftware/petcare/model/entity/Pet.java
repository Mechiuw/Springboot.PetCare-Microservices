package com.mcsoftware.petcare.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mcsoftware.petcare.model.struct.Animal;
import jakarta.persistence.*;
import lombok.*;

@Builder(toBuilder = true)
@Entity
@Table(name = "m_pet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "age",nullable = false)
    private String age;

    @Column(name = "medical_conditions" , nullable = false,length = 100)
    private String medicalConditions;

    @ManyToOne
    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "client_adopt",referencedColumnName = "id")
    private Client clientAdopt;
}





