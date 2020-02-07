package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.ClassGrade;
import com.cqjtu.cssl.mapper.ClassMapper;
import com.cqjtu.cssl.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级服务接口实现
 *
 * @author: Aplin
 * @time: 2020/1/13 11:04 上午
 */
@Service
public class ClassServiceImpl implements ClassService {
  @Autowired private ClassMapper classMapper;

  @Override
  public void addClass(ClassGrade classGrade) {
    classMapper.addClass(classGrade);
  }

  @Override
  public void deleteClass(String className, int majorID) {
    classMapper.deleteClass(className, majorID);
  }

  @Override
  public void updateClass(String className, int majorID, ClassGrade classGrade) {
    classMapper.updateClass(className, majorID, classGrade);
  }

  @Override
  public ClassGrade findOneClass(String className, int majorID) {
    return classMapper.findOneClass(className, majorID);
  }

  @Override
  public List<ClassGrade> findAllClass() {
    return classMapper.findAllClass();
  }

  @Override
  public List<ClassGrade> findClassByMajor(int majorID) {
    return classMapper.findClassByMajor(majorID);
  }
}
