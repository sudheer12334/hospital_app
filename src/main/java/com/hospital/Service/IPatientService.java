package com.hospital.Service;

import java.util.List;
import com.hospital.Entity.Patient;

public interface IPatientService {
	
	public Patient addPatient(Patient patient);

	public void removePatient(long patientId);

	public Patient updatePatient(long patientId, Patient patient);

	public Patient getPatient(long patientId);

	public List<Patient> getAllPatients();

    public List<Patient> getPatientByName(String  patientName);

	public List<Patient> getPatientByContactNo(String  contactNo);
	
//	public LoginResponse login(String userName, String password);
}
