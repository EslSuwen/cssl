package com.cqjtu.cssl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文件保存测试实体
 *
 * @author suwen
 * @date 2020/2/6 3:19 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "tbl_test_file")
public class TestFile {

  @Id private int id;
  private String fileName;
  private byte[] file;
}
