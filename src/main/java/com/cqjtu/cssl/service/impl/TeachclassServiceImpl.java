package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Teachclass;
import com.cqjtu.cssl.entity.TeacherCourseClassHelper;
import com.cqjtu.cssl.mapper.MajorMapper;
import com.cqjtu.cssl.mapper.TeachclassMapper;
import com.cqjtu.cssl.mapper.TeacherCourseClassMapper;
import com.cqjtu.cssl.service.TeachclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 教师授课班级信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class TeachclassServiceImpl extends ServiceImpl<TeachclassMapper, Teachclass>
    implements TeachclassService {}