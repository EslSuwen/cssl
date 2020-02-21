package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.TestFile;

/**
 * 文件测试服务接口
 *
 * @author suwen
 * @date 2020/2/6 3:50 下午
 */
public interface TestFileService {

  /**
   * 新增一条文件数据
   *
   * @author suwen
   * @date 2020/2/6 3:50 下午
   * @param id
   * @return TestFile
   */
  TestFile get(int id);

  /**
   * 新增一条文件数据
   *
   * @author suwen
   * @date 2020/2/6 3:50 下午
   * @param testFile 文件数据
   */
  void addFile(TestFile testFile);
}
