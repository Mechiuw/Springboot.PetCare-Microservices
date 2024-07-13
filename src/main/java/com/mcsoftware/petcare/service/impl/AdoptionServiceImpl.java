package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.service.interfaces.AdoptionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class AdoptionServiceImpl implements AdoptionService {
    private final
}
