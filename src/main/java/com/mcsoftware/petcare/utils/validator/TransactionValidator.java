package com.mcsoftware.petcare.utils.validator;

import jakarta.validation.ValidationException;
import org.hibernate.PropertyNotFoundException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionValidator {


    public <T> Map<String,Object> objToMap(T obj) throws IllegalAccessException {
        try {
            Map<String, Object> mapped = new HashMap<>();
            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field f : fields) {
                f.setAccessible(true);
                mapped.put(f.getName(), f.get(obj));
            }
            return mapped;
        } catch (ValidationException e){
            throw new RuntimeException(e.getMessage());
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }


    public <T> T validator(T obj) throws IllegalAccessException {
        try {
            Map<String, Object> mapped = objToMap(obj);
            for (Map.Entry<String, Object> entry : mapped.entrySet()) {
                if (entry.getValue() == null) {
                    throw new PropertyNotFoundException(String.format("%s can't be null", entry.getKey()));
                }
            }
            return obj;
        } catch (ValidationException e){
            throw new RuntimeException(e.getMessage());
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
}
