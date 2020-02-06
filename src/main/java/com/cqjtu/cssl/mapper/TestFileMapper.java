package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.TestFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件测试 mapper
 *
 * @author: suwen
 * @time: 2020/2/6 3:20 下午
 */
@Mapper
public interface TestFileMapper {

  /**
   * 测试文件增加
   *
   * @author: suwen
   * @time: 2020/2/6 3:26 下午
   * @param testFile 文件
   */
  void addFile(TestFile testFile);

  /**
   * 根据 id 加载文件
   *
   * @author: suwen
   * @time: 2020/2/6 3:26 下午
   * @param id 文件 id
   * @return com.cqjtu.cssl.entity.TestFile
   */
  TestFile loadFileByNo(int id);
}
