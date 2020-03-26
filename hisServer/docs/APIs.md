# APIs 文檔
## 1.基础信息管理 /basicInfo
###1.1 获取所有科室 /getAllDepartments

参数：无

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
 
 




