package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationPointRepository extends JpaRepository<VaccinatePoint,String> {
}
