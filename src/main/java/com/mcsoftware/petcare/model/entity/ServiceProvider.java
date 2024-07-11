package com.mcsoftware.petcare.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mcsoftware.petcare.constant.EStatus;
import com.mcsoftware.petcare.constant.EType;
import com.mcsoftware.petcare.constant.EVax;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Builder(toBuilder = true)
@Table(name = "m_service_provider")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "profileIdNumber",nullable = false)
    private String profileIdNumber;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EType type;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "is_vaccinate", nullable = false)
    @Enumerated(EnumType.STRING)
    private EVax isVaccinate;

    @Column(name = "date", nullable = false)
    private Date joinedDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus status;

    @OneToMany(mappedBy = "serviceProviderId",cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Pet> assignedAnimals;

    @OneToMany(mappedBy = "serviceProviderId", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<VaccinatePoint> vaccinatePoints;
}
