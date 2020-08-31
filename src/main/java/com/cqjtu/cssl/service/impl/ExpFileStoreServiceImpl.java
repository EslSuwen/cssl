package com.cqjtu.cssl.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.mapper.ExpFileStoreMapper;
import com.cqjtu.cssl.mapper.ExpProjectMapper;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpFileStoreService;
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

  private final ExpFileService expFileService;
  private final ExpProjectMapper expProjectMapper;
  private final String DEFAULT_PATH = System.getProperty("user.dir") + "/CSSL_FILES/expFile/";

  @Autowired
  public ExpFileStoreServiceImpl(ExpFileService expFileService, ExpProjectMapper expProjectMapper) {
    this.expFileService = expFileService;
    this.expProjectMapper = expProjectMapper;
  }

  @Override
  public boolean saveFile(ExpFileStore expFileStore, MultipartFile file) throws IOException {
    Integer proId = expFileStore.getProId();
    String typeName = expFileStore.getTypeName();
    ExpProject expProject = expProjectMapper.selectById(proId);
    String pathPrefix = StrUtil.format("{}{}/{}/", DEFAULT_PATH, expProject.getTerm(), proId);
    log.info(pathPrefix);
    ExpFileStore expFileStoreOld =
        getOne(new QueryWrapper<ExpFileStore>().eq("pro_id", proId).eq("type_name", typeName));
    // 如果文件己存在则先删除
    if (expFileStoreOld != null) {
      String oldFilePath = pathPrefix + expFileStoreOld.getName();
      log.info(oldFilePath);
      if (FileUtil.exist(oldFilePath)) {
        FileUtil.del(oldFilePath);
        removeById(expFileStoreOld.getNo());
      }
    }
    // 保存到目标目录
    String targetPath = pathPrefix + file.getOriginalFilename();
    expFileStore.setFilePath(targetPath);
    expFileStore.setName(file.getOriginalFilename());
    InputStream in = file.getInputStream();
    BufferedOutputStream out = FileUtil.getOutputStream(new File(targetPath));
    IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
    IoUtil.close(in);
    IoUtil.close(out);

    if (save(expFileStore)) {
      Integer no =
          getOne(
                  new QueryWrapper<ExpFileStore>()
                      .eq("pro_id", proId)
                      .eq("type_name", typeName)
                      .last("LIMIT 1"))
              .getNo();
      ExpFile expFile = new ExpFile();
      expFile.setProId(proId);
      switch (typeName) {
        case "考勤名单":
          expFile.setAttend(no);
          break;
        case "实验任务书":
          expFile.setTask(no);
          break;
        case "实验成绩":
          expFile.setGrade(no);
          break;
        case "评分标准表":
          expFile.setScheme(no);
          break;
        case "实验报告":
          expFile.setReport(no);
          break;
        default:
          throw new IllegalArgumentException("typeName error");
      }
      if (!expFileService.updateById(expFile)) {
        return expFileService.save(expFile);
      }
      return true;
    }
    return false;
  }

  @Override
  public List<ExpFileStore> getQuickFile(Integer proId) {
    return baseMapper.getQuickFile(proId);
  }
}
