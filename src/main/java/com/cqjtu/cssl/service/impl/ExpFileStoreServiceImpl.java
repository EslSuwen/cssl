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
  public boolean saveFile(ExpFileStore expFileStore, MultipartFile file) throws IOException {
    Integer proId = expFileStore.getProId();
    String typeName = expFileStore.getTypeName();
    String term = expProjectService.getById(proId).getTerm();
    String fileName = file.getOriginalFilename();
    Integer classId = expFileStore.getClassId();
    String pathPrefix =
        StrUtil.format("{}{}/{}/{}/", DEFAULT_PATH + FILE_PREFIX, term, proId, classId);
    log.info(pathPrefix);

    ExpFile expFile = expFileService.getFileStatus(proId, classId);
    if (expFile != null) {
      Integer oldFileNo;
      switch (typeName) {
        case "考勤名单":
          oldFileNo = expFile.getAttend();
          break;
        case "实验任务书":
          oldFileNo = expFile.getTask();
          break;
        case "实验成绩":
          oldFileNo = expFile.getGrade();
          break;
        case "评分标准表":
          oldFileNo = expFile.getScheme();
          break;
        case "实验报告":
          oldFileNo = expFile.getReport();
          break;
        default:
          throw new IllegalArgumentException("typeName error");
      }
      // 如果文件己存在则先删除
      if (oldFileNo != null) {
        String oldFilePath = pathPrefix + getById(oldFileNo).getName();
        log.info(oldFilePath);
        if (FileUtil.exist(oldFilePath)) {
          FileUtil.del(oldFilePath);
          removeById(oldFileNo);
        }
      }
    } else {
      expFile = new ExpFile();
    }
    // 保存到目标目录
    String targetPath = pathPrefix + fileName;
    expFileStore.setFilePath(
        StrUtil.format("{}{}/{}/{}/{}", FILE_PREFIX, term, proId, classId, fileName));
    expFileStore.setName(fileName);
    InputStream in = file.getInputStream();
    BufferedOutputStream out = FileUtil.getOutputStream(new File(targetPath));
    IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
    IoUtil.close(in);
    IoUtil.close(out);

    if (save(expFileStore)) {
      Integer no = expFileStore.getNo();
      expFile.setProId(proId);
      expFile.setClassId(classId);
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
      if (!expFileService.update(
          expFile,
          new QueryWrapper<ExpFile>()
              .eq("pro_id", proId)
              .eq("class_id", classId)
              .last("LIMIT 1"))) {
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
