# TODO LIST



To 杨洋

By Paul

- [ ] PatientCostsMapper.selectByRegisterId(Integer RegisterId) 为什么只返回一个 PatientCosts ？难道一个挂号对应多个发票明细吗？

- [ ] 確認一下， CostPo selectCostInvoice(CostPo costPo) 有考虑红冲和作废的发票吗？CostPo selectCostRegister(CostPo costPo) 有考虑挂了号，但是没有就诊的病人吗？

- [ ] 需要新增多条件查询的方法 CheckApplyMapper.selectByConditions(...)

  参数：

  ```java
  Integer userId;//开立医生的医院员工主键ID
  Integer state;//检查（检验或处置）状态
  ```

  返回：CheckApply 列表

  说明：如果某一个参数为null，表示该条件不设限。如若state 的值为 null，则表示所有的状态都符合条件。下同。可能以后还会需要多条件查询的方法，也是同理。目前，这个多条件查询方法和以下列出的几个多条件查询方法是必须用到的。虽然也想到一些其他的，但是他们有就最好，没有也行，所以就先暂时不增加你的工作量了，看前端的意思吧，就再说吧。

- [ ] 需要新增多条件查询的方法 RegisterMapper.selectByConditions(...)

  参数：

  ```java
  Date fromVisitDate;//预约看诊日期范围下限
  //standard forms ("yyyy-MM-dd")
  Integer fromNoon;//预约看诊午别范围下限
  //1 - 凌晨
  //2 - 早上
  //3 - 下午
  //4 - 晚上
  Date toVisitDate;//预约看诊日期范围上限
  //standard forms ("yyyy-MM-dd")
  Integer toNoon;//预约看诊午别范围上限
  //1 - 凌晨
  //2 - 早上
  //3 - 下午
  //4 - 晚上
  Integer deptid;//看诊科室主键ID
  Integer userid;//医生的医院员工主键ID
  Integer registid;//挂号类型主键ID
  Integer settleid;//结算类型主键ID
  Integer isbook;//是否需要病历本
  //1-需要
  //0-不需要
  Integer registerid;//挂号员的医院员工主键ID
  Integer visitstate;//看诊状态
  //0-未看诊
  //1-已看诊或正在看诊
  Integer patientid;//患者主键ID
  ```

  返回：Register 列表

  说明：如果日期下限和午别下限为null，说明不设置下限。上限同理。

- [ ] 需要新增多条件查询的方法 PrescriptionMapper.selectByConditions( ... )

  ```java
  Integer userId;//开立医生的医院员工主键ID
  Integer prescriptionState;//处方状态
  //1 - 编辑中
  //2 - 已确认并发出，未收费。
  //3 - 已收费，未取药。
  //4 - 已取药。
  ```

  返回：Prescription 列表

- [ ] ExpenseClassMapper.updateByPrimaryKey() 報錯：

  org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named 'ExpCode' in 'class com.njuhis.his.model.ExpenseClass'

- [ ] 需要新增多条件查询的方法 SchedulingMapper.selectByConditions(...)

  ```java
  Date fromScheduleDate;//排班日期范围下限
  //standard forms ("yyyy-MM-dd")
  Integer fromNoon;//排班午别范围下限
  //1 - 凌晨
  //2 - 早上
  //3 - 下午
  //4 - 晚上
  Date toScheduleDate;//排班日期范围上限
  //standard forms ("yyyy-MM-dd")
  Integer toNoon;//排班午别范围上限
  //1 - 凌晨
  //2 - 早上
  //3 - 下午
  //4 - 晚上
  Integer deptid;//被排班医生的所属部门主键ID
  Integer userid;//被排班的医生的医院员工主键ID
  Integer state;//排班的状态
  //1 - 已过期
  //2 - 正在进行中
  //3 - 未进行
  ```

  返回：Scheduling 列表

  说明：如果日期下限和午别下限为null，说明不设置下限。上限同理。

- [ ] 缺少expenseClassMapper.updateByPrimaryKey()以及expenseClassMapper.selectByPrimaryKey(id)。

- [ ] CheckDetailedMapper.insert()失敗。估計是UserId和UserId2的名字問題。

- [ ] PrescriptionDetailedMapper.insert() 失敗。

- [ ] RegisterMapper.insert() 的 id 没有自动更新。

- [ ] CheckApplyMapper.insert() 的 id 没有自动更新。

- [ ] InvoiceMapper.insert() 的 id 没有自动更新。

- [x] 统一Mapper的insert()失败会如何？抛出异常or返回特定值？统一Mapper的update()失败会如何？抛出异常or返回特定值？统一Mapper的select()失败后会如何？抛出异常or返回null？select()的话至少我看到一部分是返回null。其他的暂时还不知道。insert()看到的都是抛出异常。其他的暂时还不知道。类似这样的，如果失败的行为没有统一的话，希望能够统一。

- [ ] Register 类中的 diagnosisList 的意义是什么？diagnosisList 难道不应该是在 MedicalRecord 类中的吗？

- [ ] 有联立查询的类（比如包含了明细列表的类）会有「联立保存」吗？保存上应该是怎样的一种方案？分开保存吗？是在业务逻辑层实现还是在数据层实现？

- [ ] PrescriptionMapper.java 中的 「Prescription selectByRegisterId(Integer RegisterID);//通过病例id查询到处方明细」，RegisterId 到底是病历主键ID还是挂号主键ID？

- [ ] InvoiceMapper 的 selectByPrimaryId() 似乎没有联立查询？不知是我的程序故障还是你没有写。如果没写的话，希望新增一个selectJoinByPrimaryId()，或直接把selectByPrimaryId() 升级为联立查询。其他相关的 Mapper 同理。

- [ ] PatientMapper 需要 selectByPrimaryId()和updateByPrimaryId()









To Paul

By Paul

- [ ] 
- [ ] 
- [ ] 
- [ ] 



