package com.dev.HospitalManagement.Controller;


import com.dev.HospitalManagement.Entity.Doctor;
import com.dev.HospitalManagement.Exception.DoctorNotFoundException;
import com.dev.HospitalManagement.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/getDoctor/{doctorId}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long doctorId){
        try {
            Doctor doctor = doctorService.getDoctorById(doctorId);
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity<>("Doctor not found for id: "+doctorId, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/AllDoctor")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors,HttpStatus.OK);
    }

    @GetMapping("/getDoctorBySpecialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorBySpecialization(@PathVariable String specialization){
        List<Doctor> doctors = doctorService.getDoctorBySpecialization(specialization);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }



}
