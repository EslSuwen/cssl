package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Demo;
import com.cqjtu.cssl.service.DemodataRepository;
import com.cqjtu.cssl.utils.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 数据传送测试 Demo 控制器
 *
 * @author: suwen
 * @time: 2020/2/6 2:33 下午
 */
@RestController
@RequestMapping(path = "/demo")
public class DemoController {

  //  该注释告诉springboot，去帮助实现Repository接口。否则，抛空指针异常。
  @Autowired private DemodataRepository demodataRepository;

  /**
   * 增加数据 Springboot将返回的类，以JSON字符串形式输出。这里使用Message model建立json格式数据
   *
   * @param demodata 请求体参数
   * @return: com.cqjtu.cssl.utils.MessageHelper
   * @author: suwen
   * @time: 2020/2/6 2:34 下午
   */
  @PostMapping(value = "/newData")
  public MessageHelper addNewData(@RequestBody Demo demodata) {
    System.out.println("addNewData()被调用");
    MessageHelper msg = new MessageHelper();
    // save后自动添加id
    demodataRepository.save(demodata);
    msg.setMsg(
        "The info of " + demodata.getName() + " has been added with the ID: " + demodata.getId());
    return msg;
  }

  /**
   * 获取数据 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
   *
   * @return: Iterable<com.cqjtu.cssl.entity.Demo>
   * @author: suwen
   * @time: 2020/2/6 2:35 下午
   */
  @GetMapping(value = "/getData")
  public Iterable<Demo> getDemodatas() {

    System.out.println("getDemodatas()被调用");

    return demodataRepository.findAll();
  }

  /**
   * 删除数据
   *
   * @return: com.cqjtu.cssl.utils.MessageHelper
   * @author: suwen
   * @time:
   */
  @DeleteMapping(value = "/clearData")
  public MessageHelper clearDemodatas() {
    System.out.println("clearDemodatas()被调用");
    demodataRepository.deleteAll();
    MessageHelper msg = new MessageHelper();
    msg.setMsg("The database has been cleared");
    return msg;
  }
}
