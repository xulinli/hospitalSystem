package com.hos.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hos.entity.Patient;
import com.hos.mapper.PatientMapper;
import com.hos.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public PageInfo<Patient> queryPatient(Map<String, Object> params) {
        int currentPage = (int)params.get("currentPage");
        int displayCount = (int)params.get("displayCount");
        String patientName = (String) params.get("patientName");
        PageHelper.startPage(currentPage, displayCount);
        return new PageInfo<>(patientMapper.queryPatient(patientName));
    }

    @Override
    public Integer addPatient(Patient patient) {
        return null;
    }

    @Override
    public Integer updatePatient(Patient patient) {
        return null;
    }

    @Override
    public Integer deletePatient(Map<String, Object> params) {
        return null;
    }
}
