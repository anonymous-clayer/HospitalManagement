package com.dev.HospitalManagement.Exception;

import javax.print.Doc;

public class DoctorNotFoundException extends Exception{
    public DoctorNotFoundException(String message){
        super(message);
    }
}
