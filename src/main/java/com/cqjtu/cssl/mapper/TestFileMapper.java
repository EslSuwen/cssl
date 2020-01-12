package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.TestFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestFileMapper {

    /**
     * 新增文件记录
     *
     * @param testFile
     */
    void addFile(TestFile testFile);

    /**
     * 根据外键获取课程记录
     *
     * @param id
     * @return TestFile
     */
    TestFile loadFileByNo(int id);

    void addUser();

}
