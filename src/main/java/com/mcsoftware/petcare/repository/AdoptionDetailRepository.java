package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.AdoptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionDetailRepository extends JpaRepository<AdoptionDetail,String> {
}
