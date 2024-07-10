package com.mcsoftware.petcare.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mcsoftware.petcare.constant.EStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "m_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "profileIdNumber",nullable = false)
    private String profileIdNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus status;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Pet> listAdopting;
}
