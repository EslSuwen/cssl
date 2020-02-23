package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.LabArrange;
import com.cqjtu.cssl.entity.LabArrangeShow;
import com.cqjtu.cssl.mapper.LabArrangeMapper;
import com.cqjtu.cssl.mapper.TeachMapper;
import com.cqjtu.cssl.service.LabArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实验室安排服务接口实现
 *
 * @author: Aplin
 * @time: 2020/1/13 11:05 上午
 */
@Service
public class LabArrangeServiceImpl implements LabArrangeService {
  @Autowired private LabArrangeMapper labArrangeMapper;
  @Autowired private TeachMapper teachMapper;

  @Override
  public List<LabArrangeShow> findByTid(String tid) {
    return labArrangeMapper.findByTid(tid);
  }

  @Override
  public List<LabArrangeShow> findByWeek(int labWeek) {
    return labArrangeMapper.findByLabWeek(labWeek);
  }

  @Override
  public List<LabArrangeShow> findAll() {
    return labArrangeMapper.findAll();
  }

  @Override
  public void addLabArrange(String tid, int proId, LabArrangeShow labArrangeShow) {
    LabArrange labArrange = new LabArrange();
    labArrange.setTId(tid);
    labArrange.setLabWeek(labArrangeShow.getLabWeek());
    labArrange.setLabDay(labArrangeShow.getLabDay());
    labArrange.setLabSession(labArrangeShow.getLabSession());
    labArrange.setExpProname(labArrangeShow.getExpProName());
    labArrange.setLabRemark(labArrangeShow.getLabRemark());
    labArrange.setLabClass(labArrangeShow.getMajorName() + labArrangeShow.getClassName());
    labArrange.setProId(proId);
    labArrange.setCourseId(teachMapper.findID(tid, labArrangeShow.getCourseName()));
    labArrange.setLabId(labArrangeShow.getLabID());
    labArrangeMapper.addLabArrange(labArrange);
  }
}
