package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

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
@TableName("tbl_test_file")
public class TestFile implements Serializable {

  @TableId private int id;
  private String fileName;
  private byte[] file;
}
