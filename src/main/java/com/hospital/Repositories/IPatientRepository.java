package com.hospital.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.hospital.Entity.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameIgnoreCaseContaining(String name);
    List<Patient> findByContactNo(String contactNo);
}


