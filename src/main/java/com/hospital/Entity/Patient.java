package com.hospital.Entity;


import java.time.LocalDate;


import jakarta.persistence.*;


@Entity
@Table(name = "patient_tbl")
public class Patient {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "patient_id")
	 private Long patientId;

	 @Column(name = "name")
	private String name;

	 @Column(name = "email")
	private String email;

	 @Column(name = "contact_no")
	private String contactNo;

	 @Column(name = "dob")
		private LocalDate dob;

	@Column(name = "address")
	    private String address;

    @Column(name = "branch")
		private String branch;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

