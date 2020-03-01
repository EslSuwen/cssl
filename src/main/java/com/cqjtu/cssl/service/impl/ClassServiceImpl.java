package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Class;
import com.cqjtu.cssl.mapper.ClassMapper;
import com.cqjtu.cssl.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级服务实现类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {
  private final ClassMapper classMapper;

  @Autowired
  public ClassServiceImpl(ClassMapper classMapper) {
    this.classMapper = classMapper;
  }

  @Override
  public void addClass(Class aClass) {
    classMapper.addClass(aClass);
  }

  @Override
  public void deleteClass(String className, int majorId) {
    classMapper.deleteClass(className, majorId);
  }

  @Override
  public void updateClass(String className, int majorId, Class aClass) {
    classMapper.updateClass(className, majorId, aClass);
  }

  @Override
  public Class findOneClass(String className, int majorId) {
    return classMapper.findOneClass(className, majorId);
  }

  @Override
  public List<Class> findAllClass() {
    return classMapper.findAllClass();
  }

  @Override
  public List<Class> findClassByMajor(int majorId) {
    return classMapper.findClassByMajor(majorId);
  }
}
