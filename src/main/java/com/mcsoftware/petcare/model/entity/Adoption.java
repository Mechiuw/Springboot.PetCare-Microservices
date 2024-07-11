package com.mcsoftware.petcare.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mcsoftware.petcare.model.struct.Control;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "t_adoption")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class Adoption extends Control {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JoinColumn(referencedColumnName = "id",name = "client_id", nullable = false)
    @ManyToOne
    @JsonBackReference
    private Client clientId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "shelter_id",nullable = false)
    @JsonBackReference
    private Shelter shelterId;

    @OneToMany(mappedBy = "adoptionId",cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<AdoptionDetail> adoptionDetailList;
}
