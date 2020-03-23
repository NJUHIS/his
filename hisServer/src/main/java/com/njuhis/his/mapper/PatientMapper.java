package com.njuhis.his.mapper;

import com.njuhis.his.model.Patient;
import java.util.List;

public interface PatientMapper {
    int insert(Patient record);

    List<Patient> selectAll();
}