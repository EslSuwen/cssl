package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.TestFile;

import java.util.List;


public interface TestFileService {


    /**
     * 新增一条文件数据
     *
     * @param  id
     * @return TestFile
     *
     */
    TestFile get(int id);


    /**
     * 新增一条文件数据
     *
     * @param  testFile
     *
     */
    void addFile(TestFile testFile);

    void addUser();


}

