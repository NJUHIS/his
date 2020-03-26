package com.njuhis.his.mapper;

import com.njuhis.his.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientMapper {
    int insert(Patient record);

    List<Patient> selectAll();
}