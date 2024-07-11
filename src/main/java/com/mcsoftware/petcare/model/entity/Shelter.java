package com.mcsoftware.petcare.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mcsoftware.petcare.constant.EStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "m_shelter")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Shelter {

    @Id
    @GeneratedValue
    private String id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code",nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "is_active",nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus isActive;

    @OneToMany(mappedBy = "shelterAdoptId",cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Pet> petInShelter;
}
