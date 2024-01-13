package com.dev.HospitalManagement.Service;

import com.dev.HospitalManagement.Entity.Doctor;
import com.dev.HospitalManagement.Entity.SliderImage;
import com.dev.HospitalManagement.Exception.DoctorNotFoundException;
import com.dev.HospitalManagement.Repository.DoctorRepository;
import com.dev.HospitalManagement.Repository.SliderImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SliderImageRepository sliderImageRepository;

    public ResponseEntity<Doctor> addDoctor(Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    public Doctor getDoctorById(Long doctorId) throws DoctorNotFoundException {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalDoctor.isPresent()) {
            return optionalDoctor.get();
        } else {
            throw new DoctorNotFoundException("Doctor not found with Id : " + doctorId);
        }
    }


    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getDoctorBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    @Transactional
    public void saveSliderImage(MultipartFile file) {
        try {
            SliderImage image = SliderImage.builder().photo(file.getBytes()).build();
            sliderImageRepository.save(image);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SliderImage> getAllSliderImages() {
        return sliderImageRepository.findAll();
    }
}

