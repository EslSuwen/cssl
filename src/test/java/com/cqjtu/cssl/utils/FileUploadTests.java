package com.cqjtu.cssl.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

/**
 * 文件上传下载测试
 *
 * @author suwen
 * @date 2020/8/10 下午1:04
 */
@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
public class FileUploadTests {

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    //    mockMvc = MockMvcBuilders.standaloneSetup(ExpFileController.class).build();
  }

  @Test
  public void fileUtilTest() {
    String path = System.getProperty("user.dir") + "/CSSL_FILES/noticeFile/";
    BufferedInputStream in = FileUtil.getInputStream(new File(""));
    BufferedOutputStream out = FileUtil.getOutputStream(path + "testcopy.jpg");
    long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
    IoUtil.close(in);
    IoUtil.close(out);
    System.out.println(copySize);
  }
}
