package com.taskhub.taskhubbackend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {

    private Utils() {
    }

    public static ResponseEntity<String> getResponseEntity(String mensaje, HttpStatus httpStatus) {
        return new ResponseEntity<String>("Mensaje: " + mensaje,httpStatus);
    }
}