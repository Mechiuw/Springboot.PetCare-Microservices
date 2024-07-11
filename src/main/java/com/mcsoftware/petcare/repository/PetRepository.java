package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,String> {
}
