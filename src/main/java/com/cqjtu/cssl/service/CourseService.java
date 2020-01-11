package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.utils.CourseQueryHelper;

import java.util.List;


public interface CourseService {

    /**
     * 新增课程记录
     *
     * @param course
     */
    void addCourse(Course course);

    /**
     * 删除一条课程记录
     *
     * @param courseNo
     * @return boolean
     */
    boolean removeCourseByNo(String courseNo);

    /**
     * 更新一条课程记录
     *
     * @param course
     */
    void updateCourse(Course course);

    /**
     * 获取一条课程记录
     *
     * @param courseNo
     * @return Course
     */
    Course loadCourseByNo(String courseNo);

    /**
     * 获得某查询条件下的所有的记录集
     *
     * @param helper
     * @return List
     */
    List<Course> loadScopedCourses(CourseQueryHelper helper);

    /**
     * 根据课程编号，获得图片
     *
     * @param courseNo
     * @return byte
     */
    byte[] getTextbookPic(String courseNo);

}
