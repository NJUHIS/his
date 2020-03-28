# APIs 文挡

To 全体成员

By Paul 

⚠️‼️注意事项

- 此文档用于说明和解释 HTTP 请求。前后端应根据此文档调用 HTTP 请求。

- 用 IntelliJ IDEA 打开此项目时，请确保安装有 lombok 插件。

- 強烈推荐使用 Typora （或其他合适的工具） 阅读此文档，因直接在 IntelliJ IDEA 打开的显示效果不尽人意，同时不保证在 IntelliJ IDEA 的显示效果。其他 Markdown 文件同理。

- HTTP 请求示例可以在 hisServer/src/test/java/com/njuhis/his/controller_http_tests 中找到，并可以直接运行。

- 文档作为前后端的最重要的协议文件，会不断更新与完善，请密切关注。

- 此文档未经本人允许，任何人都不要修改。

- 一些 HTTP 请求成功后，可能会返回的东西前端不需要，或者不完全需要，那就忽略它好啦。服务器尽可能会提供周全的返回。

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

- 「关键必须字段」列表仅供参考。请**根据实际业务**来判断。







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

返回：注册成功后返回主键ID非null的字段完整患者

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





## 3. 门诊挂号收费 /RegistrationC

###  3.1 挂号/新增一个挂号 /addR

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

备注：目前返回的挂号id字段有数据的功能还未实现


























