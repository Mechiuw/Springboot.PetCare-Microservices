package com.mcsoftware.petcare.model.dto.API;

public record CommonResponse<T>(Integer statusCode,String message,T data) {
}
