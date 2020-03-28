by Paul

有不懂得地方或者认为我写错的地方或有其他建议请及时和我联系。

（ 话说你应该知道 IJ 有 refactor 的功能吧 orz，就是在变量名那里右键->refactor->rename，可以一下子改掉使用在各个地方的该变量名。）



另外，之前说的Time 应该指的是秒数而不是毫秒数。如果是毫秒数的话Integer就爆了。



### 1. User (Worker)

| 原名            | 新名               | 解释                                                         |
| --------------- | ------------------ | ------------------------------------------------------------ |
| 类名 User       | Worker             | User 概念上包括员工和病人，Worker 只指医院员工。显然后者更准确。 |
| realname        | realName           |                                                              |
| usertypeid      | workerType         | 不涉及主键，不使用ID一词。                                   |
| doctitleid      | doctorTitle        | 不涉及主键，不使用ID一词。                                   |
| isscheduling    | isScheduled        | 是否**被**排班。被动。                                       |
| deptid          | departmentId       | 不要一时缩写，一时全写(如Department类名)。统一写完整了。写完整并不会增加打字时间，因为有IDE快捷辅助提示，反而看起来清楚清晰很多。 |
| registerLevelId | registrationTypeId | 见 RegisterLevel(RegistrationType) 类。                      |
| idnumber        | idCardNumber       | 身份证全称 idCard。把身份证idCard和主键id区别开来。不然容易弄混，别人以为idnumber是主键id。 |
| delmark         | isDeleted          |                                                              |





### 2. Drugs (Drug)

| 原名         | 新名          | 解释                                                         |
| ------------ | ------------- | ------------------------------------------------------------ |
| 类名 Drugs   | Drug          | 统一不加复数s。                                              |
| drugsName    | name          | 统一不重复一遍自身类名！！！！重复一遍自身类名太啰嗦啦！     |
| drugsFormat  | specification | format是格式的意思。specification 才是规格。推荐医学英文词典：<https://www.letpub.com.cn/index.php?page=med_english> |
| drugsUnit    | unit          |                                                              |
| drugsDosage  | dosageForm    | 剂型                                                         |
| drugsType    | type          | 类型                                                         |
| drugsPrice   | price         | 统一为 price。不要一时 price，一时 类名+price。              |
| mnemonicCode | code          | 统一为code。不要一时 code，一时类名+code，一时mnemonicCode。 |
| delmark      | isDeleted     |                                                              |
| drugsCode    | 无            | 无用。可删。                                                 |

### 



### 3. Diagnosispkm (Diagnosis)

| 原名              | 新名            | 解释                         |
| ----------------- | --------------- | ---------------------------- |
| 类名 Diagnosispkm | Diagnosis       | 不懂pkm是什么。              |
| medicalid         | medicalRecordId | 病历 medical record 写全了。 |
| drugid            | diseaseId       | 是疾病。                     |
| state             | 无              | 无用。可删。                 |
|                   |                 |                              |
|                   |                 |                              |
|                   |                 |                              |
|                   |                 |                              |
|                   |                 |                              |





### 4. Register (Registration)



| 原名            | 新名               | 解释                                                         |
| --------------- | ------------------ | ------------------------------------------------------------ |
| 类名 Register   | Registration       | Register 是挂号动词，Registration 是挂号名词。类名当然要用名词了。 |
| realname        | realName           |                                                              |
| idnumber        | idCardNumber       |                                                              |
| birthdate       | birthday           | 生日的英文 birthday                                          |
| homeaddress     | homeAddress        |                                                              |
| visitdate       | appointmentDate    | 预约日期。他什么时候实际去visit我不管。这里只是预约appointment。 |
| noon            | partOfDay          | noon是正午。                                                 |
| patientid       | patientId          |                                                              |
| deptid          | departmentId       |                                                              |
| userid          | doctorId           | 需要写清楚是医生的id，不然谁知道user指的是谁？医生？病人？挂号员？ |
| settleid        | settlementTypeId   |                                                              |
| isBook          | needBook           | 是否需要病历本                                               |
| registertime    | registrationTime   |                                                              |
| registerid      | registrarId        | 挂号员英文 registrar                                         |
| registerLevelId | registrationTypeId |                                                              |
| visitstate      | state              |                                                              |
| 无              | medicalRecordId    | 新增病历主键Id。取代病历编号。                               |
| casenumber      | 无                 | 应删去。病历编号被病历主键id取代。其他地方都是病历主键id，这里为何要搞特殊，要用病历编号？统一使用病历主键id。 |
| agetype         | 无                 | 我没搞懂有什么用。如果你知道它有什么用，请告诉我，保留它且改成 ageType。如果没用则删去。 |



### 4. Department 

| 原名         | 新名      | 解释                                                     |
| ------------ | --------- | -------------------------------------------------------- |
| deptname     | name      | 统一不重复一遍自身类名！！！！重复一遍自身类名太啰嗦啦！ |
| deptcategory | category  |                                                          |
| depttypeid   | type      | 不涉及主键ID的，统一不使用ID字眼。                       |
| deptcode     | code      |                                                          |
| delmark      | isDeleted |                                                          |
|              |           |                                                          |
|              |           |                                                          |
|              |           |                                                          |
|              |           |                                                          |





### 6. Disease

| 原名        | 新名      | 解释                                                     |
| ----------- | --------- | -------------------------------------------------------- |
| diseasecode | code      | 统一不重复一遍自身类名！！！！重复一遍自身类名太啰嗦啦！ |
| diseasename | name      |                                                          |
| diseaseicd  | icd       |                                                          |
| diseasetype | type      |                                                          |
| delmark     | isDeleted |                                                          |
|             |           |                                                          |
|             |           |                                                          |
|             |           |                                                          |
|             |           |                                                          |





### 7. MedicalRecord

| 原名             | 新名                    | 解释                                                         |
| ---------------- | ----------------------- | ------------------------------------------------------------ |
| registerId       | registrationId          |                                                              |
| medicalReadme    | chiefComplaint          | 主诉术语。Readme。。。。是认真的吗                           |
| medicalPresent   | presentIllnessHistory   | 现病史术语                                                   |
| presentTreat     | presentIllnessTreatment | 术语。小提示：在IJ中，如果变量名是presentIllnessTreatment，你只需要打字输入pit(首字母)，IDE 的辅助提示的第一条就是presentIllnessTreatment。所以变量名看似长，其实打起来很方便。 |
| medicalHistory   | pastMedicalHistory      | 既往史术语                                                   |
| medicalAllergy   | allergyHistory          | 过敏史术语                                                   |
| medicalPhysique  | physicalExamination     | 体格检查就是体检呐                                           |
| medicalDiagnosis | diagnosticResult        | 诊断结果术语                                                 |
| medicalHandling  | treatmentSuggestion     | 处理意见术语                                                 |
| caseState        | state                   | 状态一律统一为 state。不要一时state，一时类名+state。况且case是病例，不是病历。 |
| delmark          | isDeleted               |                                                              |
| caseNumber       | 无                      | 无用。可删。                                                 |
|                  |                         |                                                              |
|                  |                         |                                                              |
|                  |                         |                                                              |





### 8. SettleCategory (SettlementType)

| 原名                | 新名           | 解释                                                         |
| ------------------- | -------------- | ------------------------------------------------------------ |
| 类名 SettleCategory | SettlementType | settle是动词，settlement是名词。关于"类型、类别"竟然同时出现了category(SettleCategory), type(ConstantType), class(ExpenseClass) 三种写法。一律全部统一为 Type！！ |
| settlename          | name           |                                                              |
| delmark             | isDeleted      |                                                              |
| isdefault           | 无             | 无用。可删。                                                 |
| sequence            | 无             | 无用。可删。                                                 |
| settlecode          | 无             | 无用。可删。                                                 |
|                     |                |                                                              |
|                     |                |                                                              |
|                     |                |                                                              |
|                     |                |                                                              |







###  9. Scheduling (Schedule)



| 原名            | 新名             | 解释                                                         |
| --------------- | ---------------- | ------------------------------------------------------------ |
| 类名 Scheduling | Schedule         | Schedule本身就有名词的意思                                   |
| scheddate       | date             | 统一不重复一遍自身类名！！！！重复一遍自身类名太啰嗦啦！     |
| deptid          | departmentId     | 不要一时缩写，一时全写(如Department类名)。统一写完整了。写完整并不会增加打字时间，因为有IDE快捷辅助提示，反而看起来清楚清晰很多。 |
| userid          | doctorId         | 这里的user指的就是医生。写明确。否则会认为user是排班员。     |
| noon            | partOfDay        | noon是正午。                                                 |
| registquota     | registationQuota | regist不是一个单词。                                         |
|                 |                  |                                                              |
|                 |                  |                                                              |
|                 |                  |                                                              |





### 10. Prescription

| 原名              | 新名            | 解释                                                         |
| ----------------- | --------------- | ------------------------------------------------------------ |
| medicalId         | medicalRecordId | 病历的单词写完整。                                           |
| userId            | doctorId        | 这里的user指的就是医生。写明确。                             |
| prescriptionName  | name            |                                                              |
| prescriptionState | state           |                                                              |
| prescriptionTime  | validationTime  | validationTime生效时间。一个处方创建之后进入草稿编辑状态，确认后才正式生效。这里指生效时间而不是创建的时间。 |
| delmark           | isDeleted       |                                                              |
|                   |                 |                                                              |
|                   |                 |                                                              |
|                   |                 |                                                              |





### 11. PrescriptionDetailed (PrescriptionDetail)

| 原名                      | 新名               | 解释               |
| ------------------------- | ------------------ | ------------------ |
| 类名 PrescriptionDetailed | PrescriptionDetail | Detail 是名词      |
| prescriptionid            | prescriptionId     |                    |
| drugsid                   | drugId             |                    |
| useage                    | usage              | 拼写错误           |
| 无                        | quantity           | 新增数量这个变量。 |
|                           |                    |                    |
|                           |                    |                    |
|                           |                    |                    |
|                           |                    |                    |







###  12. Invoice



| 原名         | 新名             | 解释                                                         |
| ------------ | ---------------- | ------------------------------------------------------------ |
| invoicenum   | code             | 编号统一用code这个单词。不要一时用num，一时用number，一时用code。。。 |
| money        | sum              | 金额sum。术语。                                              |
| creationtime | validationTime   | validationTime生效时间。一个发票创建之后进入草稿编辑状态，确认后才正式生效。这里指生效时间而不是创建的时间。 |
| userid       | tollCollectorId  | 收费员。                                                     |
| dailystate   | dailyReviewState | 日结审核状态英文。                                           |
|              |                  |                                                              |
|              |                  |                                                              |
|              |                  |                                                              |
|              |                  |                                                              |







### 13. Patient

| 原名      | 新名         | 解释                                     |
| --------- | ------------ | ---------------------------------------- |
| name      | realName     | 和 Worker 和 Registration 的realName统一 |
| idnumber  | idCardNumber | 身份证全称 idCard                        |
| loginname | username     | 和 Worker 的username 统一                |
|           |              |                                          |
|           |              |                                          |
|           |              |                                          |
|           |              |                                          |
|           |              |                                          |
|           |              |                                          |





### 14. RegisterLevel (RegistrationType)

| 原名        | 新名      | 解释                                   |
| ----------- | --------- | -------------------------------------- |
| registname  | name      |                                        |
| registfee   | price     | 统一为 price。不要一时price，一时fee。 |
| delmark     | isDeleted |                                        |
| registquota | 无        | 无用。可删。                           |
| isdefault   | 无        | 无用。可删。                           |
| sequence    | 无        | 无用。可删。                           |
| registcode  | 无        | 无用。可删。                           |
|             |           |                                        |
|             |           |                                        |





### 14. ExpenseClass (ExpenseType)

| 原名               | 新名        | 解释                                                         |
| ------------------ | ----------- | ------------------------------------------------------------ |
| 类名  ExpenseClass | ExpenseType | 关于"类型、类别"竟然同时出现了category(SettleCategory), type(ConstantType), class(ExpenseClass) 三种写法。一律全部统一为 Type！！ |
| expname            | name        |                                                              |
| delmark            | isDeleted   |                                                              |
| expcode            | code        |                                                              |
|                    |             |                                                              |
|                    |             |                                                              |
|                    |             |                                                              |
|                    |             |                                                              |
|                    |             |                                                              |





### 16. CheckApply (ExaminationTestDisposal)

| 原名            | 新名                    | 解释                                                         |
| --------------- | ----------------------- | ------------------------------------------------------------ |
| 类名 CheckApply | ExaminationTestDisposal | 这个类是个巨无霸，耦合了非常多的业务。包括检查Examination、检验Test和处置Disposal。另外，这个类不单包括申请，还包括了结果，故删去Apply(Application)字眼。 |
| medicalId       | medicalRecordId         |                                                              |
| totalSum        | sum                     | 统一为sum。不用一时money，一时totalSum。                     |
| objective       | purposeAndRequirement   | 统一为purposeAndRequirement，不要一时position，一时objective。 |
| userId          | doctorId                | 具体为医生的主键ID。                                         |
| delmark         | isDeleted               |                                                              |
| name            | 无                      | 无用。可删。这个要名字干什么。。。                           |
| 无              | invoiceId               | 新增。其他地方引用的都是invoiceId 发票主键Id，这里不要搞特殊用发票编码。统一用invoiceId。 |
| invoiceNumber   | 无                      | 无用。可删。                                                 |
| creationTime    | validationTime          | validationTime生效时间。一个检查检验处置创建之后进入草稿编辑状态，确认后才正式生效。这里指生效时间而不是创建的时间。 |



### 17. CheckDetailed (ExaminationTestDisposalDetail)



| 原名               | 新名                          | 解释                                                         |
| ------------------ | ----------------------------- | ------------------------------------------------------------ |
| 类名 CheckDetailed | ExaminationTestDisposalDetail | 和ExaminationTestDisposal类统一。                            |
| checkappid         | examinationTestDisposalId     |                                                              |
| checkprojid        | nonDrugItemId                 |                                                              |
| deptid             | departmentId                  |                                                              |
| position           | purposeAndRequirement         | 统一为purposeAndRequirement，不要一时position，一时objective。position不是位置的意思么？ |
| identification     | type                          | 统一为type。不要一时 identification，一时type。              |
| inspecttime        | operationTime                 | 因为有检查、检验和处置，故不用inspect一词。而用operationTime，操作时间。 |
| resulttime         | resultTime                    |                                                              |
| userid2            | operatorId                    | 操作员主键Id。用数字后缀命名这是大忌。                       |
| userid             | entryClerkId                  | 录入员主键Id。                                               |
| delmark            | isDeleted                     |                                                              |
| creationtime       | 无                            | 无用。可删。                                                 |





### 18. FmedItem (NonDrugItem)

| 原名          | 新名          | 解释               |
| ------------- | ------------- | ------------------ |
| 类名 FmedItem | NonDrugItem   | 不懂Fmed是什么东东 |
| itemname      | name          |                    |
| format        | specification |                    |
| expclassid    | expenseTypeId |                    |
| deptid        | departmentId  |                    |
| itemcode      | code          |                    |
| delmark       | isDeleted     |                    |
|               |               |                    |
|               |               |                    |





### 19. PatientCosts (InvoiceDetail)

| 原名              | 新名           | 解释                                                         |
| ----------------- | -------------- | ------------------------------------------------------------ |
| 类名 PatientCosts | InvoiceDetail  | 仿照 Prescription 与 PrescriptionDetail，ExaminationTestDisposal 与 ExaminationTestDisposalDetail 的样式。 |
| invoiceid         | invoiceId      |                                                              |
| registerid        | registrationId |                                                              |
| deptid            | departmentId   |                                                              |
| delmark           | isDeleted      |                                                              |
|                   |                |                                                              |
|                   |                |                                                              |
|                   |                |                                                              |
|                   |                |                                                              |



### 20. ConstantType

| 原名             | 新名      | 解释 |
| ---------------- | --------- | ---- |
| constanttypecode | code      |      |
| constanttypename | name      |      |
| delmark          | isDeleted |      |
|                  |           |      |
|                  |           |      |
|                  |           |      |
|                  |           |      |
|                  |           |      |
|                  |           |      |





### 21. ConstantItem

| 原名           | 新名           | 解释 |
| -------------- | -------------- | ---- |
| constanttypeid | constantTypeId |      |
| constantname   | name           |      |
| constantcode   | code           |      |
| delmark        | isDeleted      |      |
|                |                |      |
|                |                |      |
|                |                |      |
|                |                |      |
|                |                |      |







### 12. CheckResult

无用。整个类都可以删去。

