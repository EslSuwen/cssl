package com.cqjtu.cssl.utils;

import com.cqjtu.cssl.constant.AuthorityName;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.entity.Authority;
import com.cqjtu.cssl.exception.FileException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

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
    log.info("separator: " + File.separator);
    log.info("pathSeparator: " + File.pathSeparator);
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
    if (path.toFile().exists() && path.toFile().isDirectory()) {
      try {
        log.info("默认目录不存在，创建目录。");
        Files.createDirectories(path);
      } catch (Exception ex) {
        throw new FileException("默认目录异常！", ex);
      }
    } else {
      log.info("默认目录读取成功。");
    }
    // 读取测试文件
    try {
      Path filePath = path.resolve("dir/pic.jpeg").normalize();
      if (!filePath.toFile().exists()) {
        throw new FileException("未找到文件");
      }
      // 测试保存文件
      // 复制文件到目的文件夹（覆盖同名文件）
      Path targetLocation = Paths.get("./files/test/img/test.jpeg").toAbsolutePath().normalize();
      Files.createFile(targetLocation);
      if (targetLocation.toFile().exists() && targetLocation.toFile().isDirectory()) {
        try {
          log.info("保存目录不存在，创建目录。");
          Files.createDirectories(targetLocation);
        } catch (Exception ex) {
          throw new FileException("保存目录异常！", ex);
        }
      } else {
        log.info("保存目录读取成功。");
      }
      Files.copy(filePath, targetLocation, StandardCopyOption.REPLACE_EXISTING);
    } catch (MalformedURLException ex) {
      throw new FileException("未找到文件", ex);
    }
  }

  @Test
  public void creatFile() throws IOException {
    Path targetLocation = Paths.get("./files/test/img/test.jpeg").toAbsolutePath().normalize();
    Files.createFile(targetLocation);
  }

  @Test
  public void sysDir() {
    System.out.println(System.getProperty("user.dir"));
    System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/");
  }

  @Test
  public void equalArrangePeriod() {
    ArrangePeriod arrange =
        ArrangePeriod.builder().aid(0).labWeek(1).labDay(1).labSession(1).build();
    ArrangePeriod arrange1 =
        ArrangePeriod.builder().aid(1).labWeek(1).labDay(1).labSession(1).build();
    ArrangePeriod arrange2 =
        ArrangePeriod.builder().aid(2).labWeek(1).labDay(1).labSession(1).build();

    System.out.println(arrange.equals(arrange1));
    System.out.println(arrange1.equals(arrange2));
  }

  @Test
  public void enumAuthorityName() {
    List<Authority> authorities = new ArrayList<>();
    for (int i = 2; i >= 0; i--) {
      authorities.add(new Authority(1L, AuthorityName.valueOf(i)));
    }
    System.out.println(authorities);
  }
}
