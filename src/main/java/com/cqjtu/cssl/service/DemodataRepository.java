package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * 测试数据服务接口及自动实现接口
 *
 * @author suwen
 * @date 2020/2/6 4:02 下午
 */
public interface DemodataRepository extends CrudRepository<Demo, Long> {}
