package com.cqjtu.cssl;

import com.cqjtu.cssl.service.ArrangePeriodService;
import com.cqjtu.cssl.service.ArrangeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

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
}
