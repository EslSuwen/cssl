package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.entity.Teach;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 授课 Mapper 接口
 *
 * @author suwen
 * @date 2020/2/6 3:30 下午
 */
public interface TeachMapper extends BaseMapper<Teach> {

    /**
     * 通过教师编号查找授课信息
     *
     * @param tid 教师编号
     * @return 授课信息
     * @author suwen
     * @date 2020/10/5 下午2:18
     */
    List<Teach> selectAll(String tid);

    /**
     * 通过教师编号查找可增加课程信息
     *
     * @param tid 教师编号
     * @return 课程
     * @author suwen
     * @date 2020/10/5 下午3:08
     */
    List<Course> selectAvailableCourse(String tid);
}
