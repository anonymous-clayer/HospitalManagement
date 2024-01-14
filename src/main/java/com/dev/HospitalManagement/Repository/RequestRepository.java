package com.dev.HospitalManagement.Repository;

import com.dev.HospitalManagement.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
}
