package com.hospital.Controller;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.Entity.Patient;
import com.hospital.Service.IPatientService;
//import com.hospital.Payload.LoginReqPayload;
//import com.hospital.Payload.LoginResponse;
//import com.hospital.Service.AuthenticationService;


@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {
	@Autowired
	private IPatientService iPatientService;

	public static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@PostMapping("/save")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		LOGGER.info("Patient createPatient() started");
		Patient cust = iPatientService.addPatient(patient);
		ResponseEntity<Patient> responseEntity = new ResponseEntity<>(cust, HttpStatus.CREATED);
		LOGGER.info("Patient createPatient() ended");
		return responseEntity;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Patient>> allPatient() {
		LOGGER.info("Patient allPatient() started");
		List<Patient> listPatients = iPatientService.getAllPatients();
		ResponseEntity<List<Patient>> responseEntity = new ResponseEntity<>(listPatients, HttpStatus.ACCEPTED);
		LOGGER.info("Patient allPatient() ended");
		return responseEntity;
	}

	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<String> delPatient(@PathVariable("patientId") long patientId) {
		LOGGER.info("Patient delPatient() started");
		iPatientService.removePatient(patientId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
		LOGGER.info("Patient delPatient() ended");
		return responseEntity;
	}

//	@GetMapping("/{patientId}")
//	public ResponseEntity<Patient> knowById(@PathVariable("patientId") long patientId) {
//		LOGGER.info("Patient knowById() started");
//		Patient knowPatient = iPatientService.getPatient(patientId);
//		ResponseEntity<Patient> responseEntity = new ResponseEntity<>(knowPatient, HttpStatus.OK);
//		LOGGER.info("Patient knowById() ended");
//		return responseEntity;
//	}

	@GetMapping("/{name}")
	public ResponseEntity<List<Patient>> getPatientByName(@PathVariable("name") String patientName) {
		LOGGER.info("Patient getPatientByName() started");
		List<Patient> Patients = iPatientService.getPatientByName(patientName);
		ResponseEntity<List<Patient>> responseEntity = new ResponseEntity<>(Patients, HttpStatus.OK);
		LOGGER.info("Patient getPatientByName() ended");
		return responseEntity;
	}

	@GetMapping("/contact/{contactNo}")
	public ResponseEntity<List<Patient>> getPatientByContactNo(@PathVariable("contactNo") String contactNo) {
		LOGGER.info("Patient getPatientByContactNo() started");
		List<Patient> Patients = iPatientService.getPatientByContactNo(contactNo);
		ResponseEntity<List<Patient>> responseEntity = new ResponseEntity<>(Patients, HttpStatus.OK);
		LOGGER.info("Patient getPatientByContactNo() ended");
		return responseEntity;
	}

	@PutMapping("/update/{patientId}")
	public ResponseEntity<Patient> updatePatient(@PathVariable long patientId, @RequestBody Patient patient) {
		LOGGER.info("Patient updatePatient() started");
		Patient upPat = iPatientService.updatePatient(patientId, patient);
		ResponseEntity<Patient> responseEntity = new ResponseEntity<>(upPat, HttpStatus.OK);
		LOGGER.info("Patient updatePatient() ended");
		return responseEntity;
	
	}

//	@PostMapping("/login")
//    public ResponseEntity<LoginResponse> doLogin(@RequestBody LoginReqPayload loginPayload) {
//        LoginResponse loginResponse = authenticationService.login(loginPayload.getUserName(), loginPayload.getUserPassword());
//        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
//    }
	
}
