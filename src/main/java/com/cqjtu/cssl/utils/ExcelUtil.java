package com.cqjtu.cssl.utils;

import com.cqjtu.cssl.entity.TeachingPlan;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

/**
 * 路径：com.example.demo.utils 类名： 功能：导入导出 备注： 创建人：typ 创建时间：2018/10/19 11:21 修改人： 修改备注： 修改时间：
 *
 * @author susie
 */
@Log4j2
public class ExcelUtil {

  /** 方法名：exportExcel 功能：导出Excel 描述： 创建人：typ 创建时间：2018/10/19 16:00 修改人： 修改描述： 修改时间： */
  public static void exportExcel(HttpServletResponse response, TeachingPlan data) {
    log.info("导出解析开始，fileName:{}", data);
    try {
      // 实例化HSSFWorkbook
      HSSFWorkbook workbook = new HSSFWorkbook();
      // 创建一个Excel表单，参数为sheet的名字
      HSSFSheet sheet = workbook.createSheet("sheet");
      // 设置表头
      setTitle(workbook, sheet, new String[] {"1", "2", "3"});
      // 设置单元格并赋值
      setData(sheet, Collections.singletonList(new String[] {"1", "2", "3"}));
      // 设置浏览器下载
      setBrowser(response, workbook, "2020-05-25.xls");
      log.info("导出解析成功!");
    } catch (Exception e) {
      log.info("导出解析失败!");
      e.printStackTrace();
    }
  }

  /** 方法名：setTitle 功能：设置表头 描述： 创建人：typ 创建时间：2018/10/19 10:20 修改人： 修改描述： 修改时间： */
  private static void setTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] str) {
    try {
      HSSFRow row = sheet.createRow(0);
      // 设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
      for (int i = 0; i <= str.length; i++) {
        sheet.setColumnWidth(i, 15 * 256);
      }
      // 设置为居中加粗,格式化时间格式
      HSSFCellStyle style = workbook.createCellStyle();
      HSSFFont font = workbook.createFont();
      font.setBold(true);
      style.setFont(font);
      style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
      // 创建表头名称
      HSSFCell cell;
      for (int j = 0; j < str.length; j++) {
        cell = row.createCell(j);
        cell.setCellValue(str[j]);
        cell.setCellStyle(style);
      }
    } catch (Exception e) {
      log.info("导出时设置表头失败！");
      e.printStackTrace();
    }
  }

  /** 方法名：setData 功能：表格赋值 描述： 创建人：typ 创建时间：2018/10/19 16:11 修改人： 修改描述： 修改时间： */
  private static void setData(HSSFSheet sheet, List<String[]> data) {
    try {
      int rowNum = 1;
      for (String[] datum : data) {
        HSSFRow row = sheet.createRow(rowNum);
        for (int j = 0; j < datum.length; j++) {
          row.createCell(j).setCellValue(datum[j]);
        }
        rowNum++;
      }
      log.info("表格赋值成功！");
    } catch (Exception e) {
      log.info("表格赋值失败！");
      e.printStackTrace();
    }
  }

  /** 方法名：setBrowser 功能：使用浏览器下载 描述： 创建人：typ 创建时间：2018/10/19 16:20 修改人： 修改描述： 修改时间： */
  private static void setBrowser(
      HttpServletResponse response, HSSFWorkbook workbook, String fileName) {
    try {
      // 清空response
      response.reset();
      // 设置response的Header
      response.setCharacterEncoding("utf-8");
      response.setContentType("multipart/form-data");
      response.setHeader("Content-disposition", "attachment; filename=" + fileName);
      OutputStream os = new BufferedOutputStream(response.getOutputStream());

      // 将excel写入到输出流中
      workbook.write(os);
      os.flush();
      os.close();
      log.info("设置浏览器下载成功！");
    } catch (Exception e) {
      log.info("设置浏览器下载失败！");
      e.printStackTrace();
    }
  }
}
