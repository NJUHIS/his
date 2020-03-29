package com.njuhis.his.mapper;

import com.njuhis.his.model.Invoice;
import java.util.List;

public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invoice record);

    Invoice selectByPrimaryKey(Integer id);

    List<Invoice> selectAll();

    int updateByPrimaryKey(Invoice record);

    List<Invoice> selectAllJoin();
}