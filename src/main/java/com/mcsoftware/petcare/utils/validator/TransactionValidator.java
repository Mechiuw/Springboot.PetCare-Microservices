package com.mcsoftware.petcare.utils.validator;

import com.mcsoftware.petcare.model.entity.Adoption;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.PropertyNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionValidator {

    @Bean
    public Map<String,Object> objToMap(Object obj) throws IllegalAccessException {
        Map<String,Object> mapped = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for( Field f : fields){
            f.setAccessible(true);
            mapped.put(f.getName(),f.get(obj));
        }
        return mapped;
    }

    @Bean
    public Adoption adoptionValidator(Adoption adoption) throws IllegalAccessException {
        Map<String,Object> mapped = objToMap(adoption);
        for(Map.Entry<String,Object> x : mapped.entrySet()){
            if(x.getValue() == null){
                throw new PropertyNotFoundException(String.format("%s can't be null",x.getKey()));
            }
        }
        return adoption;
    }
}
