package com.hospital.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.Entity.Patient;

import com.hospital.Exception.DuplicatePatientException;
import com.hospital.Exception.NoPatientFoundException;
import com.hospital.Exception.ResourceNotFoundException;
import com.hospital.Repositories.IPatientRepository;


@Service
public class IPatientServiceImpl implements IPatientService {
	
	@Autowired
	private IPatientRepository iPatientRepository;
	//Dependency injection for CRUD operations

	public static final Logger LOGGER = LoggerFactory.getLogger(IPatientServiceImpl.class);

	@Override
	public Patient addPatient(Patient patient) throws DuplicatePatientException {
		LOGGER.info("PatientService addPatient() started");
		Patient newPatient = iPatientRepository.save(patient);
		LOGGER.info("PatientService addPatient() ended");
		return newPatient;
	}
	
	@Override
	public void removePatient(long patientId) throws NoPatientFoundException {
		LOGGER.info("PatientService removePatient started");
		Optional<Patient> optionalPatient = iPatientRepository.findById(patientId);
		if (optionalPatient.isPresent()) {
			LOGGER.info("Patient is Removed succesfully from DataBase");

			iPatientRepository.deleteById(patientId);

		} else {
			LOGGER.info("PatientService removePatient() ended");
			throw new NoPatientFoundException("This Patient is Does Not exists" + patientId);

		}
	}



	@Override
	public Patient getPatient(long patientId) {
		LOGGER.info("PatientService getPatient() started");
		Optional<Patient> optional = iPatientRepository.findById(patientId);
		if (optional.isEmpty()) {
			throw new ResourceNotFoundException("Patient not exisiting with id : " + patientId);
		}
		Patient patient = optional.get();
		LOGGER.info("PatientService getPatient() ended");
		return patient;
	}

	@Override
	public Patient updatePatient(long patientId, Patient patient) throws NoPatientFoundException {
		LOGGER.info("PatientService updatePatient() started");
		Optional<Patient> patientToUpdate = iPatientRepository.findById(patientId);
		Patient result = patientToUpdate.orElseThrow(() -> new NoPatientFoundException("No such Patient is present in our records" + patient.getPatientId()));

		// Update patient-related fields
		result.setName(patient.getName());
		result.setEmail(patient.getEmail());
		result.setContactNo(patient.getContactNo());
		result.setDob(patient.getDob());
		result.setBranch(patient.getBranch());
		result.setAddress(patient.getAddress());

		LOGGER.info("PatientService updatePatient() ended");
		return iPatientRepository.save(result);
	}


	@Override
	public List<Patient> getAllPatients() throws NoPatientFoundException {
		LOGGER.info("PatientService getallPatient() started");
		List<Patient> listPatient = iPatientRepository.findAll();
		if (listPatient.isEmpty()) {
			throw new NoPatientFoundException("No Patient List Present In DataBase");
		}
		LOGGER.info("PatientService getallPatient() ended");
		return iPatientRepository.findAll();
	}

	@Override
	public List<Patient> getPatientByName(String patientName) {
		LOGGER.info("PatientService getPatientByName started");
		List<Patient> listPatient = iPatientRepository.findByNameIgnoreCaseContaining(patientName);
		if (listPatient.isEmpty()) {
			throw new NoPatientFoundException("No Patient List Present In DataBase");
		}
		LOGGER.info("PatientService getPatientByName ended");
		return listPatient;
	}

	@Override
	public List<Patient> getPatientByContactNo(String contactNo) {
		LOGGER.info("PatientService getPatientByContactNo started");
		List<Patient> listPatient = iPatientRepository.findByContactNo(contactNo);
		if (listPatient.isEmpty()) {
			throw new NoPatientFoundException("No Patient List Present In DataBase");
		}
		LOGGER.info("PatientService getPatientByContactNo ended");
		return listPatient;
	}
}
