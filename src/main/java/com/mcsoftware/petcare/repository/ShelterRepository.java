package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter,String> {
}
