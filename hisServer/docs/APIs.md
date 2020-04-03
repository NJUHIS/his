# APIs 文挡

To 全体成员

By Paul 

⚠️‼️注意事项：

- 此文档用于说明和解释 HTTP 请求。前后端应根据此文档调用 HTTP 请求。
- 用 IntelliJ IDEA 打开此项目时，请确保安装有 lombok 插件。
- 強烈推荐使用 Typora （或其他合适的工具） 阅读此文档，因直接在 IntelliJ IDEA 打开的显示效果不尽人意，同时不保证在 IntelliJ IDEA 的显示效果。其他 Markdown 文件同理。
- HTTP 请求示例可以在 hisServer/src/test/java/com/njuhis/his/controller_http_tests 中找到，并可以直接运行。
- 文档作为前后端的最重要的协议文件，会不断更新与完善，请密切关注。
- -此文档未经本人允许，任何人都不要修改。有问题请与我联系。
- 「关键必须字段」列表仅供参考。请**根据实际业务**来判断。



统一规定：

- 鉴于前端使用 axios，服务器返回的如"登录密码错误"、"患者登录名不存在"、"挂号配额已满"等错误的信息在 error.message 中。示例：

  ```javascript
  axios.get('/user', {
      params: {
        ID: 12345
      }
    })
    .then(function (response) {
      console.log(response);
    	//do something
    })
    .catch(function (error) {
      console.log(error.message);
    	//do something
    });
  ```

  axios 文档参考   <http://www.axios-js.com/zh-cn/docs/>>

  

- 一些 HTTP 请求成功后，可能会返回的东西前端不需要，或者不完全需要，那就忽略它即可。服务器尽可能会提供周全的返回，方便调试侦错。比如说更新\保存 update 类的API，如果成功，按道理应该会返回和请求体一样的对象，为的是方便调试侦错，如果没用，请忽略它即可。

- 关于分页功能的需求：由于 PageHelper 是在 MyBatis 查询的时候起作用的，所以有

  - 如果它是由数据层实现的查询（或联立查询），则可以加入分页功能；
  - 如果它是由业务逻辑层实现的查询（或联立查询），则没有分页功能。

  所以前端的同学如果某一个接口需要分页功能的话，请告知我，或直接写在 todo list.md 文件中。我可能需要和数据库层同学进行商榷。







## 1. 基础信息管理 /BasicInformationController

###1.1 获取所有科室 /getAllDepartments

参数：无

返回：科室列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllDepartments HTTP/1.1
Host: localhost:9002
```

HTTP 响应示例：

```json
[
  {
        "id": 1,
        "deptname": "心血管内科",
        "deptcategory": "11",
        "depttypeid": 1,
        "deptcode": "XXGNK"
    },
    {
        "id": 2,
        "deptname": "神经内科",
        "deptcategory": "11",
        "depttypeid": 1,
        "deptcode": "SJNK"
    }
 ]
```



 ### 1.2 新增一名医院员工/addUser

 请求体：主键ID为null的医院员工。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

 返回：注册成功后返回主键ID非null的字段完整的医院员工。

 HTTP 请求示例：

```http
POST /his/BasicInformationController/addUser HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id":null,
    "username": "MyUsername",
    "password": "MyPassword",
    "realname": "MyRealName",
    "usertypeid": 2,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registerLevelId": 1,
    "delmark": 0,
    "idnumber": "3247875"
}
```

 HTTP 响应示例：

```json
{
    "id": 3,
    "username": "MyUsername",
    "password": "MyPassword",
    "realname": "MyRealName",
    "usertypeid": 2,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registerLevelId": 1,
    "idnumber": "3247875"
}
```

### 1.3 根据预约日期获取医院员工（医生）列表 /getUsersBetweenScheduleDates

请求参数：起始日期（毫秒数）`startDate`、结束日期（毫秒数）`endDate`

返回：医院员工的列表



HTTP 请求示例：

```http
GET /his/BasicInformationController/getUsersBetweenScheduleDates?startDate=1&endDate=2 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "username": "ahilla",
        "password": "123qwe",
        "realname": "ahilla",
        "usertypeid": 1,
        "doctitleid": 1,
        "isscheduling": 1,
        "deptid": 3,
        "registerLevelId": 1,
        "idnumber": "11111111111",
        "schedulingList": null
    },
    {
        "id": 2,
        "username": "MyUsername",
        "password": "MyPassword",
        "realname": "MyRealName",
        "usertypeid": 2,
        "doctitleid": 1,
        "isscheduling": 1,
        "deptid": 3,
        "registerLevelId": 1,
        "idnumber": "3247875",
        "schedulingList": null
    }
]
```

备注：逻辑未完善。



### 1.4 根据预约日期获取患者列表 /getPatientsBetweenScheduleDates

请求参数：起始日期（毫秒数）`startDate`、结束日期（毫秒数）`endDate`

返回：患者的列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getPatientsBetweenScheduleDates?startDate=1&endDate=2 HTTP/1.1
Host: localhost:9002


```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "name": "MyName",
        "idnumber": "idnumber23434",
        "phone": "phone234234",
        "loginname": "Myloginname",
        "password": "Mypassword"
    },
    {
        "id": 7,
        "name": "MyName",
        "idnumber": "idnumber23434",
        "phone": "phone234234",
        "loginname": "Myloginname",
        "password": "Mypassword"
    }
]
```

备注：逻辑未完善。



## 2. 个人信息管理 /PersonalInformationController

### 2.1 新增/注册一名患者 /addPatient

请求体：主键ID为null的患者。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：注册成功后返回主键ID非null的字段完整的患者

 HTTP 请求示例：

```http
POST /his/PersonalInformationController/addPatient HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": null,
    "name": "MyName",
    "idnumber": "idnumber23434",
    "phone": "phone234234",
    "loginname": "Myloginname",
    "password": "Mypassword"
}
```

HTTP 响应示例：

```json
{
    "id": 7,
    "name": "MyName",
    "idnumber": "idnumber23434",
    "phone": "phone234234",
    "loginname": "Myloginname",
    "password": "Mypassword"
}
```



### 2.2 通过主键ID获取一个医院员工/addUserById

参数：医院员工的主键ID `id`

返回：医院员工

HTTP 请求示例：

```http
GET /his/PersonalInformationController/getUserById?id=1 HTTP/1.1
Host: localhost:9002

```

HTTP 响应示例：

```json
{
    "id": 1,
    "username": "ahilla",
    "password": "123qwe",
    "realname": "ahilla",
    "usertypeid": 1,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registerLevelId": 1,
    "idnumber": "11111111111"
}
```



## 3. 门诊挂号收费 /RegistrationController

###  3.1 挂号/新增一个挂号 /addRegistration

请求体：一个主键ID为null的挂号。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

关键必须字段：

> patientid
> userid
> registid
> settleid
> registerid

返回：挂号成功后返回主键ID非null的字段完整的挂号。

HTTP 请求示例：

```http
POST /his/RegistrationController/addRegistration HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
  "realname": "MyRealName",	
	"gender": 3,
  "idnumber": 323123123,
  "deptid": 5,
	"visitdate":"2020-12-19",
	"patientid":1,
	"registid":1,
	"registerid":1,
	"settleid":1,
	"userid":1
}
```

HTTP 响应示例：

```json
{
    "id": null,
    "realname": "MyRealName",
    "gender": 3,
    "idnumber": "323123123",
    "birthdate": null,
    "age": null,
    "homeaddress": null,
    "casenumber": null,
    "visitdate": "2020-12-19T00:00:00.000+0000",
    "noon": null,
    "deptid": 5,
    "userid": 1,
    "registid": 1,
    "settleid": 1,
    "isbook": null,
    "registertime": null,
    "registerid": 1,
    "visitstate": null,
    "patientid": 1
}
```

备注：目前返回的挂号id字段有数据的功能还未实现。



### 3.2 新增一张发票 /addInvoice

请求体：主键ID为null的发票。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：添加成功后返回主键ID非null的字段完整的发票。

HTTP 请求示例：

```http
POST /his/RegistrationController/addInvoice HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"userid":1
}
```

HTTP 响应示例：

```json
{
    "id": null,
    "invoicenum": null,
    "money": null,
    "state": null,
    "creationtime": null,
    "userid": 1,
    "dailystate": null,
    "patientCostsList": null
}
```

备注：目前返回的发票id字段有数据的功能还未实现。



### 3.3 通过主键ID获取一个挂号 /getRegistrationById

参数：挂号的主键ID `id`

返回：挂号

HTTP 请求示例：

```http
GET /his/RegistrationController/getRegistrationById?id=1 HTTP/1.1
Host: localhost:9002


```

HTTP 响应示例：

```json
{
    "id": 1,
    "realname": "ahillatty",
    "gender": 1,
    "idnumber": "112222222",
    "birthdate": "2020-01-01T06:00:00.000+0000",
    "age": 1,
    "homeaddress": "asdasdasd",
    "casenumber": "1",
    "visitdate": "2020-03-20T05:00:00.000+0000",
    "noon": 1,
    "deptid": 3,
    "userid": 1,
    "registid": 1,
    "settleid": 1,
    "isbook": 1,
    "registertime": 11111,
    "registerid": 1,
    "visitstate": 1,
    "patientid": 0,
    "diagnosisList": null
}
```

### 3.4 通过主键ID获取一张发票  /getInvoiceById

参数：发票的主键ID `id`

返回：发票

说明：返回的发票中包含发票明细列表。详见 models.md。















## 4. 门诊医生工作站 /DoctorController

### 4.1 接诊/收治 /admit

参数：挂号主键ID `registrationId`

返回：操作成功后返回数据更新后的挂号

说明：接诊收治之前的挂号是没有病历编码的。只有接诊收治之后才会生成一张病历，并且挂号有响应的病历编码。

HTTP 请求示例1：

```http
POST /his/DoctorController/admit?registrationId=1 HTTP/1.1
Host: localhost:9002

```

HTTP 响应示例1：

```json
{
    "id": 1,
    "realname": "ahillatty",
    "gender": 1,
    "idnumber": "112222222",
    "birthdate": "2020-01-01T06:00:00.000+0000",
    "age": 1,
    "homeaddress": "asdasdasd",
    "casenumber": "1",
    "visitdate": "2020-03-20T05:00:00.000+0000",
    "noon": 1,
    "deptid": 3,
    "userid": 1,
    "registid": 1,
    "settleid": 1,
    "isbook": 1,
    "registertime": 11111,
    "registerid": 1,
    "visitstate": 1,
    "patientid": 0
}
```

HTTP 请求示例2：

```http
POST /his/DoctorController/admit?registrationId=10010 HTTP/1.1
Host: localhost:9002

```

HTTP 响应示例2：

```json
{
    "timestamp": "2020-03-28T19:39:22.461+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "The registration does not exist. 挂号不存在。",
    "path": "/his/DoctorController/admit"
}
```





### 4.2 通过主键ID获取一个病历 /getMedicalRecordById

参数：病历主键ID `id`

返回：病历

HTTP 请求示例：

```http
GET /his/DoctorController/getMedicalRecordById?id=1 HTTP/1.1
Host: localhost:9002

```

HTTP 响应示例：

```json
{
    "id": 1,
    "registerId": 1,
    "medicalReadme": null,
    "medicalPresent": null,
    "presentTreat": null,
    "medicalHistory": null,
    "medicalAllergy": null,
    "medicalPhysique": null,
    "medicalDiagnosis": null,
    "medicalHandling": null,
    "caseState": null,
    "caseNumber": ""
}
```



### 4.3 新增一个检查检验处置。/addCheckApply

请求体：主键ID为null的检查检验处置。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：注册成功后返回主键ID非null的字段完整的检查检验处置。

HTTP 请求示例：

```http
POST /his/DoctorController/addCheckApply HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"medicalId":1
}
```

HTTP 响应示例：

```json
{
    "id": null,
    "medicalId": 1,
    "creationTime": null,
    "totalSum": null,
    "objective": null,
    "userId": null,
    "state": null,
    "invoiceNumber": null
}
```

备注：目前返回的检查检验处置的id字段有数据的功能还未实现。







HTTP 请求示例：

```http

```

HTTP 响应示例：

```json

```







HTTP 请求示例：

```http

```

HTTP 响应示例：

```json

```







HTTP 请求示例：

```http

```

HTTP 响应示例：

```json

```





HTTP 请求示例：

```http

```

HTTP 响应示例：

```json

```




















