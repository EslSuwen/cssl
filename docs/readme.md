# Api Documentation


**简介**:Api Documentation


**HOST**:localhost:8090


**联系人**:Suwen


**Version**:v2.0-Beta


**接口路径**:/api-docs


[TOC]






# 实验室信息-控制器


## getLabById


**接口地址**:`/cssl/lab/getLab`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|labId|实验室编号|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getLabByProId


**接口地址**:`/cssl/lab/getLabByProId`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|proId|项目编号|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getLabByTypeId


**接口地址**:`/cssl/lab/getLabByTypeId`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|typeId|实验室类型编号|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getLabByTypeIdCampus


**接口地址**:`/cssl/lab/getLabByTypeIdCampus`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|campus|校区|query|true|string||
|typeId|实验室类型编号|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


# 实验室安排-控制器


## ifAddArrange


**接口地址**:`/cssl/arrange/AddArrange`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"aid": 0,
	"labId": "",
	"proId": 0,
	"campus": "",
	"labClass": "",
	"courseId": 0,
	"tid": "",
	"expProname": "",
	"labRemark": "",
	"labClassInfo": [
		{
			"classId": 0,
			"className": "",
			"grade": 0,
			"majorId": 0,
			"studentNum": 0
		}
	],
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


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|arrange|实验室安排实体|body|true|Arrange|Arrange|
|&emsp;&emsp;aid|实验室排课编号||false|integer(int32)||
|&emsp;&emsp;labId|实验室编号||true|string||
|&emsp;&emsp;proId|项目ID||true|integer(int32)||
|&emsp;&emsp;campus|实验室校区||true|string||
|&emsp;&emsp;labClass|班级||true|string||
|&emsp;&emsp;courseId|课程编号||true|integer(int32)||
|&emsp;&emsp;tid|教职工号||true|string||
|&emsp;&emsp;expProname|实验项目名称||false|string||
|&emsp;&emsp;labRemark|备注||true|string||
|&emsp;&emsp;labClassInfo|班级||true|array|Class|
|&emsp;&emsp;&emsp;&emsp;classId|班级编号||false|integer(int32)||
|&emsp;&emsp;&emsp;&emsp;className|班级名称||true|string||
|&emsp;&emsp;&emsp;&emsp;grade|年级||false|integer(int32)||
|&emsp;&emsp;&emsp;&emsp;majorId|专业Id||true|integer(int32)||
|&emsp;&emsp;&emsp;&emsp;studentNum|班级人数||true|integer(int32)||
|&emsp;&emsp;arrangePeriod|排课时间||true|array|ArrangePeriod|
|&emsp;&emsp;&emsp;&emsp;aid|实验室排课编号||true|integer(int32)||
|&emsp;&emsp;&emsp;&emsp;labWeek|开课周次||true|integer(int32)||
|&emsp;&emsp;&emsp;&emsp;labDay|开课星期||true|integer(int32)||
|&emsp;&emsp;&emsp;&emsp;labSession|开课节次||true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getClassByGrade


**接口地址**:`/cssl/arrange/getClassByGrade/{grade}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|grade|grade|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getArrange


**接口地址**:`/cssl/arrange/getInfo/{tid}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|教师编号|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getTeachingPlanList


**接口地址**:`/cssl/arrange/getTeachingPlan`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getTeachingPlanExcel


**接口地址**:`/cssl/arrange/getTeachingPlanExcel`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||


**响应参数**:


暂无


**响应示例**:
```javascript

```


# 实验项目-控制器


## addNewProjectItem


**接口地址**:`/cssl/projectItem/addProjectItems`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
[
	{
		"ino": "",
		"iid": "",
		"proId": 0,
		"iname": "",
		"itype": "",
		"itime": 0,
		"num": 0,
		"intend": ""
	}
]
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|projectItems|(实验卡片)实验项目实体|body|true|array|ProjectItem|
|&emsp;&emsp;ino|实验项目id||false|string||
|&emsp;&emsp;iid|实验项目编号||true|string||
|&emsp;&emsp;proId|项目(实验卡片)ID||true|integer(int32)||
|&emsp;&emsp;iname|实验项目名称||true|string||
|&emsp;&emsp;itype|实验类型||true|string||
|&emsp;&emsp;itime|实验项目学时||true|integer(int32)||
|&emsp;&emsp;num|分组人数||true|integer(int32)||
|&emsp;&emsp;intend|实验目的||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## deleteExp


**接口地址**:`/cssl/projectItem/deleteExp`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ino|ino|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getProjectItem


**接口地址**:`/cssl/projectItem/getProjectItem/{proId}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|proId|proId|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## updateItem


**接口地址**:`/cssl/projectItem/updateItem`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"ino": "",
	"iid": "",
	"proId": 0,
	"iname": "",
	"itype": "",
	"itime": 0,
	"num": 0,
	"intend": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|projectItem|(实验卡片)实验项目实体|body|true|ProjectItem|ProjectItem|
|&emsp;&emsp;ino|实验项目id||false|string||
|&emsp;&emsp;iid|实验项目编号||true|string||
|&emsp;&emsp;proId|项目(实验卡片)ID||true|integer(int32)||
|&emsp;&emsp;iname|实验项目名称||true|string||
|&emsp;&emsp;itype|实验类型||true|string||
|&emsp;&emsp;itime|实验项目学时||true|integer(int32)||
|&emsp;&emsp;num|分组人数||true|integer(int32)||
|&emsp;&emsp;intend|实验目的||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


# 授课信息-控制器


## addTeaches


**接口地址**:`/cssl/teach/addTeaches`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
[
	{
		"courseName": "",
		"tid": "",
		"tname": "",
		"courseId": 0
	}
]
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|teaches|授课实体|body|true|array|Teach|
|&emsp;&emsp;courseName|课程名||false|string||
|&emsp;&emsp;tid|教职工号||true|string||
|&emsp;&emsp;tname|教职工名||false|string||
|&emsp;&emsp;courseId|课程号||true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getAvailableCourse


**接口地址**:`/cssl/teach/getAvailableCourse/{tid}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|教师编号|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getTeachByTid


**接口地址**:`/cssl/teach/getTeach/{tid}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|教师编号|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getTeachInfo


**接口地址**:`/cssl/teach/getTeachInfo`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|term|学期|query|true|string||
|tid|教师编号|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## removeTeach


**接口地址**:`/cssl/teach/removeTeach`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId|课程编号|query|true|string||
|tid|教师编号|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


# 教师信息-控制器


## addClass


**接口地址**:`/cssl/teacher/addClass`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"classId": 0,
	"className": "",
	"grade": 0,
	"majorId": 0,
	"studentNum": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|newClass|班级实体|body|true|Class|Class|
|&emsp;&emsp;classId|班级编号||false|integer(int32)||
|&emsp;&emsp;className|班级名称||true|string||
|&emsp;&emsp;grade|年级||false|integer(int32)||
|&emsp;&emsp;majorId|专业Id||true|integer(int32)||
|&emsp;&emsp;studentNum|班级人数||true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## addCurriculum


**接口地址**:`/cssl/teacher/addCurriculum`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"courseId": 0,
	"courseName": "",
	"courseType": "",
	"courseCollege": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|course|课程实体类|body|true|Course|Course|
|&emsp;&emsp;courseId|课程编号||true|integer(int32)||
|&emsp;&emsp;courseName|课程名字||true|string||
|&emsp;&emsp;courseType|课程类型||true|string||
|&emsp;&emsp;courseCollege|开课学院||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## addTeacher


**接口地址**:`/cssl/teacher/addTeacher`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"tid": "",
	"tname": "",
	"tphone": "",
	"tqq": "",
	"temail": "",
	"tpassword": "",
	"authority": 0,
	"authorities": [
		{
			"id": 0,
			"name": ""
		}
	]
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|teacher|教师实体|body|true|Teacher|Teacher|
|&emsp;&emsp;tid|教职工号||true|string||
|&emsp;&emsp;tname|教师姓名||true|string||
|&emsp;&emsp;tphone|教师电话||true|string||
|&emsp;&emsp;tqq|教师QQ||false|string||
|&emsp;&emsp;temail|教师邮箱||true|string||
|&emsp;&emsp;tpassword|密码||true|string||
|&emsp;&emsp;authority|权限等级(0:教师用户;1:管理员用户;2:管理员用户)||true|integer(int32)||
|&emsp;&emsp;authorities|用户权限列表||false|array|Authority|
|&emsp;&emsp;&emsp;&emsp;id|编号||true|integer(int64)||
|&emsp;&emsp;&emsp;&emsp;name|权限,可用值:ROLE_USER,ROLE_ADMIN,ROLE_SUPER_ADMIN||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## addTeacherMsg


**接口地址**:`/cssl/teacher/addTeacherMsg`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"mid": 0,
	"tid": "",
	"mtitle": "",
	"mresult": 0,
	"mdate": "",
	"mtext": "",
	"mstatus": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|teacherMsg|用户消息实体|body|true|TeacherMsg|TeacherMsg|
|&emsp;&emsp;mid|消息编号||true|integer(int32)||
|&emsp;&emsp;tid|教师编号||true|string||
|&emsp;&emsp;mtitle|通知标题||true|string||
|&emsp;&emsp;mresult|通知结果||true|integer(int32)||
|&emsp;&emsp;mdate|消息创建时间||true|string||
|&emsp;&emsp;mtext|消息内容||true|string||
|&emsp;&emsp;mstatus|消息状态||true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## deleteMsg


**接口地址**:`/cssl/teacher/deleteMsg/{mid}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|mid|消息编号|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getClasses


**接口地址**:`/cssl/teacher/getClass`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getCourse


**接口地址**:`/cssl/teacher/getCourse`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getCurriculum


**接口地址**:`/cssl/teacher/getCurriculum`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|教师编号|query|true|string||
|week|周次|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getMsgInfo


**接口地址**:`/cssl/teacher/getMsgInfo/{tid}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|教师编号|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getTeacher


**接口地址**:`/cssl/teacher/getTeacher`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getTeacherInfo


**接口地址**:`/cssl/teacher/getTeacherInfo/{tid}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|tid|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## ifClass


**接口地址**:`/cssl/teacher/ifClass/{classId}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|classId|classId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## ifCurriculum


**接口地址**:`/cssl/teacher/ifCurriculum/{courseId}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId|courseId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## ifTeacher


**接口地址**:`/cssl/teacher/ifTeacher/{tid}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|tid|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## readMsg


**接口地址**:`/cssl/teacher/readMsg/{mid}`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|mid|mid|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## removeClass


**接口地址**:`/cssl/teacher/removeClass/{classId}`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|classId|classId|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## removeCourse


**接口地址**:`/cssl/teacher/removeCourse/{courseId}`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId|courseId|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## removeTeacher


**接口地址**:`/cssl/teacher/removeTeacher/{tid}`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|tid|tid|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## updateClass


**接口地址**:`/cssl/teacher/updateClass`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"classId": 0,
	"className": "",
	"grade": 0,
	"majorId": 0,
	"studentNum": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|newClass|班级实体|body|true|Class|Class|
|&emsp;&emsp;classId|班级编号||false|integer(int32)||
|&emsp;&emsp;className|班级名称||true|string||
|&emsp;&emsp;grade|年级||false|integer(int32)||
|&emsp;&emsp;majorId|专业Id||true|integer(int32)||
|&emsp;&emsp;studentNum|班级人数||true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## updateCourse


**接口地址**:`/cssl/teacher/updateCourse`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"courseId": 0,
	"courseName": "",
	"courseType": "",
	"courseCollege": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|course|课程实体类|body|true|Course|Course|
|&emsp;&emsp;courseId|课程编号||true|integer(int32)||
|&emsp;&emsp;courseName|课程名字||true|string||
|&emsp;&emsp;courseType|课程类型||true|string||
|&emsp;&emsp;courseCollege|开课学院||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## updatePassword


**接口地址**:`/cssl/teacher/updatePassword`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|newPw|新密码|query|true|string||
|oldPw|当前密码|query|true|string||
|tid|教师编号|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## updateTeacher


**接口地址**:`/cssl/teacher/updateTeacher`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"tid": "",
	"tname": "",
	"tphone": "",
	"tqq": "",
	"temail": "",
	"tpassword": "",
	"authority": 0,
	"authorities": [
		{
			"id": 0,
			"name": ""
		}
	]
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|teacher|教师实体|body|true|Teacher|Teacher|
|&emsp;&emsp;tid|教职工号||true|string||
|&emsp;&emsp;tname|教师姓名||true|string||
|&emsp;&emsp;tphone|教师电话||true|string||
|&emsp;&emsp;tqq|教师QQ||false|string||
|&emsp;&emsp;temail|教师邮箱||true|string||
|&emsp;&emsp;tpassword|密码||true|string||
|&emsp;&emsp;authority|权限等级(0:教师用户;1:管理员用户;2:管理员用户)||true|integer(int32)||
|&emsp;&emsp;authorities|用户权限列表||false|array|Authority|
|&emsp;&emsp;&emsp;&emsp;id|编号||true|integer(int64)||
|&emsp;&emsp;&emsp;&emsp;name|权限,可用值:ROLE_USER,ROLE_ADMIN,ROLE_SUPER_ADMIN||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


# 用户验证-控制器


## 用户验证


**接口地址**:`/cssl/api/auth`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`application/json`


**接口描述**:进行用户验证，成功返回 token,失败返回空。


**请求示例**:


```javascript
{
	"userNo": "",
	"password": "",
	"imgCode": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|authRequest|验证请求接收实体|body|true|AuthenticationRequest|AuthenticationRequest|
|&emsp;&emsp;userNo|用户账号||true|string||
|&emsp;&emsp;password|用户密码||true|string||
|&emsp;&emsp;imgCode|登录验证码||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## 生成图片验证码


**接口地址**:`/cssl/api/createImageCode`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`application/json`


**接口描述**:生成图片验证码并保存在 session 中。


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||


**响应参数**:


暂无


**响应示例**:
```javascript

```


# 通知信息-控制器


## addNotice


**接口地址**:`/cssl/notice/addNotice`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"nid": 0,
	"noticeContent": "",
	"noticeDate": "",
	"noticeHead": "",
	"tid": "",
	"tname": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|notice|通知信息表，通知由管理员发布。|body|true|Notice对象|Notice对象|
|&emsp;&emsp;nid|通知编号||false|integer(int32)||
|&emsp;&emsp;noticeContent|通知正文||false|string||
|&emsp;&emsp;noticeDate|通知发布时间||false|string||
|&emsp;&emsp;noticeHead|通知标题||false|string||
|&emsp;&emsp;tid|通知发布人编号||false|string||
|&emsp;&emsp;tname|通知发布人姓名||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getAllNotice


**接口地址**:`/cssl/notice/getAllNotice`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getNoticeById


**接口地址**:`/cssl/notice/getNoticeById`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|nid|通知编号|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getNoticeByMap


**接口地址**:`/cssl/notice/getNoticeByMap`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|conditionsMap|conditionsMap|body|true|object||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## removeNotice


**接口地址**:`/cssl/notice/removeNotice`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|nid|通知编号|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## updateNotice


**接口地址**:`/cssl/notice/updateNotice`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"nid": 0,
	"noticeContent": "",
	"noticeDate": "",
	"noticeHead": "",
	"tid": "",
	"tname": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|notice|通知信息表，通知由管理员发布。|body|true|Notice对象|Notice对象|
|&emsp;&emsp;nid|通知编号||false|integer(int32)||
|&emsp;&emsp;noticeContent|通知正文||false|string||
|&emsp;&emsp;noticeDate|通知发布时间||false|string||
|&emsp;&emsp;noticeHead|通知标题||false|string||
|&emsp;&emsp;tid|通知发布人编号||false|string||
|&emsp;&emsp;tname|通知发布人姓名||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


# 通知文件-控制器


## add


**接口地址**:`/cssl/noticeFile/add`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|nFile|nFile|formData|true|file||
|fileDate|通知文件发布时间|query|false|string||
|fileId|通知文件编号|query|false|integer(int32)||
|fileName|通知文件名|query|false|string||
|filePath|通知文件路径|query|false|string||
|tid|通知发布人编号|query|false|integer(int32)||
|tname|通知发布人编号|query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getAll


**接口地址**:`/cssl/noticeFile/getAll`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getById


**接口地址**:`/cssl/noticeFile/getById/{id}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getFileDownload


**接口地址**:`/cssl/noticeFile/getFile/{fileId}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|fileId|fileId|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## remove


**接口地址**:`/cssl/noticeFile/remove/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


# 项目卡片-控制器


## addExpClass


**接口地址**:`/cssl/project/addExpClass`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
[
	{
		"classId": 0,
		"className": "",
		"proId": 0
	}
]
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|expClassList|项目班级|body|true|array|ExpClass对象|
|&emsp;&emsp;classId|班级编号||false|integer(int32)||
|&emsp;&emsp;className|班级编号||false|string||
|&emsp;&emsp;proId|项目编号||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## addNewProject


**接口地址**:`/cssl/project/addProject`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"book": "",
	"conName": "",
	"conNum": 0,
	"courseId": 0,
	"courseName": "",
	"eqnum": 0,
	"expCname": "",
	"expEqname": "",
	"expTid": "",
	"expTime": 0,
	"labStatus": "",
	"proId": 0,
	"software": "",
	"term": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|expProject|项目(实验卡片)|body|true|ExpProject对象|ExpProject对象|
|&emsp;&emsp;book|实验教材||false|string||
|&emsp;&emsp;conName|消耗材料名称||false|string||
|&emsp;&emsp;conNum|消耗材料数量||false|integer(int32)||
|&emsp;&emsp;courseId|课程编号||false|integer(int32)||
|&emsp;&emsp;courseName|实验课程名||false|string||
|&emsp;&emsp;eqnum|设备数量||false|integer(int32)||
|&emsp;&emsp;expCname|实验课程名||false|string||
|&emsp;&emsp;expEqname|实验设备名||false|string||
|&emsp;&emsp;expTid|授课教师编号||false|string||
|&emsp;&emsp;expTime|实验总学时||false|integer(int32)||
|&emsp;&emsp;labStatus|申请实验室状态,可用值:UNCHECK,AUDITING,PASS,FAIL||false|string||
|&emsp;&emsp;proId|项目编号||false|integer(int32)||
|&emsp;&emsp;software|实验所用软件||false|string||
|&emsp;&emsp;term|学期||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## deleteExp


**接口地址**:`/cssl/project/deleteExp`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|proId|proId|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## deleteProject


**接口地址**:`/cssl/project/deleteProject`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|proId|项目卡片编号|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getExpClass


**接口地址**:`/cssl/project/getExpClass/{proId}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|proId|项目编号|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getProjects


**接口地址**:`/cssl/project/getProject`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|term|学期|query|true|string||
|tid|教师编号|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getTermList


**接口地址**:`/cssl/project/getTermList`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## reuseCard


**接口地址**:`/cssl/project/reuseCard`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId|课程编号|query|true|string||
|tid|教师编号|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## updateExp


**接口地址**:`/cssl/project/updateExp`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"book": "",
	"conName": "",
	"conNum": 0,
	"courseId": 0,
	"courseName": "",
	"eqnum": 0,
	"expCname": "",
	"expEqname": "",
	"expTid": "",
	"expTime": 0,
	"labStatus": "",
	"proId": 0,
	"software": "",
	"term": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|expProject|项目(实验卡片)|body|true|ExpProject对象|ExpProject对象|
|&emsp;&emsp;book|实验教材||false|string||
|&emsp;&emsp;conName|消耗材料名称||false|string||
|&emsp;&emsp;conNum|消耗材料数量||false|integer(int32)||
|&emsp;&emsp;courseId|课程编号||false|integer(int32)||
|&emsp;&emsp;courseName|实验课程名||false|string||
|&emsp;&emsp;eqnum|设备数量||false|integer(int32)||
|&emsp;&emsp;expCname|实验课程名||false|string||
|&emsp;&emsp;expEqname|实验设备名||false|string||
|&emsp;&emsp;expTid|授课教师编号||false|string||
|&emsp;&emsp;expTime|实验总学时||false|integer(int32)||
|&emsp;&emsp;labStatus|申请实验室状态,可用值:UNCHECK,AUDITING,PASS,FAIL||false|string||
|&emsp;&emsp;proId|项目编号||false|integer(int32)||
|&emsp;&emsp;software|实验所用软件||false|string||
|&emsp;&emsp;term|学期||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


# 项目资料-控制器


## addExpFile


**接口地址**:`/cssl/expFile/addExpFile`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|classId|班级编号|query|true|integer(int32)||
|file|file|formData|true|file||
|filePath|文件路径|query|true|string||
|name|文件名|query|true|string||
|no|标识编号|query|true|integer(int32)||
|proId|项目ID|query|true|integer(int32)||
|typeName|项目文件类型名|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getById


**接口地址**:`/cssl/expFile/getById/{proId}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|proId|proId|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getFileDownload


**接口地址**:`/cssl/expFile/getFile`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|fileNo|fileNo|query|true|integer(int32)||
|term|term|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## getFileStatus


**接口地址**:`/cssl/expFile/getFileStatus`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|classId|classId|query|true|integer(int32)||
|proId|proId|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||string||
|data||object||
|message||string||
|success||boolean||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"message": "",
	"success": true
}
```


## getFilesZipByProId


**接口地址**:`/cssl/expFile/getFilesZip`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|proId|proId|query|true|integer(int32)||
|term|term|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||


**响应参数**:


暂无


**响应示例**:
```javascript

```
