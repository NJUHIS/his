package com.njuhis.his.mapper;

import com.njuhis.his.model.Diagnosispkm;
import java.util.List;

public interface DiagnosispkmMapper {
    int insert(Diagnosispkm record);

    List<Diagnosispkm> selectAll();
}