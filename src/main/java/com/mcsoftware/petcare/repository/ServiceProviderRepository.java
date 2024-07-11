package com.mcsoftware.petcare.repository;

import com.mcsoftware.petcare.model.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,String> {
}
