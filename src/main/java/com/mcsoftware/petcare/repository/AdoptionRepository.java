package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption,String> {
}
