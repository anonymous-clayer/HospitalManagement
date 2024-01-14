package com.dev.HospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_doctor", nullable = false)
    private String nameOfDoctor;

    @Column(name = "name_of_patient", nullable = false)
    private String nameOfPatient;

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "request", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'pending'")
    private String request;

    // Constructors, getters, setters, and other methods...

    // You can generate constructors, getters, setters, and other methods using your IDE or Lombok.
}
