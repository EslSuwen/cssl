package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.config.FileProperties;
import com.cqjtu.cssl.exception.FileException;
import com.cqjtu.cssl.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * 文件服务实现
 *
 * @author suwen
 * @date 2020/8/10 下午1:29
 */
@Service
public class FileServiceImpl implements FileService {

  /** 默认文件在本地存储的地址 */
  private final Path FILE_STORAGE_LOCATION;

  private final String DEFAULT_PATH;

  @Autowired
  public FileServiceImpl(FileProperties fileProperties) {
    this.DEFAULT_PATH = fileProperties.getFileDir();
    this.FILE_STORAGE_LOCATION = Paths.get(DEFAULT_PATH).toAbsolutePath().normalize();
    try {
      Files.createDirectories(this.FILE_STORAGE_LOCATION);
    } catch (Exception ex) {
      throw new FileException("文件保存目录异常！", ex);
    }
  }

  @Override
  public String storeFile(MultipartFile file) {
    // 初始化文件名
    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

    try {
      // 检查文件名
      if (fileName.contains("..")) {
        throw new FileException("该文件名包含无效字符： " + fileName);
      }

      // 复制文件到目的文件夹（覆盖同名文件）
      Path targetLocation = this.FILE_STORAGE_LOCATION.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return fileName;
    } catch (IOException ex) {
      throw new FileException("无法保存文件： " + fileName + " ！", ex);
    }
  }

  @Override
  public String storeFile(MultipartFile file, String path) {
    // 初始化文件名
    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

    try {
      // 检查文件名
      if (fileName.contains("..")) {
        throw new FileException("该文件名包含无效字符： " + fileName);
      }

      // 复制文件到目的文件夹（覆盖同名文件）
      Path targetLocation = Paths.get("./files/test/").toAbsolutePath().normalize();
      Files.createDirectories(targetLocation);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return targetLocation.toString() + fileName;
    } catch (IOException ex) {
      throw new FileException("无法保存文件： " + fileName + " ！", ex);
    }
  }

  @Override
  public Resource loadFileAsResource(String fileName) {
    try {
      Path filePath = this.FILE_STORAGE_LOCATION.resolve(fileName).normalize();
      Resource resource = new UrlResource(filePath.toUri());
      if (resource.exists()) {
        return resource;
      } else {
        throw new FileException("未找到文件： " + fileName);
      }
    } catch (MalformedURLException ex) {
      throw new FileException("未找到文件 " + fileName, ex);
    }
  }
}
