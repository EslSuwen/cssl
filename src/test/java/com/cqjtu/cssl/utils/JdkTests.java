package com.cqjtu.cssl.utils;

import com.cqjtu.cssl.exception.FileException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * jdk 特性测试
 *
 * @author suwen
 * @date 2020/8/10 下午7:55
 */
@Log4j2
public class JdkTests {

  @Test
  public void pathSeparator() {
    System.out.println("separator: " + File.separator);
    System.out.println("pathSeparator: " + File.pathSeparator);
  }

  @Test
  public void file() throws IOException {
    Path targetLocation = Paths.get("./files/test/img").toAbsolutePath().normalize();
    Files.createDirectories(targetLocation);
  }

  @Test
  public void saveFile() throws IOException {
    // 读取默认目录
    Path path = Paths.get("./files").toAbsolutePath().normalize();
    try {
      Files.createDirectories(path);
    } catch (Exception ex) {
      throw new FileException("文件保存目录异常！", ex);
    }
    // 读取测试文件
    try {
      Path filePath = path.resolve("dir/pic.jpeg").normalize();
      Resource resource = new UrlResource(filePath.toUri());
      if (!resource.exists()) {
        throw new FileException("未找到文件");
      }
      // 测试保存文件
      // 复制文件到目的文件夹（覆盖同名文件）
      Path targetLocation = Paths.get("./files/test/img").toAbsolutePath().normalize();
      Files.createDirectories(targetLocation);
      Files.copy(filePath, targetLocation, StandardCopyOption.REPLACE_EXISTING);
    } catch (MalformedURLException ex) {
      throw new FileException("未找到文件", ex);
    }
  }
}
