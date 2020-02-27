package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.TestFile;
import com.cqjtu.cssl.mapper.TestFileMapper;
import com.cqjtu.cssl.service.TestFileService;
import org.springframework.stereotype.Service;

/**
 * 文件测试接口实现
 *
 * @author suwen
 * @date 2020/1/12 4:01 下午
 */
@Service
public class TestFileServiceImpl extends ServiceImpl<TestFileMapper, TestFile>
    implements TestFileService {}
