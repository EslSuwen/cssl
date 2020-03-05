
**Api Documentation**


**简介**：<p>Author</p>


**HOST**:localhost:8090

**联系人**:Suwen

**Version**:v0.6

**接口路径**：/api-docs


# (项目卡片)实验项目-控制器

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
[
	{
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

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|iid| 实验项目编号  |string  |    |
|proId| 项目(实验卡片)ID  |integer(int32)  | integer(int32)   |
|iname| 实验项目名称  |string  |    |
|itype| 实验类型  |string  |    |
|itime| 实验项目学时  |integer(int32)  | integer(int32)   |
|ctype| 必修或选修  |string  |    |
|num| 分组人数  |integer(int32)  | integer(int32)   |
|intend| 实验目的  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ProjectItem|
## addNewProjectItem


**接口描述**:


**接口地址**:`/projectItem/newProjectItem`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"iid": "",
	"proId": 0,
	"iname": "",
	"itype": "",
	"itime": 0,
	"ctype": "",
	"num": 0,
	"intend": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|projectItem| (实验卡片)实验项目实体  | body | true |ProjectItem  | ProjectItem   |

**schema属性说明**



**ProjectItem**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
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

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
# 实验室安排-控制器
## addArrange


**接口描述**:


**接口地址**:`/arrange/add`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"aid": 0,
	"labId": "",
	"proId": 0,
	"tid": "",
	"courseId": 0,
	"labClass": "",
	"labRemark": "",
	"arrangePeriod": [
		{
			"aid": 0,
			"expProname": "",
			"labDay": 0,
			"labSession": 0,
			"labWeek": 0
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
|tid| 教职工号  | body | true |string  |    |
|courseId| 课程号  | body | true |integer(int32)  |    |
|labClass| 班级  | body | true |string  |    |
|labRemark| 备注  | body | true |string  |    |
|arrangePeriod| 排课时间  | body | true |array  | ArrangePeriod   |

**ArrangePeriod**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|aid| 实验室排课编号  | body | true |integer(int32)  |    |
|expProname| 实验项目名称  | body | false |string  |    |
|labDay| 开课星期  | body | true |integer(int32)  |    |
|labSession| 开课节次  | body | true |integer(int32)  |    |
|labWeek| 开课周次  | body | true |integer(int32)  |    |

**响应示例**:

```json
{
	"msg": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|msg| 消息  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Message|
## getArrange


**接口描述**:


**接口地址**:`/arrange/getInfo/{tid}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|tid| tid  | path | true |string  |    |

**响应示例**:

```json
[
	{
		"aid": 0,
		"labId": "",
		"proId": 0,
		"tid": "",
		"courseId": 0,
		"labClass": "",
		"labRemark": "",
		"arrangePeriod": [
			{
				"aid": 0,
				"expProname": "",
				"labDay": 0,
				"labSession": 0,
				"labWeek": 0
			}
		]
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|aid| 实验室排课编号  |integer(int32)  | integer(int32)   |
|labId| 实验室编号  |string  |    |
|proId| 项目ID  |integer(int32)  | integer(int32)   |
|tid| 教职工号  |string  |    |
|courseId| 课程号  |integer(int32)  | integer(int32)   |
|labClass| 班级  |string  |    |
|labRemark| 备注  |string  |    |
|arrangePeriod| 排课时间  |array  | ArrangePeriod   |



**schema属性说明**




**ArrangePeriod**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|aid | 实验室排课编号   |integer(int32)  |    |
|expProname | 实验项目名称   |string  |    |
|labDay | 开课星期   |integer(int32)  |    |
|labSession | 开课节次   |integer(int32)  |    |
|labWeek | 开课周次   |integer(int32)  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Arrange|
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
[
	{
		"tid": "",
		"courseId": 0,
		"applyLimit": 0,
		"courseName": "",
		"status": "",
		"labId": ""
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|tid| 教职工号  |string  |    |
|courseId| 课程号  |integer(int32)  | integer(int32)   |
|applyLimit| 实验室申请权限  |integer(int32)  | integer(int32)   |
|courseName| 课程名  |string  |    |
|status| 课程实验室申请状态  |string  |    |
|labId| 课程实验室编号  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Teach|
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
# 用户信息-控制器

## getAllInfo


**接口描述**:


**接口地址**:`/user/getAllInfo`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
[
	{
		"userName": "",
		"userNo": "",
		"userPwd": ""
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|userName|   |string  |    |
|userNo|   |string  |    |
|userPwd|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |User|
## getInfo


**接口描述**:


**接口地址**:`/user/getInfo`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"userName": "",
	"userNo": "",
	"userPwd": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|userName|   |string  |    |
|userNo|   |string  |    |
|userPwd|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |User|
## update


**接口描述**:


**接口地址**:`/user/update`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userName|   | query | false |string  |    |
|userNo|   | query | false |string  |    |
|userPwd|   | query | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
# 用户安全登录-控制器

## createImageCode


**接口描述**:


**接口地址**:`/security/createImageCode`


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
## toLogin


**接口描述**:


**接口地址**:`/security/login/{imageCode}`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"userName": "",
	"userNo": "",
	"userPwd": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|imageCode| imageCode  | path | true |string  |    |
|user| user  | body | true |User  | User   |

**schema属性说明**



**User**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userName|   | body | false |string  |    |
|userNo|   | body | false |string  |    |
|userPwd|   | body | false |string  |    |

**响应示例**:

```json
{
	"msg": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|msg| 消息  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Message|
## logout


**接口描述**:


**接口地址**:`/security/logout`


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
# 用户测试-控制器

## clearDemodatas


**接口描述**:


**接口地址**:`/test_user/clearUser`


**请求方式**：`DELETE`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"msg": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|msg| 消息  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Message|
## getUsers


**接口描述**:


**接口地址**:`/test_user/getUser`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
[
	{
		"userName": "",
		"userNo": "",
		"userPwd": ""
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|userName|   |string  |    |
|userNo|   |string  |    |
|userPwd|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |User|
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
	"username": "",
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
|username| 用户名[用户账号]  | body | true |string  |    |
|password| 用户密码  | body | true |string  |    |
|imgCode| 用户密码  | body | true |string  |    |

**响应示例**:

```json
{
	"token": "",
	"message": {
		"msg": ""
	}
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|token| 验证[验证失败为空]  |string  |    |
|message| 错误消息  |Message  | Message   |



**schema属性说明**




**Message**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|msg | 消息   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |AuthenticationResponse|
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

## clearProject


**接口描述**:


**接口地址**:`/project/clearProject`


**请求方式**：`DELETE`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"msg": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|msg| 消息  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Message|
## getProjects


**接口描述**:


**接口地址**:`/project/getProject`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
[
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
		"conName": "",
		"conNum": 0
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|proId| 专业ID  |integer(int32)  | integer(int32)   |
|labCenName| 实验室（中心）名称  |string  |    |
|expCname| 实验课程名  |string  |    |
|expEqname| 实验设备名  |string  |    |
|eqnum| 设备数量  |integer(int32)  | integer(int32)   |
|expMajor| 面向专业  |string  |    |
|ssort| 学生类别  |string  |    |
|expTime| 实验总学时  |integer(int32)  | integer(int32)   |
|book| 实验教材  |string  |    |
|software| 实验所用软件  |string  |    |
|expTid| 教职工号  |string  |    |
|cname| 课程名  |string  |    |
|conName| 消耗材料名称  |string  |    |
|conNum| 消耗材料数量  |integer(int32)  | integer(int32)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ExpProject|
## addNewProject


**接口描述**:


**接口地址**:`/project/newProject`


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
	"conName": "",
	"conNum": 0
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
|proId| 专业ID  | body | true |integer(int32)  |    |
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
|conName| 消耗材料名称  | body | false |string  |    |
|conNum| 消耗材料数量  | body | false |integer(int32)  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
