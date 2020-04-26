package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//挂号
@Data
public class Register {
    private Integer id;//挂号主键ID
    private String realname;//患者真实姓名
    private Integer gender; //患者性别
    //1 - 男性
    //2 - 女性
    //3 - 其他
    private String idnumber;//患者身份证号码
    private Date birthdate;//患者出生日期
    private Integer age;//患者年龄
    private String homeaddress;//患者家庭住址
    private Integer medicalRecordId;//病历主键ID
    private Date visitdate;//预约看诊日期
    //standard forms ("yyyy-MM-dd"))
    private Integer noon;//预约看诊午别
    //1 - 凌晨
    //2 - 早上
    //3 - 下午
    //4 - 晚上
    private Integer deptid;//看诊科室主键ID
    private Integer userid;//医生的医院员工主键ID
    private Integer registid;//挂号类型主键ID
    private Integer settleid;//结算类型主键ID
    private Integer isbook;//是否需要病历本
    //1-需要
    //0-不需要
    private Long registertime;//挂号时间。毫秒數。
    private Integer registerid;//挂号员的医院员工主键ID
    private Integer visitstate;//看诊状态
    //0-未看诊
    //1-正在看诊
    //2-诊毕
    private Integer patientid;//患者主键ID
    private Integer scheduleId;//排班主键ID
    private List<PatientCosts> patientCostsList;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone="GMT+8")
    public Date getBirthdate() {
        return birthdate;
    }


    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }



    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone="GMT+8")
    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public Integer getNoon() {
        return noon;
    }

    public void setNoon(Integer noon) {
        this.noon = noon;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRegistid() {
        return registid;
    }

    public void setRegistid(Integer registid) {
        this.registid = registid;
    }

    public Integer getSettleid() {
        return settleid;
    }

    public void setSettleid(Integer settleid) {
        this.settleid = settleid;
    }

    public Integer getIsbook() {
        return isbook;
    }

    public void setIsbook(Integer isbook) {
        this.isbook = isbook;
    }

    public Long getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Long registertime) {
        this.registertime = registertime;
    }

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public Integer getVisitstate() {
        return visitstate;
    }

    public void setVisitstate(Integer visitstate) {
        this.visitstate = visitstate;
    }

    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public List<PatientCosts> getPatientCostsList() {
        return patientCostsList;
    }

    public void setPatientCostsList(List<PatientCosts> patientCostsList) {
        this.patientCostsList = patientCostsList;
    }

    //不能為空的字段
    @JsonIgnore
    private static final String[][] notEmptyFieldsCheckListString =new String[][]{
            //字段名+英文名+中文翻譯
            {"patientid","Patient ID","患者主键ID"},
//            {"noon","Part of Day","预约看诊午别"},
            {"isbook","Need Book","是否需要病历本"},
//            {"visitdate","Appointment Date","预约看诊日期"},
//            {"userid","Doctor ID","医生的医院员工主键ID"},
            {"settleid","Settlement Type ID","结算类型主键ID"},
//            {"registid","Registration Type ID","挂号类型主键ID"},
//            {"deptid","Department ID","看诊科室主键ID"}
            {"scheduleId","Schedule ID","排班主键ID"}

    };
    @JsonIgnore
    private static final Map<String, String[]> notEmptyFieldsCheckList =new HashMap<>();
    public Register(){
        for(String[]fieldToCheckNotEmpty: notEmptyFieldsCheckListString){
            String[] fieldTranslations=new String[]{
                    fieldToCheckNotEmpty[1],fieldToCheckNotEmpty[2]
            };
            notEmptyFieldsCheckList.put(fieldToCheckNotEmpty[0],fieldTranslations);
        }
    }

    public static Map<String, String[]> getNotEmptyFieldsCheckList() {
        return notEmptyFieldsCheckList;
    }
}