# 实体模型文档

To 全体成员

By Paul

[TOC]



## 注意事项⚠️‼️

- 此文档用于说明和解释实体模型。前后端应根据此文档编写实体模型。尤其是其中的**变量名必须要严格统一**，注意大小写敏感。

- 文档作为前后端的最重要的协议文件，会不断更新与完善，请密切关注。

- -此文档未经本人允许，任何人都不要修改。有问题请与我联系。

- **如果发现本文档中的一些变量名、类名和类的设计很反人类很奇葩很不规范，不要问我为什么。因为以下所有变量名、类名和类的设计都不是我写的！不是我写的！不是我写的！更重要的是它们已经无法修改。**

- 用 IntelliJ IDEA 打开此项目时，请确保安装有 lombok 插件。

- 強烈推荐使用 Typora （或其他合适的工具） 阅读此文档，因直接在 IntelliJ IDEA 打开的显示效果不尽人意，同时不保证在 IntelliJ IDEA 的显示效果。其他 Markdown 文件同理。

- 如果有时候服务器返回前端的实体模型包含了本文档所罗列的以外的变量，请把它们忽略，当它们不存在。这是数据库侧的遗留问题。

- 强烈建议大家研读本文档，厘清文档中的实体模型的逻辑关系、包含关系、关联关系等等。可以结合 PDM 图来理解。

- 强烈建议前端同学注意那些反人类的、奇葩的、不规范的变量名，千万不要出错！比如说：

  - `id `是主键，而`User`类中`idnumber`  是身份证号码，不是主键。千万注意！
  - `User`类中的`registerLevelId`和`Register`类中的`registid`指的都是挂号类型主键ID。`MedicalRecord`类中的`registerId`和`PatientCosts`类中的`registerid`都是挂号主键ID，注意大小写的区别。`Register`类中的`registerid`指的是挂号员的医院员工主键ID，并不是挂号主键ID，千万不要和前面的搞混了！
  - 即使是同一个东西，同一个拼写，也有可能有不同的写法。比如`Prescription`类中的`medicalId`和Diagnosis中的`medicalid`。比如`Prescription`类中的`userId`和`Register`中的`userid`。比如 `Invoice` 类中的 `creationtime` 和 `CheckApply` 类中的 `creationTime`。等等。千万注意。
  - 还有可能有拼写的错误。"生日"是`birthdate`而不是birthday，"用法"是`useage`而不是usage。千万注意。
  - 有一些带有id字眼的变量名并不是主键ID。如`User`类中的`usertypeid`和`doctitleid`都不是主键ID。`Department`类中的`depttypeid`也不是主键ID。等等还有很多。千万注意。
  - 还有一些变量名或类名和实际的意义差别很大。如 `Invoice` 类中的 `creationtime` 并不是指创建时间，而是指生效时间。`CheckApply` 类不仅包括检查检验，还包括了处置，不仅包括申请，还包括结果。`CheckApply` 类中的`objective`不仅包括目的，还包括要求。`CheckDetailed`中的`position`和"位置"没有什么关系，它指的是"目的和要求"。`MedicalRecord`类的`medicalReadme`指的是"主诉"，等等。
  - 有些作用完全一样、但是长得很相似的东西，实际上却分成了两个东西。如`Prescription`类持有`invoiceId`和`PatientCosts`类持有`invoiceid`，都是持有发票主键ID，而`CheckApply`却持有`invoiceNumber`发票编码。`Prescription`类和`CheckApply`类持有`medicalId`病历主键ID，而`Register`持有的却是`casenumber`病历编码。
  - 等等。请自行千万注意。

  



## 统一规定

- 一切 Date 类型的数据的标准格式：`"yyyy-MM-dd"`
- 一切变量名以 time 结尾的变量都表示时间的**毫秒数**。从 1970 年 1 月 1 日 00:00:00 GMT 开始计算。
- 这个项目从来就没有"病例"这个概念，只有"病历"这个概念。语言上需要注意。





## 实体模型

### 1. User - 医院员工 Worker

```java
//医院员工
public class User {
    private Integer id;//医院员工主键ID
    private String username;//登录名
    private String password;//密码
    private String realname;//真实姓名
    private Integer usertypeid;//医院员工类型
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

    private Integer isscheduling;//医生是否被排班 1-是 0-否
    private Integer deptid;//医生所在科室主键ID
    private Integer registerLevelId;//医生挂号类型主键ID
    private String idnumber;//身份证号
    
    private List<Scheduling> schedulingList; //排班的列表
}
```



### 2. Department - 科室 Department

```java
//科室
public class Department {
    private Integer id;//科室主键ID
    private String deptname;//科室名称
    private String deptcategory;//科室分类
    private Integer depttypeid;//科室类型
    private String deptcode;//科室编码
}
```



### 3. Patient - 患者 Patient

```java
//患者
public class Patient {
    private Integer id;//患者主键ID
    private String name;//患者真实姓名
    private String idnumber;//患者身份证号
    private String phone;//患者手机号
    private String loginname;//患者登陆名
    private String password;//患者密码
}
```



### 4. Disease - 疾病 Disease

```java
//疾病
public class Disease {
    private Integer id; //疾病主键ID
    private String diseasecode; //疾病助记编码
    private String diseasename; //疾病名称
    private String diseaseicd; //疾病国际ICD编码
    private String diseasetype; //疾病类型
}
```



### 5. RegisterLevel - 挂号类型 Registration Type

```JAVA
//挂号类型
public class RegisterLevel {
    private Integer id;//挂号类型主键ID，即挂号级别编码
    private String registname;//挂号类型名称
    //如普通号、专家号、急诊号等。
    private BigDecimal registfee;//挂号类型价格
}
```



### 6. Scheduling - 排班 Schedule

```java
//排班
public class Scheduling {
    private Integer id;//排班主键ID
    private Date scheddate;//排班日期
    private Integer deptid;//被排班医生的所属部门主键ID
    private Integer userid;//被排班的医生的医院员工主键ID
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
    private User user; //被排班的医生
    private Department department;////被排班医生的所属部门
}
```



### 7. SettleCategory - 结算类型 Settlement Type

```java
//结算类型
public class SettleCategory {
    private Integer id;//结算类型主键ID
    private String settlename;//结算类型名称
    //如包括自费、医保、新农合等。
}
```





### 8. Register - 挂号 Registration

```java
//挂号
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
    private String casenumber;//病历编码。
    private Date visitdate;//预约看诊日期
    //standard forms ("yyyy-MM-dd")
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
    //1-已看诊或正在看诊
    private Integer patientid;//患者主键ID

}
```



### 9. MedicalRecord - 病历 Medical Record 

```java
//病历
public class MedicalRecord {
    private Integer id;//病历主键ID
    private Integer registerId;//挂号主键ID
    private String medicalReadme;//主诉
    private String medicalPresent;//现病史
    private String presentTreat;//现病治疗情况
    private String medicalHistory;//既往史
    private String medicalAllergy;//过敏史
    private String medicalPhysique;//体格检查
    private String medicalDiagnosis;//诊断结果
    private String medicalHandling;//处理意见
    private Integer caseState;//病历状态
    // 1 - 已预约
    // 2 - 进行中
    // 3 - 已完成/诊毕；

    private String caseNumber;//病历编码
}
```

### 10. Drugs - 药品 Drug

```JAVA
//药品
public class Drugs {
    private Integer id;//药品主键ID，即药品编码
    private String drugsName;//药品名称
    private String drugsFormat;//药品规格
    private String drugsUnit;//包装单位
    private String manufacturer;//药品生产厂家
    private String drugsDosage;//药品剂型
    private String drugsType;//药品类型
    private BigDecimal drugsPrice;//药品价格
    private String mnemonicCode;//拼音助记码
    private Date creationDate;//创建日期
    private Date lastUpdateDate;//最后修改日期
}
```



### 11. Prescription - 处方 Prescription 

```java
//处方
public class Prescription {
    private Integer id;//处方主键ID
    private Integer medicalId;//病历主键ID
    private Integer userId;//开立医生的医院员工主键ID
    private String prescriptionName;//处方名称
    private Integer prescriptionState;//处方状态
    //1 - 编辑中
    //2 - 已确认并发出，未收费。
    //3 - 已收费，未取药。
    //4 - 已取药。
    private Long prescriptionTime;//生效时间。以医生确认发出的时间为准。毫秒数。
    private String invoiceId;//发票主键ID
}
```



### 12. PrescriptionDetailed - 处方明细 Prescription Detail

```java
//处方明细
public class PrescriptionDetailed {
    private Integer id;//处方明细主键ID
    private Integer prescriptionid;//处方主键ID
    private Integer drugsid;//药品主键ID
    private String useage;//用法
    private String dosage;//用量
    private String frequency;//频次
    private BigDecimal price;//开立处方时药品的单价。
    // 主要是为了防止药品价格变动，所以留下记录。
    private Integer quantity;//数量
  
}
```



### 13. CheckApply - 检查（检验或处置）Examination (Test or Disposal) 

```java
//检查（检验或处置）
//这个类是个巨无霸，耦合了非常多的业务。包括检查Examination、检验Test和处置Disposal
public class CheckApply {
    private Integer id;//检查（检验或处置）主键ID
    private Integer medicalId;//病历主键ID
    private Long creationTime; //生效时间。以医生确认发出的时间为准。毫秒数。
    private BigDecimal totalSum; //总金额。自动根据检查（检验或处置）明细计算。
    private String objective; //目的和要求
    private Integer userId;//开立医生的医院员工主键ID
    private Integer state;//检查（检验或处置）状态
    //1 - 编辑中
    //2 - 已开立并发出，未收费
    //3 - 已收费，未检查（检验或处置）
    //4 - 正在检查（检验或处置）或等待结果
    //5 - 检查（检验或处置）已完成，结果已出
    private String invoiceNumber;//发票编码
```

### 14. FmedItem - 非药品项目 Non-drug Item

```java
//非药品项目
public class FmedItem {
    private Integer id;//非药品项目主键ID
    private String itemname; //非药品项目名稱
    private String format;//规格
    private BigDecimal price;//价格
    private Integer expclassid;//费用类型主键ID
    private Integer deptid;//执行科室主键ID
    private String itemcode;//非药品收费编码
}
```



### 15. ExpenseClass - 费用类型 Expense Type 

```java
//费用类型
public class ExpenseClass {
    private Integer id;//费用类型主键ID
    private String expname;//费用类型名称
    private String expcode;//费用类型编码
}
```



### 16. Diagnosis - 诊断 Diagnosis

```java
//诊断
public class Diagnosis {
    private Integer id;//诊断主键ID
    private Integer medicalid;//病历主键ID
    private Integer diseaseid;//疾病主键ID

}
```

  ### 17. Invoice - 发票 Invoice 

```java
//发票
public class Invoice {
    private Integer id;//发票ID
    private String invoicenum;//发票编码
    private BigDecimal money;//发票金额
    private Integer state;//发票状态
    // 1 - 未开出
    // 2 - 已开出，正常状态
    // 3 - 已作废
    // 4 - 此发票作为红冲
    private Long creationtime;// 生效时间。以确认开立的时间为准。毫秒数。
    private Integer userid;//开立人员主键ID
    private Integer dailystate;//日结审核状态
    // 1 - 未日结审核
    // 2 - 已日结审核
    private List<PatientCosts> patientCostsList; //发票明细的列表
}
```



### 18. PatientCosts - 发票明细 Invoice Detail 

```java
//发票明细
public class PatientCosts {
    private Integer id;//发票明细主键ID
    private Integer invoiceid;//发票主键ID
    private Integer registerid;//挂号主键ID
    private String name;//名称
    private BigDecimal price;//价格
    private String deptid;//执行科室主键ID
    private Integer state;//状态
    // 1 - 未交费
    // 2 - 已交费
}
```





### 19. CheckDetailed - 检验（检验或处置）明细  Examination (Test or Disposal) Detail 

```java
//检验检查处置明细
public class CheckDetailed {
    private Integer id; //检验检查处置明细主键ID
    private Integer checkappid; //检验检查处置主键ID
    private Integer checkprojid;//检验检查处置项目（属于非药品项目）主键ID
    private Integer deptid;//执行科室主键ID
    private String position;//检验检查处置明细目的和要求
    private Integer state;//检验检查处置明细状态
    // 1 - 等待检验检查处置
    // 2 - 检验检查处置中
    // 3 - 检验检查处置完成，结果未出
    // 4 - 结果已出
    private BigDecimal price; //价格
    private Integer identification;//检验检查处置明细类型
    // 1 - 检查项
    // 2 - 检验项
    // 3 - 处置项
    private Long inspecttime;//此明细实际检验检查处置时间
    private String result;//此明细的检验检查处置结果
    private Integer resulttime;//此明细出检验检查处置结果的时间。毫秒数。
    private Integer operatorid;//此明细的检验检查处置人员的医院员工主键ID
    private Integer entryclerkid;//此明细的结果录入人员的医院员工主键ID
}
```



### 20. ConstantType - 常数类型 Constant Type

```java
//常数类型
public class ConstantType {
    private Integer id; //常数类型主键ID
    private String constanttypecode;//常数类型编码
    private String constanttypename;//常数类型名称
}
```



### 21. ConstantItem - 常数项 Constant Item

```java
//常数项
public class ConstantItem {
    private Integer id;//常数项主键ID
    private Integer constanttypeid;//常数类型主键ID
    private String constantcode;//常数项编码
    private String constantname;//常数项名称
}
```

