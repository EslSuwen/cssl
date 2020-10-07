package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.ExpClass;

import java.util.List;

/**
 * 排课班级 服务类
 *
 * @author suwen
 * @since 2020-10-06
 */
public interface ExpClassService extends IService<ExpClass> {

    /**
     * 根据项目编号获取项目班级
     *
     * @param proId 项目编号
     * @return 项目班级
     */
    List<ExpClass> getByProId(Integer proId);
}
