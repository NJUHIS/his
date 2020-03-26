# APIs 文檔

⚠️‼️注意事项

1. 用 IntelliJ IDEA 打开此项目时，请確保安装有 lombok 插件。
2. 实体对象的说明文档请查阅 models.md。
3. 強烈建議使用 Typora （或其他合适的工具） 阅读此文档，因为直接在 IntelliJ IDEA 打开的显示效果非常不尽人意，同时并不保证在 IntelliJ IDEA 的显示效果。其他 Markdown 文件同理。

## 1.基础信息管理 /basicInfo
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

 ### 1.2 新增一名医生/addDoctor

 请求体：没有id的医生

 返回：有id的医生

 HTTP 请求示例：

 POST /his/basicInfo/addDoctor HTTP/1.1
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

 HTTP 返回示例：

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







 





