package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.TestFile;
import com.cqjtu.cssl.mapper.TestFileMapper;
import com.cqjtu.cssl.service.TestFileService;
import com.cqjtu.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(rollbackFor = Exception.class)
public class TestFileServiceImpl implements TestFileService {

    @Autowired
    private TestFileMapper testFileMapper;

    @Override
    public TestFile get(int id) {

        return testFileMapper.loadFileByNo(id);

    }

    @Override
    public void addFile(TestFile testFile) {

        testFileMapper.addFile(testFile);
    }

    @Override
    public void addUser() {
        testFileMapper.addUser();
    }

}