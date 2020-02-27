package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.mapper.CourseMapper;
import com.cqjtu.cssl.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * 课程信息服务实现类
 *
 * @author suwen
 * @since 2020-02-27
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {}
