# 实体模型文档

### 1. 医生 User

```java
public class User {
    private Integer id;//用户
    private String username;
    private String password;//密码
    private String realname;//真实姓名
    private Integer usertypeid;//用户类别
    //1 - 挂号人员
    //2 - 门诊医生
    //3 - 医技医生
    //4 - 药房人员
    //5 - 财务人员
    //6 - 行政人员
    private Integer doctitleid;
    private Integer isscheduling;
    private Integer deptid;
    private Integer registid;
    private Integer delmark;
    private String idnumber;
}
```

