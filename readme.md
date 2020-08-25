# 实验室管理系统-后台

> （Course scheduling system of Laboratory）

> （基于 springboot2.0 angular8 实现）

> 前台项目仓库：[cssl-front-end](https://github.com/EslSuwen/cssl-front-end)

为解决高校实验室建设和管理中存在的这些问题，以本校信息学院的信息技术实践中心实验室建设为依托，展开实验室管理系统研究与开发。

## 技术堆栈

* Spring Boot 2.2.8.RELEASE

* Spring Security

* Spring Data

* Spring Actuator

* JWT

* knife4j

* lombok

* mysql

* Angular 8

* NG-ZORRO

*测试工具：* Postman
*代码质量检查：* Sonar
*CI：* Jenkins
*推荐IDE：* IntelliJ IDEA、WebStorm/Visual Studio Code

> Java代码中使用了lombok注解，IDE需安装lombok插件。

*注意:* 本项目基于 JDK1.8

项目开发过程中，加强了技术融入，而且严格按照阿里巴巴Java代码规范标准进行编写的。

## 特点

* 简单易用
* RESTful API
* 易于重构和维护
* 代码规范
* ...


## 使用方法

### 1. IntelliJ IDEA（或其他编译工具）

1. 将项目导入到**IntelliJ IDEA**中，然后利用gradle版本控制工具导入jar。
2. 打开**application.yml**更改数据库连接信息。
3. 进入**webapp**文件夹中更改**environment.ts**中前端的接口
4. **ng serve**启动前端项目，或者**ng build**编译到SpringBoot中,最后启动主函数App.java即可。最后打开浏览器，输入<http://localhost:8090/cssl>，即可浏览系统。

------

