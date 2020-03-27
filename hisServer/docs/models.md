# 实体模型文档

By Paul

### 1. 用户 User

```java
public class User {
private Integer id;//用戶主键ID
    private Integer id;//用戶主键ID
    private String username;//登录名
    private String password;//密码
    private String realname;//真实姓名
    private Integer usertypeid;//用户类别标识
    // 1 - 挂号人员
    // 2 - 门诊医生
    // 3 - 医技医生
    // 4 - 药房人员
    // 5 - 财务人员
    // 6 - 行政人员

    private Integer doctitleid;//医生职称。
    // 1-主任医师
    // 2-副主任医师
    // 3-主治医师
    // 4-住院医师

    private Integer isscheduling;//是否排班 1-是 0-否
    private Integer deptid;//所在科室主键ID
    private Integer registid;//挂号级别主键ID
    private String idnumber;//身份证号
}
```



### 2. 科室 Department

```java
public class Department {
    private Integer id;//科室主键ID,
    private String deptname;//科室名称
    private String deptcategory;//科室分类
    private Integer depttypeid;//科室类型标识
    private String deptcode;//即科室编码
}
```



### 3. 患者 Patient

```java
public class Patient {
    private Integer id;//患者主键ID
    private String name;//患者姓名
    private String idnumber;//患者身份证号
    private String phone;//患者手机号
    private String loginname;//患者登陆名
    private String password;//患者密码
}
```



### 4. 疾病 Disease

```java
public class Disease {
    private Integer id; //疾病主键ID
    private String diseasecode; //疾病助记编码
    private String diseasename; //疾病名称
    private String diseaseicd; //疾病国际ICD编码
    private String diseasetype; //疾病所属分类
}
```



### 5. 挂号级别 RegisterLevel

```JAVA
//挂号级别
public class RegisterLevel {
    private Integer id;//挂号级别ID，即挂号级别编码
    private String registname;//挂号级别名称
    //如普通号、专家号、急诊号等。
    
    private BigDecimal registfee;//挂号级别费用
}
```



### 6. 排班 Scheduling

```java
/**
 * 排班
 */
public class Scheduling {
    private Integer id;//本次排班主键ID
    private Date scheddate;//本次排班日期
    private Integer deptid;//排班的部门主键ID
    private Integer userid;//排班的医生的用户主键ID
    private Integer noon;//午别
    //1 - 凌晨
    //2 - 早上
    //3 - 下午
    //4 - 晚上

    private Integer registquota;//该医生在本次排班的挂号数量限额
    private Integer state;//排班的状态
    //1 - 已过期
    //2 - 正在进行中
    //3 - 未进行
}
```



### 7.  结算类型 SettleCategory

```java
/**
 * 结算类型
 */
public class SettleCategory {
    private Integer id;//结算类型主键ID
    private String settlename;//结算类型名称
    //如包括自费、医保、新农合等。
}
```





