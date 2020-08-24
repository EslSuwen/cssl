package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.LabInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 实验室信息服务接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 11:05 上午
 */
public interface LabInfoService extends IService<LabInfo> {

    /**
     * 根据实验室类型编号获得实验室信息
     *
     * @param typeId 实验室类型编号
     * @return List<实验室信息>
     * @author suwen
     * @date 2020/5/29 上午9:42
     */
    List<LabInfo> getLabByTypeId(Integer typeId);

    /**
     * 根据实验室类型编号和校区获得实验室信息
     *
     * @param typeId 实验室类型编号
     * @param campus 校区
     * @return List<实验室信息>
     * @author suwen
     * @date 2020/5/29 上午9:42
     */
    List<LabInfo> getLabByTypeIdCampus(Integer typeId,String campus);

    /**
     * 通过项目编号查找实验室信息
     *
     * @param proId 项目编号
     * @return 实验室信息
     * @author suwen
     * @date 2020/8/21 上午11:34
     */
    LabInfo getLabByProId(Integer proId);
}
