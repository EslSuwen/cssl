package com.cqjtu.cssl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 测试 data 实体 标明是Entity，以被jpa识别为数据，映射到MySQL数据库。必须与@Id注解 结合使用
 *
 * @author suwen
 * @date 2020/2/6 3:15 下午
 */
@Entity
@Table(name = "demodata")
public class Demo {

  /** 标注表的唯一标识；标注表的该列，为自动生成数据 */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Integer id;

  private String name;
  private Integer height;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }
}