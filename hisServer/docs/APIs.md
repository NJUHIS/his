# APIs 文檔

By Paul 

⚠️‼️注意事项

1. 用 IntelliJ IDEA 打开此项目时，请確保安装有 lombok 插件。
2. 实体对象的说明文档请查阅 models.md。
3. 強烈建議使用 Typora （或其他合适的工具） 阅读此文档所提及的其他文档，因为直接在 IntelliJ IDEA 打开的显示效果非常不尽人意，同时并不保证在 IntelliJ IDEA 的显示效果。其他 Markdown 文件同理。
4. HTTP 请求示例可以在 hisServer/src/test/java/com/njuhis/his/controller_http_tests 中找到，并可以直接运行。
5. 本文档与所提及的其他文档作为前后端的最重要的协议文件，会不断更新与完善，请密切关注。

## 1. 基础信息管理 /basicInfo
###1.1 获取所有科室 /getAllDepartments

参数：无

返回：科室列表

HTTP 请求示例：

GET /his/basicInfo/getAllDepartments HTTP/1.1 
Host: localhost:9002

HTTP 响应示例：

[
  {
    "id": 1,
    "deptcode": "XXGNK",
    "deptname": "心血管内科",
    "deptcategory": "11",
    "depttypeid": 1,
    "delmark": 0
  },
  {
    "id": 2,
    "deptcode": "SJNK",
    "deptname": "神经内科",
    "deptcategory": "11",
    "depttypeid": 1,
    "delmark": 0
  }
 ]

 ### 1.2 新增一名用户/addUser

 请求体：主键ID为null的用户

 返回：主键ID非null的用户

 HTTP 请求示例：

 POST /his/basicInfo/addUser HTTP/1.1
Host: localhost:9002
Content-Type: application/json

{
    "id":null,
    "username": "MyUsername",
    "password": "MyPassword",
    "realname": "MyRealName",
    "usertypeid": 1,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registid": 1,
    "delmark": 0,
    "idnumber": "3247875"
}

 HTTP 相应示例：

{
    "id": 11,
    "username": "MyUsername",
    "password": "MyPassword",
    "realname": "MyRealName",
    "usertypeid": 1,
    "doctitleid": 1,
    "isscheduling": 1,
    "deptid": 3,
    "registid": 1,
    "delmark": 0,
    "idnumber": "3247875"
}



## 2. 个人信息管理 /personalInfo

### 2.1 新增/註冊一名患者 /addPatient

请求体：主键ID为null的患者

返回：主键ID非null的患者

 HTTP 请求示例：

POST /his/personalInfo/addPatient HTTP/1.1
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

HTTP 响应示例：

{

​    "id": null,
​    "name": "MyName",
​    "idnumber": "idnumber23434",
​    "phone": "phone234234",
​    "loginname": "Myloginname",
​    "password": "Mypassword"

}

注意：此API中的主键id更新暂时未实现。

















 





