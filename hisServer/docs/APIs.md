# APIs 文挡

To 全体成员

By Paul 

⚠️‼️注意事项：

- 此文档用于说明和解释 HTTP 请求。前后端应根据此文档调用 HTTP 请求。
- 用 IntelliJ IDEA 打开此项目时，请确保安装有 lombok 插件。
- 強烈推荐使用 Typora （或其他合适的工具） 阅读此文档，因直接在 IntelliJ IDEA 打开的显示效果不尽人意，同时不保证在 IntelliJ IDEA 的显示效果。其他 Markdown 文件同理。
- HTTP 请求示例可以在 hisServer/src/test/java/com/njuhis/his/controller_http_tests 中找到，并可以直接运行。
- 文档作为前后端的最重要的协议文件，会不断更新与完善，请密切关注。
- -此文档未经本人允许，任何人都不要修改。
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

  

- 一些 HTTP 请求成功后，可能会返回的东西前端不需要，或者不完全需要，那就忽略它好啦。服务器尽可能会提供周全的返回。







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

参数：医院员工的主键ID

```
id
```

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




















