package com.cqjtu.cssl.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.constant.ExpFileType;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.mapper.ExpFileMapper;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 项目资料关联服务实现类
 *
 * @author suwen
 * @since 2020-07-07
 */
@Log4j2
@Service
public class ExpFileServiceImpl extends ServiceImpl<ExpFileMapper, ExpFile>
    implements ExpFileService {

  private final String DEFAULT_PATH = System.getProperty("user.dir");
  private final String FILE_PREFIX = "/CSSL_FILES/expFile/";

  private ExpProjectService expProjectService;

  @Autowired
  public void setExpProjectService(ExpProjectService expProjectService) {
    this.expProjectService = expProjectService;
  }

  @Override
  public ExpFile getFileStatus(Integer proId, Integer classId) {
    return getOne(
        new QueryWrapper<ExpFile>().eq("pro_id", proId).eq("class_id", classId).last("LIMIT 1"));
  }

  @Override
  public boolean saveFile(ExpFile expFile, MultipartFile file) throws IOException {
    Integer proId = expFile.getProId();
    Integer fileType = expFile.getFileType();
    String term = expProjectService.getById(proId).getTerm();
    String fileName = file.getOriginalFilename();
    String pathPrefix =
        StrUtil.format(
            "{}{}/{}/{}/",
            DEFAULT_PATH + FILE_PREFIX,
            term,
            proId,
            ExpFileType.convertName(fileType));
    log.info(pathPrefix);

    ExpFile oldFile =
        getOne(new QueryWrapper<ExpFile>().eq("pro_id", proId).eq("file_type", fileType));

    // 如果文件己存在则先删除
    if (oldFile != null) {
      String oldFilePath = pathPrefix + oldFile.getFileName();
      log.info(oldFilePath);
      if (FileUtil.exist(oldFilePath)) {
        FileUtil.del(oldFilePath);
      }
      remove(new QueryWrapper<ExpFile>().eq("pro_id", proId).eq("file_type", fileType));
    }

    // 保存到目标目录
    String targetPath = pathPrefix + fileName;
    expFile.setFilePath(
        StrUtil.format(
            "{}{}/{}/{}/{}",
            FILE_PREFIX,
            term,
            proId,
            ExpFileType.convertName(fileType),
            fileName));
    expFile.setFileName(fileName);
    InputStream in = file.getInputStream();
    BufferedOutputStream out = FileUtil.getOutputStream(new File(targetPath));
    IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
    IoUtil.close(in);
    IoUtil.close(out);

    return save(expFile);
  }
}
