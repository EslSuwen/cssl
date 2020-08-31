package com.cqjtu.cssl;

import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.service.ArrangePeriodService;
import com.cqjtu.cssl.service.ArrangeService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
public class CsslApplicationTests {

  @Autowired private ArrangeService arrangeService;
  @Autowired private ArrangePeriodService arrangePeriodService;

  @Test
  public void testOutArrange() {
    log.info(arrangeService.list());
  }

  @Test
  public void testOutArrangePeriod() {
    log.info(arrangePeriodService.list());
  }

  @Test
  public void testMapOutArrange() {
    log.info(arrangeService.findByTid("1"));
  }

  @Test
  public void testLombok() {
    ProjectItem projectItem = new ProjectItem();
    log.info(projectItem.getIid());
  }
}
