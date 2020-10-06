package com.cqjtu.cssl.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、Mapper、Mapper
 * XML、Service、Controller 等各个模块的代码，极大的提升了开发效率。 https://mp.baomidou.com/guide/generator.htm
 *
 * @author suwen
 * @date 2020/2/21 上午11:32
 */
public final class MybatisPlusCodeGenerator {
  // 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中

  private static final String DB_URL =
      "jdbc:mysql://localhost:3306/cssldb-dev?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
  // "jdbc:mysql://47.115.8.44:3306/csslDB-dev?characterEncoding=utf8";
  private static final String DB_PWD = "Liyu8824";
  private static final String DB_USER = "root";
  private static final String PACKAGE_PARENT = "com.cqjtu";

  /** 读取控制台内容 */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入" + tip + "：");
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotBlank(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();
    // set freemarker engine
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(projectPath + "/src/main/java");
    gc.setAuthor("suwen");
    gc.setOpen(false);
    // service 命名方式 如下配置 %s 为占位符
    gc.setServiceName("%sService");
    // 实体属性 Swagger2 注解
    gc.setSwagger2(true);
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(DB_URL);
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername(DB_USER);
    dsc.setPassword(DB_PWD);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName(scanner("模块名"));
    pc.setParent(PACKAGE_PARENT);
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg =
        new InjectionConfig() {
          @Override
          public void initMap() {
            // to do nothing
          }
        };

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 如果模板引擎是 velocity
    // String templatePath = "/templates/mapper.xml.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(
        new FileOutConfig(templatePath) {
          @Override
          public String outputFile(TableInfo tableInfo) {
            // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
            //            return projectPath
            //                + "/src/main/resources/mybatis/"
            //                + pc.getModuleName()
            //                + "/"
            //                + tableInfo.getEntityName()
            //                + "Mapper"
            //                + StringPool.DOT_XML;
            return projectPath
                + "/src/main/resources/mybatis/"
                + tableInfo.getEntityName()
                + "Mapper"
                + StringPool.DOT_XML;
          }
        });
    /*
    cfg.setFileCreate(new IFileCreate() {
        @Override
        public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
            // 判断自定义文件夹是否需要创建
            checkDir("调用默认方法创建的目录");
            return false;
        }
    });
    */
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    // templateConfig.setEntity("templates/entity2.java");
    // templateConfig.setService();
    // templateConfig.setController();

    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    //    strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    // 公共父类
    //    strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
    // 写于父类中的公共字段
    strategy.setSuperEntityColumns("id");
    strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix(pc.getModuleName() + "_");
    mpg.setStrategy(strategy);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
  }
}
