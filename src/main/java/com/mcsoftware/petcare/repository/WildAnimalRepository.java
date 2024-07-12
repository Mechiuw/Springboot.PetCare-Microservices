package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.WildAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WildAnimalRepository extends JpaRepository<WildAnimal,String> {
}
