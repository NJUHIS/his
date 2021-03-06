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

- 设置 IntelliJ IDEA 的数据库可视化：

  ```json
  Host: 47.101.197.23
  Port: 3306
  User: remoteuser
  Password: 21LS69CxGDtS$VS&
  Database: his
  URL: jdbc:mysql://47.101.197.23:3306/his?characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8
  ```

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

返回：新增成功后返回主键ID非null的字段完整的科室。

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

###1.8 获取所有常数项 /getAllConstantItems

参数：无

返回：常数项列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllConstantItems HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 11,
        "constanttypeid": 1,
        "constantcode": "NK",
        "constantname": "内科"
    },
    {
        "id": 12,
        "constanttypeid": 1,
        "constantcode": "WK",
        "constantname": "外科"
    }
    {
]
```



### 1.9 新增一个常数项 /addConstantItem

请求体：主键ID为null的常数项。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的常数项。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addConstantItem HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
        "constanttypeid": 1,
        "constantcode": "NKttttt",
        "constantname": "内科ttttttt"
    },
```

HTTP 响应示例：

```json
{
    "id": 168,
    "constanttypeid": 1,
    "constantcode": "NKttttt",
    "constantname": "内科ttttttt"
}
```



### 1.10 更新/保存一个常数项 /updateConstantItem

请求体：一个主键ID非null的常数项。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的常数项。理论上返回体应该和请求体一模一样。



HTTP 请求示例：

```http
POST /his/BasicInformationController/updateConstantItem HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 168,
    "constanttypeid": 1,
    "constantcode": "NKttttt",
    "constantname": "内科ttttttt9999999"
}
```

HTTP 响应示例：

```json
{
    "id": 168,
    "constanttypeid": 1,
    "constantcode": "NKttttt",
    "constantname": "内科ttttttt9999999"
}
```

### 1.11 通过主键ID获取一个常数项 /getConstantItemById

参数：常数项的主键ID `id`

返回：常数项

HTTP 请求示例：

```http
GET /his/BasicInformationController/getConstantItemById?id=11 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 11,
    "constanttypeid": 1,
    "constantcode": "NK",
    "constantname": "内科"
}
```

###1.12 获取所有挂号类型 /getAllRegisterLevels

参数：无

返回：挂号类型列表



HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllRegisterLevels HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "registname": "普通号",
        "registfee": 20.00
    },
    {
        "id": 2,
        "registname": "专家号",
        "registfee": 30.00
    },
    {
        "id": 3,
        "registname": "急诊号",
        "registfee": 40.00
    }
]
```

###1.13 获取所有常数类型 /getAllConstantTypes

参数：无

返回：常数类型列表



HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllConstantTypes HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "constanttypecode": "DeptCategory",
        "constanttypename": "科室分类"
    },
    {
        "id": 5,
        "constanttypecode": "FeeType",
        "constanttypename": "收费方式"
    }
]
```



### 1.14 新增一个常数类型 /addConstantType

请求体：主键ID为null的常数类型。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的常数类型。



HTTP 请求示例：

```http
POST /his/BasicInformationController/addConstantType HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "constanttypecode": "DeptCategory555555",
    "constanttypename": "科室分类555555"
}
```

HTTP 响应示例：

```json
{
    "id": 15,
    "constanttypecode": "DeptCategory555555",
    "constanttypename": "科室分类555555"
}
```

### 1.15 通过主键ID获取一个常数类型 /getConstantTypeById

参数：常数类型的主键ID `id`

返回：常数类型

HTTP 请求示例：

```http
GET /his/BasicInformationController/getConstantTypeById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "constanttypecode": "DeptCategory",
    "constanttypename": "科室分类"
}
```



### 1.16 更新/保存一个常数类型 /updateConstantType

请求体：一个主键ID非null的常数类型。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的常数类型。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateConstantType HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 13,
    "constanttypecode": "DeptCategory",
    "constanttypename": "科室分类mmmmmmmmm"
}
```

HTTP 响应示例：

```json
{
    "id": 13,
    "constanttypecode": "DeptCategory",
    "constanttypename": "科室分类mmmmmmmmm"
}
```



### 1.17 通过主键ID获取一个挂号类型 /getRegisterLevelById

参数：挂号类型的主键ID `id`

返回：挂号类型

HTTP 请求示例：

```http
GET /his/BasicInformationController/getRegisterLevelById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "registname": "普通号",
    "registfee": 20.00
}
```



### 1.18 新增一个挂号类型 /addRegisterLevel

请求体：主键ID为null的挂号类型。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的挂号类型。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addRegisterLevel HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "registname": "超级号",
    "registfee": 333320.00
}
```

HTTP 响应示例：

```json
{
    "id": 4,
    "registname": "超级号",
    "registfee": 333320.00
}
```



### 1.19 更新/保存一个挂号类型/updateRegisterLevel

请求体：一个主键ID非null的挂号类型。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的挂号类型。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateRegisterLevel HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 4,
    "registname": "超级号",
    "registfee": 30020.00
}
```

HTTP 响应示例：

```json
{
    "id": 4,
    "registname": "超级号",
    "registfee": 30020.00
}
```



###1.20 获取所有结算类型 /getAllSettleCategories

参数：无

返回：结算列表



HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllSettleCategories HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "settlename": "醫保"
    },
    {
        "id": 2,
        "settlename": "自費"
    }
]
```

### 1.21 新增一个结算类型 /addSettleCategory

请求体：主键ID为null的结算类型。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的结算类型。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addSettleCategory HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "settlename": "新农合"
}
```

HTTP 响应示例：

```json
{
    "id": 4,
    "settlename": "新农合"
}
```

### 1.22 通过主键ID获取一个结算类型 /getSettleCategoryById

参数：结算类型的主键ID `id`

返回：结算类型

HTTP 请求示例：

```http
GET /his/BasicInformationController/getSettleCategoryById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "settlename": "醫保qqqqqqq"
}
```

### 1.23 更新/保存一个结算类型/updateSettleCategory

请求体：一个主键ID非null的结算类型。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的结算类型。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateSettleCategory HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "settlename": "醫保qqqqqqq"
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "settlename": "醫保qqqqqqq"
}
```





###1.24 获取所有费用类型 /getAllExpenseClasses

参数：无

返回：费用类型列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllExpenseClasses HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "expname": "挂号费",
        "expcode": "GHF"
    },
    {
        "id": 2,
        "expname": "诊疗费",
        "expcode": "ZLF"
    }
]
```



### 1.25 新增一个费用类型 /addExpenseClass

请求体：主键ID为null的費用类型。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的费用类型。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addExpenseClass HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "expname": "AZF",
    "expcode": "安葬费"
}
```

HTTP 响应示例：

```json
{
    "id": 23,
    "expname": "AZF",
    "expcode": "安葬费"
}
```

### 1.26 通过主键ID获取一个结算类型 /getExpenseClassById

参数：结算类型的主键ID `id`

返回：结算类型

HTTP 请求示例：

```http
GET /his/BasicInformationController/getExpenseClassById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "expname": "挂号费",
    "expcode": "GHF"
}
```



### 1.27 更新/保存一个费用类型/updateExpenseClass

请求体：一个主键ID非null的费用类型。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的费用类型。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateExpenseClass HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 23,
    "expname": "AZF",
    "expcode": "安葬费mmmmmmmmmm"
}
```

HTTP 响应示例：

```json
{
    "timestamp": "2020-04-17T09:44:53.464+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Unknown error occurred. 发生未知错误。",
    "path": "/his/BasicInformationController/updateExpenseClass"
}
```

備註：目前此 API 暂时不可用。

###1.28 获取所有排班 /getAllScheduling 

参数：无

返回：排班列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllSchedulings HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "scheddate": "2020-12-02",
        "deptid": 1,
        "userid": 100,
        "noon": 1,
        "registquota": 3,
        "state": 3,
        "user": null,
        "department": null,
        "remainingQuota": 3
    },
    {
        "id": 2,
        "scheddate": "2020-12-02",
        "deptid": 1,
        "userid": 100,
        "noon": 1,
        "registquota": 3,
        "state": 3,
        "user": null,
        "department": null,
        "remainingQuota": 3
    }
]
```



### 1.29 通过主键ID获取一个排班 /getSchedulingById 

参数：排班的主键ID `id`

返回：排班

HTTP 请求示例：

```http
GET /his/BasicInformationController/getSchedulingById?id=2 HTTP/1.1
Host: localhost:9002

```

HTTP 响应示例：

```json
{
    "id": 2,
    "scheddate": "2020-12-02",
    "deptid": 1,
    "userid": 100,
    "noon": 1,
    "registquota": 3,
    "state": 3,
    "user": {
        "id": 100,
        "username": "robin",
        "password": "password",
        "realname": "Robin",
        "usertypeid": 2,
        "doctitleid": 1,
        "isscheduling": null,
        "deptid": 1,
        "registerLevelId": 100,
        "idnumber": null,
        "schedulingList": null
    },
    "department": {
        "id": 1,
        "deptname": "心血管内科",
        "deptcategory": "11",
        "depttypeid": 1,
        "deptcode": "XXGNK",
        "userList": null
    },
    "remainingQuota": 3
}
```

### ~~1.30 更新/保存一个排班/updateScheduling（已作废）~~ 

请求体：一个主键ID非null的排班。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的排班。理论上返回体应该和请求体一模一样。

**说明：此 API 已作废。规定排班成功之后不可修改。**

HTTP 请求示例：

```http

```

HTTP 响应示例：

```json

```

### 1.31 新增一个排班 /addScheduling 

请求体：主键ID为null的排班。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的排班。

说明：规定新增排班成功之后不可修改。deptid, state 不需要由前台填写，由后台根据 userid 自动填写。即使前台填写了，也会被后台的自动填写所覆盖。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addScheduling HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "userid": 100,
    "scheddate": "2020-12-02",
    "noon": 1,
    "registquota": 3
}
```

HTTP 响应示例：

```json
{
    "id": 3,
    "scheddate": "2020-12-02",
    "deptid": 1,
    "userid": 100,
    "noon": 1,
    "registquota": 3,
    "state": 3,
    "user": {
        "id": 100,
        "username": "robin",
        "password": "password",
        "realname": "Robin",
        "usertypeid": 2,
        "doctitleid": 1,
        "isscheduling": null,
        "deptid": 1,
        "registerLevelId": 100,
        "idnumber": null,
        "schedulingList": null
    },
    "department": {
        "id": 1,
        "deptname": "心血管内科",
        "deptcategory": "11",
        "depttypeid": 1,
        "deptcode": "XXGNK",
        "userList": null
    },
    "remainingQuota": 3
}
```





### 1.32 根据多个条件获取排班列表 /getSchedulingsByConditions

参数：如果参数为null或省略，表示该条件不设限。如果日期下限和午别下限为null，说明不设置下限。上限同理。fromScheduleDate和fromNoon要么同时有数值，要么同时为null或省略，toScheduleDate和toNoon 同理。

```java
fromScheduleDate;//排班日期范围下限
//standard forms ("yyyy-MM-dd")
fromNoon;//排班午别范围下限
//1 - 凌晨
//2 - 早上
//3 - 下午
//4 - 晚上
toScheduleDate;//排班日期范围上限
//standard forms ("yyyy-MM-dd")
toNoon;//排班午别范围上限
//1 - 凌晨
//2 - 早上
//3 - 下午
//4 - 晚上
deptId;//被排班医生的所属部门主键ID
userId;//被排班的医生的医院员工主键ID
state;//排班的状态
registerLevelId;//查询时医生的挂号类型主键ID，(未必是新增排班时候的医生的挂号类型主键ID，因为医生的挂号类型主键ID可能改变。)
```

返回：符合条件的排班的列表。

HTTP 请求示例：

```http
GET /his/BasicInformationController/getSchedulingsByConditions?userId=100&deptId=1&state=3&fromScheduleDate=2020-04-24&fromNoon=2&toScheduleDate=2020-12-25&toNoon=3&registerLevelId=100 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "scheddate": "2020-12-02",
        "deptid": 1,
        "userid": 100,
        "noon": 1,
        "registquota": 3,
        "state": 3,
        "user": {
            "id": 100,
            "username": "robin",
            "password": "password",
            "realname": "Robin",
            "usertypeid": 2,
            "doctitleid": 1,
            "isscheduling": null,
            "deptid": 1,
            "registerLevelId": 100,
            "idnumber": null,
            "schedulingList": null
        },
        "department": {
            "id": 1,
            "deptname": "心血管内科",
            "deptcategory": "11",
            "depttypeid": 1,
            "deptcode": "XXGNK",
            "userList": null
        },
        "remainingQuota": 2
    }
]
```



###1.33 获取所有非药品项目 /getAllFmedItems

参数：无

返回：非药品项目列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllFmedItems HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "itemname": "大抢救",
        "format": "日",
        "price": 200.00,
        "expclassid": 16,
        "deptid": 133,
        "itemcode": "120200001"
    },
    {
        "id": 2,
        "itemname": "中抢救",
        "format": "日",
        "price": 150.00,
        "expclassid": 16,
        "deptid": 133,
        "itemcode": "120200002"
    }
]
```

### 1.34 通过主键ID获取一个非药品项目 /getFmedItemById 

参数：非药品项目的主键ID `id`

返回：非药品项目



HTTP 请求示例：

```http
GET /his/BasicInformationController/getFmedItemById?id=2 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 2,
    "itemname": "中抢救",
    "format": "日",
    "price": 150.00,
    "expclassid": 16,
    "deptid": 133,
    "itemcode": "120200002"
}



```

### 1.35 新增一个非药品项目 /addFmedItem

请求体：主键ID为null的非药品项目。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的非药品项目。

说明：



HTTP 请求示例：

```http
POST /his/BasicInformationController/addFmedItem HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "itemname": "中抢救",
    "format": "日",
    "price": 150.00,
    "expclassid": 16,
    "deptid": 133,
    "itemcode": "120200002"
}
```

HTTP 响应示例：

```json
{
    "id": 58,
    "itemname": "中抢救",
    "format": "日",
    "price": 150.00,
    "expclassid": 16,
    "deptid": 133,
    "itemcode": "120200002"
}
```

### 1.36 更新/保存一个非药品项目/updateFmedItem

请求体：一个主键ID非null的非药品项目。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的非药品项目。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateFmedItem HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 59,
    "itemname": "中抢救233333333",
    "format": "日",
    "price": 150.00,
    "expclassid": 16,
    "deptid": 133,
    "itemcode": "120200002"
}
```

HTTP 响应示例：

```json
{
    "id": 59,
    "itemname": "中抢救233333333",
    "format": "日",
    "price": 150.00,
    "expclassid": 16,
    "deptid": 133,
    "itemcode": "120200002"
}
```

### 1.37 新增一个诊断 /addDiagnosis

请求体：主键ID为null的诊断。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的诊断。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addDiagnosis HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"medicalid":1,
	"diseaseid":1
}
```

HTTP 响应示例：

```json
{
    "id": 5,
    "medicalid": 1,
    "diseaseid": 1,
    "disease": {
        "id": 1,
        "diseasecode": "GDXHL",
        "diseasename": "古典型霍乱",
        "diseaseicd": "A00.051",
        "diseasetype": "140"
    }
}
```

### 1.38 更新/保存一个诊断/updateDiagnosis

请求体：一个主键ID非null的诊断。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的诊断。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateDiagnosis HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 5,
	"medicalid":1,
	"diseaseid":2
}
```

HTTP 响应示例：

```json
{
    "id": 5,
    "medicalid": 1,
    "diseaseid": 2,
    "disease": {
        "id": 2,
        "diseasecode": "ZXDXHL",
        "diseasename": "中型[典型]霍乱",
        "diseaseicd": "A00.052",
        "diseasetype": "140"
    }
}
```

###1.39 获取所有诊断 /getAllDiagnoses

参数：无

返回：诊断列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllDiagnoses HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "medicalid": 1,
        "diseaseid": 1,
        "disease": {
            "id": 1,
            "diseasecode": "GDXHL",
            "diseasename": "古典型霍乱",
            "diseaseicd": "A00.051",
            "diseasetype": "140"
        }
    },
    {
        "id": 2,
        "medicalid": 1,
        "diseaseid": 1,
        "disease": {
            "id": 1,
            "diseasecode": "GDXHL",
            "diseasename": "古典型霍乱",
            "diseaseicd": "A00.051",
            "diseasetype": "140"
        }
    }
]
```

### 1.40 通过主键ID获取一个诊断 /getDiagnosisById 

参数：诊断的主键ID `id`

返回：诊断

HTTP 请求示例：

```http
GET /his/BasicInformationController/getDiagnosisById?id=2 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 2,
    "medicalid": 1,
    "diseaseid": 1,
    "disease": {
        "id": 1,
        "diseasecode": "GDXHL",
        "diseasename": "古典型霍乱",
        "diseaseicd": "A00.051",
        "diseasetype": "140"
    }
}
```

### 1.41 通过主键ID获取一个药品 /getDrugById 

参数：药品的主键ID `id`

返回：药品

HTTP 请求示例：

```http
GET /his/BasicInformationController/getDrugById?id=2 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 2,
    "drugsName": "氟康唑氯化钠注射液(大扶康)",
    "drugsFormat": "200mg×100ml/瓶",
    "drugsUnit": "瓶",
    "manufacturer": "辉瑞制药有限公司",
    "drugsDosage": "110",
    "drugsType": "101",
    "drugsPrice": 7.01,
    "mnemonicCode": "FKZLHNZSY(DFK)",
    "creationDate": "2019-02-28T16:00:00.000+0000",
    "lastUpdateDate": "2019-02-28T16:00:00.000+0000"
}
```

###1.42 获取所有药品 /getAllDrugs

参数：无

返回：药品列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllDrugs HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "drugsName": "注射用甲氨喋呤",
        "drugsFormat": "1g×1支",
        "drugsUnit": "支",
        "manufacturer": "江苏恒瑞医药股份有限公司",
        "drugsDosage": "110",
        "drugsType": "101",
        "drugsPrice": 15.73,
        "mnemonicCode": "ZSYJAZZ",
        "creationDate": "2019-02-28T16:00:00.000+0000",
        "lastUpdateDate": "2019-02-28T16:00:00.000+0000"
    },
    {
        "id": 2,
        "drugsName": "氟康唑氯化钠注射液(大扶康)",
        "drugsFormat": "200mg×100ml/瓶",
        "drugsUnit": "瓶",
        "manufacturer": "辉瑞制药有限公司",
        "drugsDosage": "110",
        "drugsType": "101",
        "drugsPrice": 7.01,
        "mnemonicCode": "FKZLHNZSY(DFK)",
        "creationDate": "2019-02-28T16:00:00.000+0000",
        "lastUpdateDate": "2019-02-28T16:00:00.000+0000"
    }
]
```

### 1.43 新增一个药品 /addDrug

请求体：主键ID为null的药品。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的药品。

HTTP 请求示例：

```http
POST /his/BasicInformationController/addDrug HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "drugsName": "氟康唑氯化钠注射液(大扶康)23333333",
    "drugsFormat": "200mg×100ml/瓶",
    "drugsUnit": "瓶",
    "manufacturer": "辉瑞制药有限公司",
    "drugsDosage": "110",
    "drugsType": "101",
    "drugsPrice": 7.01,
    "mnemonicCode": "FKZLHNZSY(DFK)"
}
```

HTTP 响应示例：

```json
{
    "id": 101,
    "drugsName": "氟康唑氯化钠注射液(大扶康)23333333",
    "drugsFormat": "200mg×100ml/瓶",
    "drugsUnit": "瓶",
    "manufacturer": "辉瑞制药有限公司",
    "drugsDosage": "110",
    "drugsType": "101",
    "drugsPrice": 7.01,
    "mnemonicCode": "FKZLHNZSY(DFK)",
    "creationDate": null,
    "lastUpdateDate": null
}
```

### 1.44 更新/保存一个药品/updateDrug

请求体：一个主键ID非null的药品。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的药品。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/BasicInformationController/updateDrug HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 101,
    "drugsName": "氟康唑氯化钠注射液(大扶康)awsl",
    "drugsFormat": "200mg×100ml/瓶",
    "drugsUnit": "瓶",
    "manufacturer": "辉瑞制药有限公司",
    "drugsDosage": "110",
    "drugsType": "101",
    "drugsPrice": 7.01,
    "mnemonicCode": "FKZLHNZSY(DFK)",
    "creationDate": "2019-02-28T16:00:00.000+0000",
    "lastUpdateDate": "2019-02-28T16:00:00.000+0000"
}
```

HTTP 响应示例：

```json
{
    "id": 101,
    "drugsName": "氟康唑氯化钠注射液(大扶康)awsl",
    "drugsFormat": "200mg×100ml/瓶",
    "drugsUnit": "瓶",
    "manufacturer": "辉瑞制药有限公司",
    "drugsDosage": "110",
    "drugsType": "101",
    "drugsPrice": 7.01,
    "mnemonicCode": "FKZLHNZSY(DFK)",
    "creationDate": "2019-02-28T16:00:00.000+0000",
    "lastUpdateDate": "2019-02-28T16:00:00.000+0000"
}
```

###1.45 获取所有疾病 /getAllDiseases

参数：无

返回：疾病列表

HTTP 请求示例：

```http
GET /his/BasicInformationController/getAllDiseases HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "diseasecode": "GDXHL",
        "diseasename": "古典型霍乱",
        "diseaseicd": "A00.051",
        "diseasetype": "140"
    },
    {
        "id": 2,
        "diseasecode": "ZXDXHL",
        "diseasename": "中型[典型]霍乱",
        "diseaseicd": "A00.052",
        "diseasetype": "140"
    }
]
```





### 1.46 通过主键ID获取一个疾病 /getDiseaseById 

参数：疾病的主键ID `id`

返回：疾病





HTTP 请求示例：

```http
GET /his/BasicInformationController/getDiseaseById?id=2 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 2,
    "diseasecode": "ZXDXHL",
    "diseasename": "中型[典型]霍乱",
    "diseaseicd": "A00.052",
    "diseasetype": "140"
}
```





### 1.47 新增一个疾病 /addDisease

请求体：主键ID为null的疾病。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的疾病。



HTTP 请求示例：

```http
POST /his/BasicInformationController/addDisease HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "diseasecode": "ZXDXHL",
    "diseasename": "中型[典型]霍乱23333",
    "diseaseicd": "A00.052",
    "diseasetype": "140"
}
```

HTTP 响应示例：

```json
{
    "id": 1001,
    "diseasecode": "ZXDXHL",
    "diseasename": "中型[典型]霍乱23333",
    "diseaseicd": "A00.052",
    "diseasetype": "140"
}
```



### 1.48 更新/保存一个疾病/updateDisease

请求体：一个主键ID非null的疾病。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的疾病。理论上返回体应该和请求体一模一样。



HTTP 请求示例：

```http
POST /his/BasicInformationController/updateDisease HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1001,
    "diseasecode": "ZXDXHL",
    "diseasename": "中型[典型]霍乱awsl",
    "diseaseicd": "A00.052",
    "diseasetype": "140"
}
```

HTTP 响应示例：

```json
{
    "id": 1001,
    "diseasecode": "ZXDXHL",
    "diseasename": "中型[典型]霍乱awsl",
    "diseaseicd": "A00.052",
    "diseasetype": "140"
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

```java
patientid
settleid
scheduleId
isbook
```

返回：挂号成功后返回主键ID非null的字段完整的挂号。

说明：规定挂号成功之后不可修改。visitdate, noon, userid, registid, deptid, idnumber, gender, homeaddress, birthdate, age, realname, state 不需要由前台填写，由后台根据 scheduleId 自动填写。即使前台填写了，也会被后台的自动填写所覆盖。挂号成功后后台已自动为该次看诊新建了一张发票。

HTTP 请求示例：

```http
POST /his/RegistrationController/addRegistration HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "patientid": 100,
    "isbook": 0,
    "settleid": 100,
    "scheduleId":1
}
```

HTTP 响应示例：

```json
{
    "id": 7,
    "realname": "Nelson",
    "gender": 1,
    "idnumber": "123456198011101234",
    "birthdate": "1980-11-10",
    "age": null,
    "homeaddress": "Shanghai",
    "medicalRecordId": null,
    "visitdate": "2020-12-02",
    "noon": 1,
    "deptid": 1,
    "userid": 100,
    "registid": 100,
    "settleid": 100,
    "isbook": 0,
    "registertime": 1589402372464,
    "registerid": null,
    "visitstate": 0,
    "patientid": 100,
    "scheduleId": 100,
    "patientCostsList": null,
    "user": null,
    "department": null,
    "sum": null,
    "invoice": {
        "id": 7,
        "invoicenum": null,
        "money": null,
        "state": 1,
        "creationtime": null,
        "userid": 100,
        "dailystate": 1,
        "patientCostsList": [
            {
                "id": 2,
                "invoiceid": 7,
                "registerid": 7,
                "name": "Registration Expense 挂号费",
                "price": 9999.00,
                "deptid": null,
                "state": 2
            }
        ]
    }
}
```



### 3.2 新增一张发票 /addInvoice

请求体：主键ID为null的发票。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的发票。

说明：API 3.1 挂号成功后后台已自动为该次看诊新建了一张发票。

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
    "realname": "Nelson",
    "gender": 1,
    "idnumber": "7989688077809873",
    "birthdate": null,
    "age": null,
    "homeaddress": null,
    "medicalRecordId": null,
    "visitdate": "2020-12-02",
    "noon": 1,
    "deptid": 1,
    "userid": 100,
    "registid": 100,
    "settleid": 100,
    "isbook": 0,
    "registertime": 1587844363369,
    "registerid": 101,
    "visitstate": 0,
    "patientid": 100,
    "scheduleId": 1,
    "patientCostsList": null
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



### ~~3.5 更新/保存一个挂号 /updateRegistration（已作废）~~

请求体：一个主键ID非null的挂号。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的挂号。理论上返回体应该和请求体一模一样。

**说明：此 API 已作废。规定挂号成功之后不可修改。**

HTTP 请求示例：

```http

```

HTTP 响应示例：

```json

```



### 3.6 更新/保存一张发票 /updateInvoice

请求体：一个主键ID非null的发票。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的发票。理论上返回体应该和请求体一模一样。

说明：API 3.11 付款检查（检验或处置）和 API 3.12 付款处方的时候，相应的发票会由后台自动更新。

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

### 3.10 根据多个条件获取挂号列表 /getRegistrationsByConditions （待更新）

参数：如果参数为null或省略，表示该条件不设限。如果日期下限和午别下限为null，说明不设置下限。上限同理。fromVisitDate和fromNoon要么同时有数值，要么同时为null或省略，toVisitDate和toNoon 同理。

```java
Date fromVisitDate;//预约看诊日期范围下限
//standard forms ("yyyy-MM-dd")
fromNoon;//预约看诊午别范围下限
//1 - 凌晨
//2 - 早上
//3 - 下午p
//4 - 晚上
toVisitDate;//预约看诊日期范围上限
//standard forms ("yyyy-MM-dd")
toNoon;//预约看诊午别范围上限
//1 - 凌晨
//2 - 早上
//3 - 下午
//4 - 晚上
departmentId;//看诊科室主键ID
userId;//医生的医院员工主键ID
registrationTypeId;//挂号类型主键ID
settlementTypeId;//结算类型主键ID
needBook;//是否需要病历本
//1-需要
//0-不需要
registrarId;//挂号员的医院员工主键ID
visitState;//看诊状态
//0-未看诊
//1-已看诊或正在看诊
patientId;//患者主键ID
scheduleId;//排班主键ID
```

返回：符合条件的挂号的列表。

HTTP 请求示例：

```http
GET /his/RegistrationController/getRegistrationsByConditions?userId=100&departmentId=1&visitState=0&fromVisitDate=2020-04-24&fromNoon=1&toVisitDate=2020-12-25&toNoon=1&registrationTypeId=100&needBook=0&patientId=100&settlementTypeId=100&registrarId=101&scheduleId=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
    {
        "id": 1,
        "realname": "Nelson",
        "gender": 1,
        "idnumber": "7989688077809873",
        "birthdate": null,
        "age": null,
        "homeaddress": null,
        "medicalRecordId": null,
        "visitdate": "2020-12-02",
        "noon": 1,
        "deptid": 1,
        "userid": 100,
        "registid": 100,
        "settleid": 100,
        "isbook": 0,
        "registertime": 1587844363369,
        "registerid": 101,
        "visitstate": 0,
        "patientid": 100,
        "scheduleId": 1,
        "patientCostsList": null
    },
    {
        "id": 2,
        "realname": "Nelson",
        "gender": 1,
        "idnumber": "7989688077809873",
        "birthdate": null,
        "age": null,
        "homeaddress": null,
        "medicalRecordId": null,
        "visitdate": "2020-12-02",
        "noon": 1,
        "deptid": 1,
        "userid": 100,
        "registid": 100,
        "settleid": 100,
        "isbook": 0,
        "registertime": 1587844369810,
        "registerid": 101,
        "visitstate": 0,
        "patientid": 100,
        "scheduleId": 1,
        "patientCostsList": null
    }
]
```



### 3.11 付款检查（检验或处置） /payCheckApply

请求参数：检查（检验或处置）主键ID `checkApplyId`

说明：此方法将检查（检验或处置）状态由“2 - 已开立并发出，未收费”变为   "3 - 已收费，未检验检查处置"。相应的发票会由后台自动更新。

返回：状态改变后的检查（检验或处置）

HTTP 请求示例：

```http
POST /his/RegistrationController/payCheckApply?checkApplyId=200 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 200,
    "medicalId": 200,
    "creationTime": null,
    "totalSum": null,
    "objective": null,
    "userId": 100,
    "state": 3,
    "invoiceId": null,
    "checkDetailedList": []
}
```



### 3.12 付款处方 /payPrescription

请求参数：处方主键ID `prescriptionId`

说明：此方法将处方状态由“2 - 已开立并发出，未收费”变为   "3 - 已收费，未取药"。相应的发票会由后台自动更新。

返回：状态改变后的处方



HTTP 请求示例：

```http
POST /his/RegistrationController/payPrescription?prescriptionId=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": 1,
    "userId": 1,
    "prescriptionName": "處方名稱",
    "prescriptionState": 3,
    "prescriptionTime": 1589397027918,
    "invoiceId": null,
    "prescriptionDetailedList": null
}
```





### 3.13 确认开出发票 /confirmInvoice

请求参数：发票主键ID `invoiceId`

说明：此方法将发票状态由“1 - 未开出"变为“2 - 已开出，正常状态”。

返回：状态改变后的发票

HTTP 请求示例：

```http
POST /his/RegistrationController/confirmInvoice?invoiceId=7 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 7,
    "invoicenum": null,
    "money": null,
    "state": 2,
    "creationtime": 1589404234620,
    "userid": null,
    "dailystate": 1,
    "patientCostsList": [
        {
            "id": 2,
            "invoiceid": 7,
            "registerid": 7,
            "name": "Registration Expense 挂号费",
            "price": 9999.00,
            "deptid": null,
            "state": 2
        }
    ]
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



## 4. 门诊医生工作站 /DoctorController

### 4.1 接诊/收治 /admit

参数：挂号主键ID `registrationId`

返回：操作成功后返回数据更新后的挂号

说明：接诊收治之前的挂号是没有病历主鍵ID的。只有接诊收治之后才会生成一张病历，并且挂号有相應的病历主键ID。挂号的问诊状态由 0 变成 1。

HTTP 请求示例1：

```http
POST /his/DoctorController/admit?registrationId=100 HTTP/1.1
Host: localhost:9002




```

HTTP 响应示例1：

```json
{
    "id": 100,
    "realname": "Nelson",
    "gender": 1,
    "idnumber": "7989688077809873",
    "birthdate": null,
    "age": null,
    "homeaddress": null,
    "medicalRecordId": 1,
    "visitdate": "2020-06-18",
    "noon": 1,
    "deptid": 1,
    "userid": 100,
    "registid": 100,
    "settleid": 100,
    "isbook": 0,
    "registertime": 1587836976547,
    "registerid": 101,
    "visitstate": 1,
    "patientid": 100,
    "patientCostsList": null
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
    "registerId": 100,
    "medicalReadme": null,
    "medicalPresent": null,
    "presentTreat": null,
    "medicalHistory": null,
    "medicalAllergy": null,
    "medicalPhysique": null,
    "medicalDiagnosis": null,
    "medicalHandling": null,
    "caseState": 2,
    "diagnosisList": null
}
```



### 4.3 新增一个检查（检验或处置）/addCheckApply

请求体：主键ID为null的检查（检验或处置）。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的检查（检验或处置）。

说明：userId, state 不需要由前台填写，由后台根据 medicalId 自动填写。即使前台填写了，也会被后台的自动填写所覆盖。

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
    "id": 1,
    "medicalId": 1,
    "creationTime": null,
    "totalSum": null,
    "objective": null,
    "userId": 100,
    "state": 1,
    "invoiceId": null,
    "checkDetailedList": []
}
```



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
    "medicalId": 1,
    "creationTime": null,
    "totalSum": null,
    "objective": null,
    "userId": 100,
    "state": 1,
    "invoiceId": null,
    "checkDetailedList": []
}
```



### 4.5 更新/保存一个检查（检验或处置）/updateCheckApply

请求体：一个主键ID非null的检查（检验或处置）。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的检查（检验或处置）。理论上返回体应该和请求体一模一样。

說明：請勿直接使用此 update 方法来直接改变 state。请使用相关的其他方法。因为直接使用 update 改变 state 缺少对数据的必要的检查。确认开出检查（检验或处置）请使用 API 4.18 confirmCheckApply。付款检查（检验或处置）请使用API 3.11 payCheckApply。

HTTP 请求示例：

```http
POST /his/DoctorController/updateCheckApply HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "medicalId": 1,
    "creationTime": null,
    "totalSum": null,
    "objective": "sdfsdfsdfsdfsdf",
    "userId": 100,
    "state": 1,
    "invoiceId": null,
    "checkDetailedList": []
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": 1,
    "creationTime": null,
    "totalSum": null,
    "objective": "sdfsdfsdfsdfsdf",
    "userId": 100,
    "state": 1,
    "invoiceId": null,
    "checkDetailedList": []
}
```



### 4.6 更新/保存一个病历 /updateMedicalRecord

请求体：一个主键ID非null的病历。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的病历。理论上返回体应该和请求体一模一样。

說明：請勿直接使用此 update 方法来改变 state。请使用相关的其他方法。因为直接使用 update 改变 state 缺少对数据的必要的检查。

HTTP 请求示例：

```http
POST /his/DoctorController/updateMedicalRecord HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "registerId": 2,
    "medicalReadme": "sdfsdfsdfsdf",
    "medicalPresent": null,
    "presentTreat": null,
    "medicalHistory": null,
    "medicalAllergy": null,
    "medicalPhysique": null,
    "medicalDiagnosis": null,
    "medicalHandling": null,
    "caseState": 2,
    "diagnosisList": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "registerId": 2,
    "medicalReadme": "sdfsdfsdfsdf",
    "medicalPresent": null,
    "presentTreat": null,
    "medicalHistory": null,
    "medicalAllergy": null,
    "medicalPhysique": null,
    "medicalDiagnosis": null,
    "medicalHandling": null,
    "caseState": 2,
    "diagnosisList": null
}
```



### 4.7 新增一个处方 /addPrescription

请求体：主键ID为null的处方。请求体的字段可以不完整，只需要一些关键必须的字段即可。id 也可以直接省略。

返回：新增成功后返回主键ID非null的字段完整的处方。

说明：userid 不需要由前台填写，由后台根据 medicalId 自动填写。即使前台填写了，也会被后台的自动填写所覆盖。

HTTP 请求示例：

```http
POST /his/DoctorController/addPrescription HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"medicalId":200
}
```

HTTP 响应示例：

```json
{
    "id": 200,
    "medicalId": 200,
    "userId": 100,
    "prescriptionName": null,
    "prescriptionState": 1,
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

说明：請勿直接使用此 update 方法来直接改变 prescriptionState。请使用相关的其他方法。



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

说明：deptid, price 不需要由前台填写，由后台根据 checkprojid 自动填写。即使前台填写了，也会被后台的自动填写所覆盖。

HTTP 请求示例：

```http
POST /his/DoctorController/addCheckDetailed HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
	"checkappid": 2,
	"checkprojid":1,
	"identification":1
}
```

HTTP 响应示例：

```json
{
    "id": 5,
    "checkappid": 2,
    "checkprojid": 1,
    "deptid": 133,
    "position": null,
    "state": 1,
    "price": 200.00,
    "identification": 1,
    "inspecttime": null,
    "result": null,
    "resulttime": null,
    "operatorid": null,
    "entryclerkid": null,
    "department": null,
    "user1": null,
    "user2": null,
    "fmedItem": null
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

說明：請勿直接使用此 update 方法来改变 state。请使用相关的其他方法。因为直接使用 update 改变 state 缺少对数据的必要的检查。开始进行一项检查（检验或处置）明细 请使用 API 5.1 startCheckDetailed。结束一项检查（检验或处置）明细 请使用API 5.2 finishCheckDetailed。报告一项检查（检验或处置）明细请使用 API 5.3 finishCheckDetailed。deptid, price 不需要由前台填写，由后台根据 checkprojid 自动填写。即使前台填写了，也会被后台的自动填写所覆盖。

HTTP 请求示例：

```http
POST /his/DoctorController/updateCheckDetailed HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 6,
    "checkappid": 2,
    "checkprojid": 3,
    "deptid": 133,
    "position": null,
    "state": 1,
    "price": 200.00,
    "identification": 1,
    "inspecttime": null,
    "result": null,
    "resulttime": null,
    "operatorid": null,
    "entryclerkid": null
}
```

HTTP 响应示例：

```json
{
    "id": 6,
    "checkappid": 2,
    "checkprojid": 3,
    "deptid": 133,
    "position": null,
    "state": 1,
    "price": 80.00,
    "identification": 1,
    "inspecttime": null,
    "result": null,
    "resulttime": null,
    "operatorid": null,
    "entryclerkid": null,
    "department": null,
    "user1": null,
    "user2": null,
    "fmedItem": null
}
```



### 4.13 新增一条处方明细 /addPrescriptionDetailed

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



### 4.14 通过主键ID获取一个处方明细 /getPrescriptionDetailedById

参数：处方明细的主键ID `id`

返回：处方明细

HTTP 请求示例：

```http
GET /his/DoctorController/getPrescriptionDetailedById?id=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "prescriptionid": 1,
    "drugsid": 1,
    "useage": "1",
    "dosage": "1",
    "frequency": "1",
    "price": 1.00,
    "quantity": 1,
    "drugs": null
}
```









### 4.15 更新/保存一个处方明细 /updatePrescriptionDetailed

请求体：一个主键ID非null的处方明细。所有字段必须完整，否则会被null取代。

返回：更新/保存成功后返回保存后的处方明细。理论上返回体应该和请求体一模一样。

HTTP 请求示例：

```http
POST /his/DoctorController/updatePrescriptionDetailed HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id": 1,
    "prescriptionid": 1,
    "drugsid": 1,
    "useage": "1",
    "dosage": "1",
    "frequency": "10000000",
    "price": 1.00,
    "quantity": 1,
    "drugs": null
}
```

HTTP 响应示例：

```json
{
    "id": 1,
    "prescriptionid": 1,
    "drugsid": 1,
    "useage": "1",
    "dosage": "1",
    "frequency": "10000000",
    "price": 1.00,
    "quantity": 1,
    "drugs": null
}
```



### 4.16 根据多个条件获取检查（检验或处置）列表 /getCheckAppliesByConditions

参数：如果参数为null或省略，表示该条件不设限。

```java
userId;//开立医生的医院员工主键ID
state;//检查（检验或处置）状态
registrtionId;//挂号主键ID
```

返回：符合条件的检查（检验或处置）的列表

HTTP 请求示例：

```http
GET /his/DoctorController/getCheckAppliesByConditions?userId=1&state=1&registrationId=1 HTTP/1.1
Host: localhost:9002




```

HTTP 响应示例：

```json
[
    {
        "id": 2,
        "medicalId": 1,
        "creationTime": null,
        "totalSum": null,
        "objective": null,
        "userId": 1,
        "state": 1,
        "invoiceId": null,
        "checkDetailedList": [
            {
                "id": 4,
                "checkappid": 2,
                "checkprojid": 1,
                "deptid": 133,
                "position": null,
                "state": 1,
                "price": 200.00,
                "identification": 1,
                "inspecttime": null,
                "result": null,
                "resulttime": null,
                "operatorid": null,
                "entryclerkid": null,
                "department": null,
                "user1": null,
                "user2": null,
                "fmedItem": null
            },
            {
                "id": 5,
                "checkappid": 2,
                "checkprojid": 1,
                "deptid": 133,
                "position": null,
                "state": 1,
                "price": 200.00,
                "identification": 1,
                "inspecttime": null,
                "result": null,
                "resulttime": null,
                "operatorid": null,
                "entryclerkid": null,
                "department": null,
                "user1": null,
                "user2": null,
                "fmedItem": null
            },
            {
                "id": 6,
                "checkappid": 2,
                "checkprojid": 3,
                "deptid": 133,
                "position": null,
                "state": 1,
                "price": 80.00,
                "identification": 1,
                "inspecttime": null,
                "result": null,
                "resulttime": null,
                "operatorid": null,
                "entryclerkid": null,
                "department": null,
                "user1": null,
                "user2": null,
                "fmedItem": null
            }
        ],
        "register": null
    }
]
```





### 4.17 根据多个条件获取处方列表 /getPrescriptionsByConditions

参数：如果参数为null或省略，表示该条件不设限。

```java
userId;//开立医生的医院员工主键ID
prescriptionState;//处方状态
```

返回：符合条件的处方的列表

HTTP 请求示例：

```http
GET /his/DoctorController/getPrescriptionsByConditions?userId=1&prescriptionState=1 HTTP/1.1
Host: localhost:9002

```

HTTP 响应示例：

```json
[
    {
        "id": 2,
        "medicalId": null,
        "userId": 1,
        "prescriptionName": null,
        "prescriptionState": 1,
        "prescriptionTime": null,
        "invoiceId": null,
        "prescriptionDetailedList": []
    }
]
```



### 4.18 确认开出检查（检验或处置） /confirmCheckApply

请求参数：检查（检验或处置）主键ID `checkApplyId`

说明：此方法将检查（检验或处置）状态由“1-编辑中"变为“2 - 已开立并发出，未收费”。

返回：状态改变后的检查（检验或处置）

HTTP 请求示例：

```http
POST /his/DoctorController/confirmCheckApply?checkApplyId=200 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 200,
    "medicalId": 200,
    "creationTime": null,
    "totalSum": null,
    "objective": null,
    "userId": 100,
    "state": 2,
    "invoiceId": null,
    "checkDetailedList": []
}
```





### 4.19 根据多个条件获取病历列表 /getMedicalRecordsByConditions

参数：如果参数为null或省略，表示该条件不设限。

```java
userId;//医生的医院员工主键ID
patientId;//患者的主键ID
registrationId;//挂号的主键ID
caseState;//病历状态
```

返回：符合条件的病历的列表

HTTP 请求示例：

```http
GET /his/DoctorController/getMedicalRecordsByConditions?userId=104&patientId=1&registrationId=1&caseState=2 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
[
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
        "caseState": 2,
        "diagnosisList": []
    }
]
```







### 4.20 诊毕 /finishDiagnosis

请求参数：病历主键ID `medicalRecordId`

说明：此方法将病历的状态由“2 - 进行中"变为“3 - 已完成/诊毕；”。同时还将对应挂号的状态由“1 - 进行中"变为“2 - 诊毕；”。

返回：状态改变后的病历



HTTP 请求示例：

```http
POST /his/DoctorController/finishDiagnosis?medicalRecordId=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "registerId": 1,
    "medicalReadme": "zhusu拉開距離；看；扣水電費；看；sdfL空間樓上的積分來看；sdf",
    "medicalPresent": "xianbingshilkjlsdjfljsdlfj",
    "presentTreat": "xianbingzhiliaoqingkuang\nsdflkjljljljlsjdlkfjaslkfjlasjflasjf",
    "medicalHistory": "jiwangshi........flj快速減肥歷史記錄附件四六級法拉盛ljslfjlsjlfjslsfllsjdfkljslkfjslfjsdfljlsadfjljljljdlfjlsjflsdfklklksjflskfjlsdjflasfj施蒂利克據了解來說絕對發鏈接愛上了對方盡量少打瘋了落實到附近來開始幾多分了兩件事來得及發索拉卡東方嘉盛了發動機",
    "medicalAllergy": "guomingshi",
    "medicalPhysique": "tigejiancha",
    "medicalDiagnosis": "zhenduanjieguo",
    "medicalHandling": "chuliyijian",
    "caseState": 3,
    "diagnosisList": [
        {
            "id": 1,
            "medicalid": 1,
            "diseaseid": 1,
            "disease": {
                "id": 1,
                "diseasecode": "GDXHL",
                "diseasename": "古典型霍乱",
                "diseaseicd": "A00.051",
                "diseasetype": "140"
            }
        },
        {
            "id": 2,
            "medicalid": 1,
            "diseaseid": 2,
            "disease": {
                "id": 2,
                "diseasecode": "ZXDXHL",
                "diseasename": "中型[典型]霍乱",
                "diseaseicd": "A00.052",
                "diseasetype": "140"
            }
        }
      
    ]
}
```

### 4.21 确认开出处方 /confirmPrescription

请求参数：处方主键ID `prescriptionId`

说明：此方法将处方状态由“1-编辑中"变为“2 - 已开立并发出，未收费”。

返回：状态改变后的处方

HTTP 请求示例：

```http
POST /his/DoctorController/confirmPrescription?prescriptionId=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": 1,
    "userId": 1,
    "prescriptionName": "處方名稱",
    "prescriptionState": 2,
    "prescriptionTime": 1589397027918,
    "invoiceId": null,
    "prescriptionDetailedList": null
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







## 5. 门诊医技工作站 /MedicalTechnologyController



### 5.1 开始进行一项检查（检验或处置）明细 /startCheckDetailed

请求参数：检查（检验或处置）明细主键 ID `checkDetailedId`

说明：此方法将此检查（检验或处置）明细的状态由“1 - 未检验检查处置”变为"2 - 检验检查处置中"。

返回：状态改变后的检查（检验或处置）明细。

HTTP 请求示例：

```http
POST /his/MedicalTechnologyController/startCheckDetailed?checkDetailedId=2 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 2,
    "checkappid": 200,
    "checkprojid": 1,
    "deptid": null,
    "position": null,
    "state": 2,
    "price": null,
    "identification": 1,
    "inspecttime": null,
    "result": null,
    "resulttime": null,
    "operatorid": null,
    "entryclerkid": null
}
```



### 5.2 结束一项检查（检验或处置）明细 /finishCheckDetailed

请求参数：检查（检验或处置）明细主键 ID `checkDetailedId`

说明：此方法将此检查（检验或处置）明细的状态由“2 - 检验检查处置中”变为"3 - 检验检查处置完成，结果未出"。

返回：状态改变后的检查（检验或处置）明细。



HTTP 请求示例：

```http
POST /his/MedicalTechnologyController/finishCheckDetailed?checkDetailedId=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "checkappid": 200,
    "checkprojid": 1,
    "deptid": null,
    "position": null,
    "state": 3,
    "price": null,
    "identification": 1,
    "inspecttime": null,
    "result": null,
    "resulttime": null,
    "operatorid": null,
    "entryclerkid": null
}
```



### 5.3 报告一项检查（检验或处置）明细 /reportCheckDetailed

请求参数：检查（检验或处置）明细主键 ID `checkDetailedId`

说明：此方法将此检查（检验或处置）明细的状态由“3 - 检验检查处置完成，结果未出”变为"4 - 结果已出"。此方法会检查该 CheckApply 下面所有的 CheckDetailed 是否全部都是结果已出。如果是，则将CheckApply的状态设为 "5 - 检验检查处置已完成，结果已出"。

返回：状态改变后的检查（检验或处置）明细。



HTTP 请求示例：

```http
POST /his/MedicalTechnologyController/reportCheckDetailed?checkDetailedId=3 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 3,
    "checkappid": 200,
    "checkprojid": 2,
    "deptid": null,
    "position": null,
    "state": 4,
    "price": null,
    "identification": 1,
    "inspecttime": null,
    "result": null,
    "resulttime": null,
    "operatorid": null,
    "entryclerkid": null
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





## 6. 门诊药房工作站 /PharmacyController



### 6.1 发药 /dispenseMedicine

请求参数：处方主键ID `prescriptionId`

说明：此方法将处方状态由“3 - 已收费，未取药" 变为 “4 - 已取药”。

返回：状态改变后的处方

HTTP 请求示例：

```http
POST /his/PharmacyController/dispenseMedicine?prescriptionId=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": 1,
    "userId": 1,
    "prescriptionName": "處方名稱",
    "prescriptionState": 4,
    "prescriptionTime": 1589397027918,
    "invoiceId": null,
    "prescriptionDetailedList": null
}
```

### 6.1 退药 /returnMedicine

请求参数：处方主键ID `prescriptionId`

说明：此方法将处方状态由 “4 - 已取药”，未取药" 变为"5 - 已退药”。

返回：状态改变后的处方

HTTP 请求示例：

```http
POST /his/PharmacyController/returnMedicine?prescriptionId=1 HTTP/1.1
Host: localhost:9002



```

HTTP 响应示例：

```json
{
    "id": 1,
    "medicalId": 1,
    "userId": 1,
    "prescriptionName": "處方名稱",
    "prescriptionState": 5,
    "prescriptionTime": 1589397027918,
    "invoiceId": null,
    "prescriptionDetailedList": []
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







