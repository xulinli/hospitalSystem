package com.hos.entity;

import lombok.Data;

@Data
public class Patient {
    private String admissiondate;
    private String dischargedate;
    private String guarantees;
    private String patientname;
    private String patientsex;
    private String patientaddress;
    private String patientcontact;
    private String conclusion;
    private int hospital_id;
    private int patient_id;
    private int patientage;
    private int sickbed_id;
    private int doctor_id;
    private int nurse_id;
    private float deposits;
}
