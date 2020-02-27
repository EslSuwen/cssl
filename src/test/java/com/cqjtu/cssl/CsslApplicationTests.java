package com.cqjtu.cssl;

import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.service.ArrangePeriodService;
import com.cqjtu.cssl.service.ArrangeService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@Log4j2
@SpringBootTest
class CsslApplicationTests {

  @Autowired private DataSource dataSource;
  @Autowired private ArrangeService arrangeService;
  @Autowired private ArrangePeriodService arrangePeriodService;

  @Test
  void contextLoads() {}

  @Test
  public void testDataSource() throws SQLException {
    System.out.println(dataSource.getConnection());
  }

  @Test
  public void testOutArrange() {
    System.out.println(arrangeService.list());
  }

  @Test
  public void testOutArrangePeriod() {
    System.out.println(arrangePeriodService.list());
  }

  @Test
  public void testMapOutArrange() {
    System.out.println(arrangeService.findByTid("1"));
  }

  @Test
  public void testLombok() {
    ProjectItem projectItem = new ProjectItem();
    log.info(projectItem.getIId());
  }
}
