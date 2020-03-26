# 实体模型文档

By Paul

### 1. 用户 User

```java
public class User {
    private Integer id;//用戶主键ID
    private String username;//登录名
    private String password;//密码
    private String realname;//真实姓名
    private Integer usertypeid;//用户类别标识
    //1 - 挂号人员
    //2 - 门诊医生
    //3 - 医技医生
    //4 - 药房人员
    //5 - 财务人员
    //6 - 行政人员
    private Integer doctitleid;
    private Integer isscheduling;//是否排班 1-是 0-否
    private Integer deptid;//所在科室主键ID
    private Integer registid;//挂号级别主键ID
    private Integer delmark;//删除标记 1-是 0-否
    private String idnumber;//身份证号
}
```



### 2. 科室 Department

```java
public class Department {
    private Integer id;//科室主键ID
    private String deptcode;//科室编码
    private String deptname;//科室名称
    private String deptcategory;//科室分类
    private Integer depttypeid;//科室类型标识
    private Integer delmark;//删除标记 1-是 0-否
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
    private Integer delmark; //删除标记 1-是 0-否
}
```

