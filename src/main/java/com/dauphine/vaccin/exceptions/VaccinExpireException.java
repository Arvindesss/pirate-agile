package com.dauphine.vaccin.exceptions;

public class VaccinExpireException extends RuntimeException {
    public VaccinExpireException(String msg) {
        super(msg);
    }
}
