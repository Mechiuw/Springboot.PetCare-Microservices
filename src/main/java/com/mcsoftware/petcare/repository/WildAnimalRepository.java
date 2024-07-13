package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.WildAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WildAnimalRepository extends JpaRepository<WildAnimal,String> {
}
