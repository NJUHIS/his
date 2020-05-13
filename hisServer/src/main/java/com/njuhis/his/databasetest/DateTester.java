package com.njuhis.his.databasetest;

import com.njuhis.his.mapper.CheckApplyMapper;
import com.njuhis.his.mapper.PrescriptionDetailedMapper;
import com.njuhis.his.model.PrescriptionDetailed;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 此類用以插入測試數據。
 * 此程序啟動後自動運行。
 * @author Paul
 */

@Component
public class DateTester implements ApplicationRunner {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private CheckApplyMapper checkApplyMapper;
    @Autowired
    private PrescriptionDetailedMapper prescriptionDetailedMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //insertPrescriptionDetailed();

    }

    private void insertPrescriptionDetailed(){
        for (int i=1;i<90;i++){
            for (int j=1;j<30;j++){
                PrescriptionDetailed prescriptionDetailed=new PrescriptionDetailed();

                prescriptionDetailed.setPrescriptionid(i);
                prescriptionDetailed.setDrugsid(j);

                prescriptionDetailed.setDosage("jixing");
                prescriptionDetailed.setFrequency("meitianjiuci");
                prescriptionDetailed.setQuantity(100);
                prescriptionDetailed.setPrice(new BigDecimal(100));
                prescriptionDetailed.setUseage("chi");

                System.out.println(i+" "+j);
                prescriptionDetailedMapper.insert(prescriptionDetailed);
            }

        }
    }
}
