# APIs 文挡

To 全体成员

By Paul 

[TOC]

## 注意事项⚠️‼️

- 此文档用于说明和解释 HTTP 请求。前后端应根据此文档调用 HTTP 请求。
- 用 IntelliJ IDEA 打开此项目时，请确保安装有 lombok 插件。
- 強烈推荐使用 Typora （或其他合适的工具） 阅读此文档，因直接在 IntelliJ IDEA 打开的显示效果不尽人意，同时不保证在 IntelliJ IDEA 的显示效果。其他 Markdown 文件同理。
- HTTP 请求示例可以在 hisServer/src/test/java/com/njuhis/his/controller_http_tests 中找到，并可以直接运行。
- 文档作为前后端的最重要的协议文件，会不断更新与完善，请密切关注。
- 此文档未经本人允许，任何人都不要修改。有问题请与我联系。
- 「关键必须字段」列表仅供参考。请**根据实际业务**来判断。



## 统一规定

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

  [axios 文档参考](http://www.axios-js.com/zh-cn/docs/)

  

- 一些 HTTP 请求成功后，可能会返回的东西前端不需要，或者不完全需要，那就忽略它即可。服务器尽可能会提供周全的返回，方便调试侦错。比如说更新\保存 update 类的API，如果成功，按道理应该会返回和请求体一样的对象，为的是方便调试侦错，如果不需要，请忽略它即可。

- 关于分页功能的需求：由于 PageHelper 是在 MyBatis 查询的时候起作用的，所以有

  - 如果它是由数据层实现的查询（或联立查询），则可以加入分页功能；
  - 如果它是由业务逻辑层实现的查询（或联立查询），则没有分页功能。

  所以前端的同学如果某一个接口需要分页功能的话，请告知我，或直接写在 todo list.md 文件中。我可能需要和数据库层同学进行商榷。

- **更新/保存 update 类的API，请求体的字段必须完整，否则在数据库中会以 null 覆盖。**

  







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



### 1.5 新增一个科室 /addDepartment

请求体：主键ID为null的科室。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：注册成功后返回主键ID非null的字段完整的科室。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addDepartment HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"deptcode":"BYRK",
	"deptname":"变异人科",
	"depttypeid":2
}
```

HTTP 响应示例：

```json
{
    "id": 144,
    "deptname": "变异人科",
    "deptcategory": null,
    "depttypeid": 2,
    "deptcode": "BYRK",
    "userList": null
}
```



### 1.6 通过主键ID获取一个科室 /getDepartmentById

参数：科室的主键ID `id`

返回：科室

HTTP 请求示例：

```http
GET /his/BasicInformationController/getDepartmentById?id=1 HTTP/1.1
Host: localhost:9002


```

HTTP 响应示例：

```json
{
    "id": 1,
    "deptname": "心血管内科",
    "deptcategory": "11",
    "depttypeid": 1,
    "deptcode": "XXGNK",
    "userList": null
}
```



### 1.7 更新/保存一个科室 /updateDepartment

请求体：一个主键ID非null的科室。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的科室。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateDepartment HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 139,
    "deptname": "变异人類科",
    "deptcategory": null,
    "depttypeid": 2,
    "deptcode": "BYRLK",
    "userList": null
}
```

HTTP 响应示例：

```json
{
    "id": 139,
    "deptname": "变异人類科",
    "deptcategory": null,
    "depttypeid": 2,
    "deptcode": "BYRLK",
    "userList": null
}
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



### 2.3 更新/保存一个医院员工 /updateUser

请求体：一个主键ID非null的医院员工。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的医院员工。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/PersonalInformationController/updateUser HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "username": "sdsdfsf",
    "password": "123qwe",
    "realname": "ahillasdffffffffff",
    "usertypeid": 1,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registerLevelId": 1,
    "idnumber": "11111111111",
    "schedulingList": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "username": "sdsdfsf",
    "password": "123qwe",
    "realname": "ahillasdffffffffff",
    "usertypeid": 1,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registerLevelId": 1,
    "idnumber": "11111111111",
    "schedulingList": null
}
```



### 2.4 医院员工登录 /userSignIn

参数：医院员工的用户名`username`和密码`password`

返回：登录成功后返回医院员工。

HTTP 请求示例：

```http
GET /his/PersonalInformationController/userSignIn?username=sdsdfsf&password=123qwe HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "username": "sdsdfsf",
    "password": "123qwe",
    "realname": "ahillasdffffffffff",
    "usertypeid": 1,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registerLevelId": 1,
    "idnumber": "11111111111",
    "schedulingList": null
}
```

### 2.5 患者登录 /patientSignIn

参数：患者的用户名`username`和密码`password`

返回：登录成功后返回患者。

HTTP 请求示例：

```http
GET /his/PersonalInformationController/patientSignIn?username=ssss&password=ssss HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 8,
    "name": "ssss",
    "idnumber": "",
    "phone": null,
    "loginname": "ssss",
    "password": "ssss"
}
```



### 2.6 通过主键ID获取一个患者/addPatientById

参数：患者的主键ID `id`

返回：患者

HTTP 请求示例：

```http
GET /his/PersonalInformationController/getPatientById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "name": "MyName",
    "idnumber": "idnumber23434",
    "phone": "phone234234",
    "loginname": "Myloginname",
    "password": "Mypassword"
}
```



### 2.7 更新/保存一个患者 /updatePatient

请求体：一个主键ID非null的患者。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的患者。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/PersonalInformationController/updatePatient HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "name": "MyName22222",
    "idnumber": "idnumber23434",
    "phone": "phone234234",
    "loginname": "Myloginname",
    "password": "Mypassword"
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "name": "MyName22222",
    "idnumber": "idnumber23434",
    "phone": "phone234234",
    "loginname": "Myloginname",
    "password": "Mypassword"
}
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







HTTP 请求示例：

```http

```

HTTP 响应示例：

```json

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

返回：新增成功后返回主键ID非null的字段完整的发票。

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

说明：返回的发票中包含发票明细列表。详见 [models.md](models.md) 。

HTTP 请求示例：

```http
GET /his/RegistrationController/getInvoiceById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "invoicenum": null,
    "money": null,
    "state": null,
    "creationtime": null,
    "userid": null,
    "dailystate": null,
    "patientCostsList": null
}
```

备注：「返回的发票中包含发票明细列表」的功能暂时还没有实现。



### 3.5 更新/保存一个挂号 /updateRegistration

请求体：一个主键ID非null的挂号。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的挂号。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/RegistrationController/updateRegistration HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "realname": "MyRealjjjjrName",
    "gender": null,
    "idnumber": null,
    "birthdate": null,
    "age": null,
    "homeaddress": null,
    "casenumber": null,
    "visitdate": null,
    "noon": null,
    "deptid": null,
    "userid": null,
    "registid": null,
    "settleid": null,
    "registertime": null,
    "registerid": null,
    "visitstate": null,
    "patientid": null,
    "diagnosisList": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "realname": "MyRealjjjjrName",
    "gender": null,
    "idnumber": null,
    "birthdate": null,
    "age": null,
    "homeaddress": null,
    "casenumber": null,
    "visitdate": null,
    "noon": null,
    "deptid": null,
    "userid": null,
    "registid": null,
    "settleid": null,
    "registertime": null,
    "registerid": null,
    "visitstate": null,
    "patientid": null,
    "diagnosisList": null
}
```



### 3.6 更新/保存一张发票 /updateInvoice

请求体：一个主键ID非null的发票。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的发票。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/RegistrationController/updateInvoice HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "invoicenum": null,
    "money": null,
    "state": null,
    "creationtime": null,
    "userid": 2,
    "dailystate": null,
    "patientCostsList": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "invoicenum": null,
    "money": null,
    "state": null,
    "creationtime": null,
    "userid": 2,
    "dailystate": null,
    "patientCostsList": null
}
```



### 3.7 新增一条发票明細 /addPatientCosts

请求体：主键ID为null的发票明細。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的发票明細。

HTTP 请求示例：

```http
POST /his/RegistrationController/addPatientCosts HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "invoiceid": null,
    "registerid": null,
    "name": null,
    "price": null,
    "deptid": null,
    "state": null
}
```

### 3.8 通过主键ID获取一条发票明細  /getPatientCostsById

参数：发票明細的主键ID `id`

返回：发票明細

HTTP 请求示例：

```http
GET /his/RegistrationController/getPatientCostsById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "invoiceid": null,
    "registerid": null,
    "name": null,
    "price": null,
    "deptid": null,
    "state": null
}
```



### 3.9 更新/保存一条发票明細 /updatePatientCosts

请求体：一个主键ID非null的发票明細。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的发票明細。理论上返回体应该和请求体一模一样。



HTTP 请求示例：

```http
POST /his/RegistrationController/updatePatientCosts HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "invoiceid": null,
    "registerid": null,
    "name": "lllllllllllllllll",
    "price": null,
    "deptid": null,
    "state": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "invoiceid": null,
    "registerid": null,
    "name": "lllllllllllllllll",
    "price": null,
    "deptid": null,
    "state": null
}
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



### 4.3 新增一个检查（检验或处置）/addCheckApply

请求体：主键ID为null的检查（检验或处置）。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的检查（检验或处置）。

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



### 4.4 通过主键ID获取一个检查（检验或处置）/getCheckApplyById

参数：检查（检验或处置）的主键ID `id`

返回：检查（检验或处置）

HTTP 请求示例：

```http
GET /his/DoctorController/getCheckApplyById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": null,
    "creationTime": null,
    "totalSum": null,
    "objective": null,
    "userId": null,
    "state": null,
    "invoiceNumber": null,
    "checkDetailedList": null
}
```



### 4.5 更新/保存一个检查（检验或处置）/updateCheckApply

请求体：一个主键ID非null的检查（检验或处置）。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的检查（检验或处置）。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/DoctorController/updateCheckApply HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "medicalId": null,
    "creationTime": null,
    "totalSum": null,
    "objective": "I don't know....",
    "userId": null,
    "state": null,
    "invoiceNumber": null,
    "checkDetailedList": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": null,
    "creationTime": null,
    "totalSum": null,
    "objective": "I don't know....",
    "userId": null,
    "state": null,
    "invoiceNumber": null,
    "checkDetailedList": null
}
```



### 4.6 更新/保存一个病历 /updateMedicalRecord

请求体：一个主键ID非null的病历。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的病历。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/DoctorController/updateMedicalRecord HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "registerId": 1,
    "medicalReadme": "脑残",
    "medicalPresent": null,
    "presentTreat": null,
    "medicalHistory": null,
    "medicalAllergy": null,
    "medicalPhysique": null,
    "medicalDiagnosis": null,
    "medicalHandling": null,
    "caseState": null,
    "caseNumber": "3"
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "registerId": 1,
    "medicalReadme": "脑残",
    "medicalPresent": null,
    "presentTreat": null,
    "medicalHistory": null,
    "medicalAllergy": null,
    "medicalPhysique": null,
    "medicalDiagnosis": null,
    "medicalHandling": null,
    "caseState": null,
    "caseNumber": "3"
}
```



### 4.7 新增一个处方 /addPrescription

请求体：主键ID为null的处方。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的处方。



HTTP 请求示例：

```http
POST /his/DoctorController/addPrescription HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"prescriptionName":"含笑半步癲"
}
```

HTTP 响应示例：

```json
{
    "id": 11,
    "medicalId": null,
    "userId": null,
    "prescriptionName": "含笑半步癲",
    "prescriptionState": null,
    "prescriptionTime": null,
    "invoiceId": null,
    "prescriptionDetailedList": null
}
```



### 4.8 通过主键ID获取一个处方 /getPrescriptionById

参数：处方的主键ID `id`

返回：处方

HTTP 请求示例：

```http
GET /his/DoctorController/getPrescriptionById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": 1,
    "userId": null,
    "prescriptionName": null,
    "prescriptionState": null,
    "prescriptionTime": null,
    "invoiceId": null,
    "prescriptionDetailedList": null
}
```



### 4.9 更新/保存一个处方 /updatePrescription

请求体：一个主键ID非null的处方。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的处方。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/DoctorController/updatePrescription HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "medicalId": 1,
    "userId": null,
    "prescriptionName": "葵花寶典",
    "prescriptionState": null,
    "prescriptionTime": null,
    "invoiceId": null,
    "prescriptionDetailedList": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": 1,
    "userId": null,
    "prescriptionName": "葵花寶典",
    "prescriptionState": null,
    "prescriptionTime": null,
    "invoiceId": null,
    "prescriptionDetailedList": null
}
```



### 4.10 新增一条检查（检验或处置）明细 /addCheckDetailed

请求体：主键ID为null的检查（检验或处置）明细。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的检查（检验或处置）明细。

HTTP 请求示例：

```http
POST /his/DoctorController/addCheckDetailed HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"checkappid": 1
}
```

HTTP 响应示例：

```json
{
    "id": 11,
    "checkappid": 1,
    "checkprojid": null,
    "deptid": null,
    "position": null,
    "state": null,
    "price": null,
    "identification": null,
    "inspecttime": null,
    "result": null,
    "resulttime": null,
    "operatorid": null,
    "entryclerkid": null
}
```



### 4.11 通过主键ID获取一条检查（检验或处置）明细 /getCheckDetailedById

参数：检查（检验或处置）明细的主键ID `id`

返回：检查（检验或处置）明细



HTTP 请求示例：

```http
GET /his/DoctorController/getCheckDetailedById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "checkappid": 1,
    "checkprojid": 1,
    "deptid": 3,
    "position": "1",
    "state": 1,
    "price": 1.00,
    "identification": 1,
    "inspecttime": 111111,
    "result": "1",
    "resulttime": 1,
    "operatorid": 1,
    "entryclerkid": 1
}
```



### 4.12 更新/保存一条检查（检验或处置）明细 /updateCheckDetailed

请求体：一条主键ID非null的检查（检验或处置）明细。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的检查（检验或处置）明细。理论上返回体应该和请求体一模一样。



HTTP 请求示例：

```http
POST /his/DoctorController/updateCheckDetailed HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "checkappid": 1,
    "checkprojid": 1,
    "deptid": 3,
    "position": "1",
    "state": 1,
    "price": 1.00,
    "identification": 1,
    "inspecttime": 111111,
    "result": "133333333333333333333333",
    "resulttime": 1,
    "operatorid": 1,
    "entryclerkid": 1
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "checkappid": 1,
    "checkprojid": 1,
    "deptid": 3,
    "position": "1",
    "state": 1,
    "price": 1.00,
    "identification": 1,
    "inspecttime": 111111,
    "result": "133333333333333333333333",
    "resulttime": 1,
    "operatorid": 1,
    "entryclerkid": 1
}
```



### 4.7 新增一条处方明细 /addPrescriptionDetailed

请求体：主键ID为null的处方明细。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的处方明细。

HTTP 请求示例：

```http
POST /his/DoctorController/addPrescriptionDetailed HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
}
```

HTTP 响应示例：

```json
{
    "id": 7,
    "prescriptionid": null,
    "drugsid": null,
    "useage": null,
    "dosage": null,
    "frequency": null,
    "price": null,
    "quantity": null,
    "drugs": null
}
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

