package com.hos.mapper;

import com.hos.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PatientMapper {
    List<Patient> queryPatient(@Param(value = "patientName") String patientName);

    int deletePatient(@Param(value = "params") Map<String, Object> params);

    int addPatient(@Param(value = "patient") Patient patient);

    int updatePatient(@Param(value = "patient") Patient patient);
}
