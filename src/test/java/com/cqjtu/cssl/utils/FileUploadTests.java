package com.cqjtu.cssl.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.cqjtu.cssl.service.FileService;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

  @Autowired private FileService fileService;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    //    mockMvc = MockMvcBuilders.standaloneSetup(ExpFileController.class).build();
  }

  @Test
  public void fileSaveTest() throws IOException {
    File file = fileService.loadFileAsResource("dir/pic.jpeg").getFile();
    MockMultipartFile mockMultipartFile =
        new MockMultipartFile(
            "file_test", // 文件名
            file.getName(), // originalName 相当于上传文件在客户机上的文件名
            MediaType.IMAGE_JPEG_VALUE, // 文件类型
            new FileInputStream(file) // 文件流
            );
    log.info(fileService.storeFile(mockMultipartFile, "testpath"));
    //    log.info(fileService.storeFile(mockMultipartFile));
  }

  @Test
  public void fileLoadTest() throws IOException {
    File file = fileService.loadFileAsResource("dir/pic.jpeg").getFile();
    log.info(file);
  }

  @Test
  public void uploadFile() throws Exception {
    File file = fileService.loadFileAsResource("dir/pic.jpeg").getFile();
    MockMultipartFile mockMultipartFile =
        new MockMultipartFile(
            "file", // 文件名
            file.getName(), // originalName 相当于上传文件在客户机上的文件名
            MediaType.IMAGE_JPEG_VALUE, // 文件类型
            new FileInputStream(file) // 文件流
            );
    ResultActions resultActions =
        this.mockMvc.perform(multipart("/file/upload").file(mockMultipartFile));
    resultActions
        .andExpect(status().isCreated())
        .andReturn()
        .getResponse()
        .setCharacterEncoding(StandardCharsets.UTF_8.name());
    resultActions.andDo(print());
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
