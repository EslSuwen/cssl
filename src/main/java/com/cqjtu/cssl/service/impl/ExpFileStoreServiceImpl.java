package com.cqjtu.cssl.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.mapper.ExpFileStoreMapper;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpFileStoreService;
import com.cqjtu.cssl.service.ExpProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 项目资料存储服务实现类
 *
 * @author suwen
 * @since 2020-07-07
 */
@Log4j2
@Service
public class ExpFileStoreServiceImpl extends ServiceImpl<ExpFileStoreMapper, ExpFileStore>
    implements ExpFileStoreService {

  private ExpFileService expFileService;
  private ExpProjectService expProjectService;
  private final String DEFAULT_PATH = System.getProperty("user.dir");
  private final String FILE_PREFIX = "/CSSL_FILES/expFile/";

  @Autowired
  public void setExpFileService(ExpFileService expFileService) {
    this.expFileService = expFileService;
  }

  @Autowired
  public void setExpProjectService(ExpProjectService expProjectService) {
    this.expProjectService = expProjectService;
  }

  /**
   * TODO 重构: ExpFile 与 ExpFileStore 间用主键连接，避免愚蠢的 switch
   *
   * @date 2020-10-07
   */
  @Override
  public boolean saveFile(ExpFile expFile, MultipartFile file) throws IOException {
    return false;
  }

  @Override
  public List<ExpFileStore> getQuickFile(Integer proId) {
    return baseMapper.getQuickFile(proId);
  }
}
