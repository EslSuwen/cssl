
**Api Documentation**


**简介**：<p>Author</p>


**HOST**:localhost:8090

**联系人**:Suwen

**Version**:v1.0-Alpha

**接口路径**：/api-docs


# 实验室信息-控制器

## getLabById


**接口描述**:


**接口地址**:`/lab/getLab`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|labId| 实验室编号  | query | true |integer  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getLabByTypeId


**接口描述**:


**接口地址**:`/lab/getLabByTypeId`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|typeId| 实验室类型编号  | query | true |integer  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getLabByTypeIdCampus


**接口描述**:


**接口地址**:`/lab/getLabByTypeIdCampus`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|campus| 校区  | query | true |string  |    |
|typeId| 实验室类型编号  | query | true |integer  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
# 实验室安排-控制器
## addArrange


**接口描述**:


**接口地址**:`/arrange/addArrange`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"aid": 0,
	"labId": "",
	"proId": 0,
	"campus": "",
	"status": "",
	"labClass": "",
	"courseId": "",
	"tid": "",
	"expProname": "",
	"labRemark": "",
	"arrangePeriod": [
		{
			"aid": 0,
			"labWeek": 0,
			"labDay": 0,
			"labSession": 0
		}
	]
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|arrange| 实验室安排实体  | body | true |Arrange  | Arrange   |

**schema属性说明**



**Arrange**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|aid| 实验室排课编号  | body | false |integer(int32)  |    |
|labId| 实验室编号  | body | true |string  |    |
|proId| 项目ID  | body | true |integer(int32)  |    |
|campus| 实验室校区  | body | true |string  |    |
|status| 申请状态,可用值:UNCHECK,AUDITING,PASS,FAIL  | body | true |string  |    |
|labClass| 班级  | body | true |string  |    |
|courseId| 课程编号  | body | true |string  |    |
|tid| 教职工号  | body | true |string  |    |
|expProname| 实验项目名称  | body | false |string  |    |
|labRemark| 备注  | body | true |string  |    |
|arrangePeriod| 排课时间  | body | true |array  | ArrangePeriod   |

**ArrangePeriod**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|aid| 实验室排课编号  | body | true |integer(int32)  |    |
|labWeek| 开课周次  | body | true |integer(int32)  |    |
|labDay| 开课星期  | body | true |integer(int32)  |    |
|labSession| 开课节次  | body | true |integer(int32)  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## auditArrange


**接口描述**:


**接口地址**:`/arrange/auditArrange`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|aid| 安排编号  | query | true |integer  |    |
|status| 审核状态,可用值:UNCHECK,AUDITING,PASS,FAIL  | query | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getAuditArrange


**接口描述**:


**接口地址**:`/arrange/getAuditArrange`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getArrange


**接口描述**:


**接口地址**:`/arrange/getInfo/{tid}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|tid| 教师编号  | path | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getTeachingPlanList


**接口描述**:


**接口地址**:`/arrange/getTeachingPlan`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getTeachingPlanExcel


**接口描述**:


**接口地址**:`/arrange/getTeachingPlanExcel`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
# 实验项目-控制器

## addNewProjectItem


**接口描述**:


**接口地址**:`/projectItem/addProjectItems`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
[
	{
		"ino": "",
		"iid": "",
		"proId": 0,
		"iname": "",
		"itype": "",
		"itime": 0,
		"ctype": "",
		"num": 0,
		"intend": ""
	}
]
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|projectItems| (实验卡片)实验项目实体  | body | true |array  | ProjectItem   |

**schema属性说明**



**ProjectItem**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|ino| 实验项目id  | body | false |string  |    |
|iid| 实验项目编号  | body | true |string  |    |
|proId| 项目(实验卡片)ID  | body | true |integer(int32)  |    |
|iname| 实验项目名称  | body | true |string  |    |
|itype| 实验类型  | body | true |string  |    |
|itime| 实验项目学时  | body | true |integer(int32)  |    |
|ctype| 必修或选修  | body | true |string  |    |
|num| 分组人数  | body | true |integer(int32)  |    |
|intend| 实验目的  | body | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getProjectItem


**接口描述**:


**接口地址**:`/projectItem/getProjectItem/{proId}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|proId| proId  | path | true |integer  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
# 授课信息-控制器

## getTeachInfo


**接口描述**:


**接口地址**:`/teach/getTeachInfo/{tid}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|tid| tid  | path | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
# 教师信息-控制器

## deleteMsg


**接口描述**:


**接口地址**:`/teacher/deleteMsg/{mid}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|mid| 消息编号  | path | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getCurriculum


**接口描述**:


**接口地址**:`/teacher/getCurriculum`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|tid| 教师编号  | query | true |string  |    |
|week| 周次  | query | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getMsgInfo


**接口描述**:


**接口地址**:`/teacher/getMsgInfo/{tid}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|tid| 教师编号  | path | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getTeacherInfo


**接口描述**:


**接口地址**:`/teacher/getTeacherInfo/{tid}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|tid| tid  | path | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## readMsg


**接口描述**:


**接口地址**:`/teacher/readMsg/{mid}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|mid| mid  | path | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## updatePassword


**接口描述**:


**接口地址**:`/teacher/updatePassword`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|newPw| 新密码  | query | true |string  |    |
|oldPw| 当前密码  | query | true |string  |    |
|tid| 教师编号  | query | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
# 文件传输测试-控制器

## getFile


**接口描述**:


**接口地址**:`/file/file`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
## getImage


**接口描述**:


**接口地址**:`/file/getImage`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
## upload


**接口描述**:


**接口地址**:`/file/upload`


**请求方式**：`POST`


**consumes**:`["multipart/form-data"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|file| file  | formData | true |file  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
# 用户验证-控制器

## 用户验证

**接口描述**:进行用户验证，成功返回 token,失败返回空。

**接口地址**:`/api/auth`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["application/json"]`


**请求示例**：
```json
{
	"userNo": "",
	"password": "",
	"imgCode": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authRequest| 验证请求接收实体  | body | true |AuthenticationRequest  | AuthenticationRequest   |

**schema属性说明**



**AuthenticationRequest**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userNo| 用户账号  | body | true |string  |    |
|password| 用户密码  | body | true |string  |    |
|imgCode| 登录验证码  | body | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## 生成图片验证码

**接口描述**:生成图片验证码并保存在 session 中。

**接口地址**:`/api/createImageCode`


**请求方式**：`GET`


**consumes**:``


**produces**:`["application/json"]`



**请求参数**：
暂无



**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
# 项目卡片-控制器

## addNewProject


**接口描述**:


**接口地址**:`/project/addProject`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"proId": 0,
	"labCenName": "",
	"expCname": "",
	"expEqname": "",
	"eqnum": 0,
	"expMajor": "",
	"ssort": "",
	"expTime": 0,
	"book": "",
	"software": "",
	"expTid": "",
	"cname": "",
	"courseId": "",
	"conName": "",
	"conNum": 0,
	"status": "",
	"labStatus": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|expProject| 项目实体  | body | true |ExpProject  | ExpProject   |

**schema属性说明**



**ExpProject**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|proId| 项目ID  | body | true |integer(int32)  |    |
|labCenName| 实验室（中心）名称  | body | true |string  |    |
|expCname| 实验课程名  | body | true |string  |    |
|expEqname| 实验设备名  | body | true |string  |    |
|eqnum| 设备数量  | body | true |integer(int32)  |    |
|expMajor| 面向专业  | body | true |string  |    |
|ssort| 学生类别  | body | true |string  |    |
|expTime| 实验总学时  | body | true |integer(int32)  |    |
|book| 实验教材  | body | true |string  |    |
|software| 实验所用软件  | body | true |string  |    |
|expTid| 教职工号  | body | true |string  |    |
|cname| 课程名  | body | true |string  |    |
|courseId| 课程编号  | body | true |string  |    |
|conName| 消耗材料名称  | body | false |string  |    |
|conNum| 消耗材料数量  | body | false |integer(int32)  |    |
|status| 申请状态,可用值:UNCHECK,AUDITING,PASS,FAIL  | body | false |string  |    |
|labStatus| 申请实验室状态,可用值:UNCHECK,AUDITING,PASS,FAIL  | body | false |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## auditProject


**接口描述**:


**接口地址**:`/project/auditProject`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|proId| 项目卡片编号  | query | true |string  |    |
|status| 审核状态,可用值:UNCHECK,AUDITING,PASS,FAIL  | query | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## deleteProject


**接口描述**:


**接口地址**:`/project/deleteProject`


**请求方式**：`DELETE`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|proId| 项目卡片编号  | query | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getAuditProjects


**接口描述**:


**接口地址**:`/project/getAuditProject`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
## getProjects


**接口描述**:


**接口地址**:`/project/getProject/{tid}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|tid| tid  | path | true |string  |    |

**响应示例**:

```json
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |string  |    |
|data|   |object  |    |
|message|   |string  |    |
|success|   |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ResultDto|
