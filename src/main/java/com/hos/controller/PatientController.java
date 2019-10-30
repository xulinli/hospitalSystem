package com.hos.controller;

import com.github.pagehelper.PageInfo;
import com.hos.entity.Patient;
import com.hos.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public PageInfo<Patient> queryPatient(@RequestParam Map<String,Object> params){
        System.out.println(params);
        String name = (String) params.get("patientName");
        try {
            byte[] bytes = name.getBytes("ISO-8859-1");
            params.put("patientName",new String(bytes, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(params);
        return patientService.queryPatient(params);
    }

    @PostMapping
    public Integer addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @PutMapping
    public Integer updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    @DeleteMapping
    public Integer deletePatient(@RequestParam Map<String,Object> params){
        System.out.println(1);
        System.out.println(params);
        return patientService.deletePatient(params);
    }
}
