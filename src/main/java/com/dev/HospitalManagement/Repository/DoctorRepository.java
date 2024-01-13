package com.dev.HospitalManagement.Repository;

import com.dev.HospitalManagement.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findBySpecialization(String specialization);
}
