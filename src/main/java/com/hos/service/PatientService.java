package com.hos.service;

import com.github.pagehelper.PageInfo;
import com.hos.entity.Patient;

import java.util.Map;

public interface PatientService {
    PageInfo<Patient> queryPatient(Map<String, Object> params);

    Integer addPatient(Patient patient);

    Integer updatePatient(Patient patient);

    Integer deletePatient(Map<String, Object> params);
}
