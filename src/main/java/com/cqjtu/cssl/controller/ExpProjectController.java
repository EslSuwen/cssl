package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.service.ExpProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 项目卡片控制器
 *
 * @author suwen
 * @date 2020/2/6 2:50 下午
 */
@Api(tags = "项目卡片-控制器")
@RestController
@RequestMapping("/project")
@Log4j2
public class ExpProjectController {

  private final ExpProjectService expProjectService;

  @Autowired
  public ExpProjectController(ExpProjectService expProjectService) {
    this.expProjectService = expProjectService;
  }

  /**
   * 项目卡片增加
   *
   * @param expProject 请求体变量 项目卡片
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:51 下午
   */
  @PostMapping(value = "/addProject")
  public ResponseEntity<ResultDto> addNewProject(@NonNull @RequestBody ExpProject expProject)
      throws Exception {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(expProjectService.addProject(expProject))
            .code(ReturnCode.RETURN_CODE_20005.getCode())
            .message("增加卡片成功")
            .data(
                expProjectService
                    .getExpByTidCid(expProject.getExpTid(), expProject.getCourseId())
                    .getProId())
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取项目卡片数据
   *
   * @param tid 教师编号
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/2/6 2:52 下午
   */
  @GetMapping(value = "/getProject")
  public ResponseEntity<ResultDto> getProjects(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "学期", required = true) @RequestParam String term) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取项目卡片数据成功")
            .data(expProjectService.getExpByTid(tid, term))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取待审核项目卡片数据
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/5/10 11:14 上午
   */
  @GetMapping(value = "/getAuditProject")
  public ResponseEntity<ResultDto> getAuditProjects() {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20004.getCode())
            .message("获取项目卡片待审核数据成功")
            .data(expProjectService.getAuditProjects())
            .build(),
        HttpStatus.OK);
  }

  /**
   * 审核项目卡片
   *
   * @param proId 项目卡片编号
   * @param status 审核状态
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/5/10 11:24 上午
   */
  @PutMapping(value = "/auditProject")
  public ResponseEntity<ResultDto> auditProject(
      @NonNull @ApiParam(value = "项目卡片编号", required = true) @RequestParam String proId,
      @NonNull @ApiParam(value = "审核状态", required = true) @RequestParam Audit status) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("审核项目卡片成功")
            .data(expProjectService.auditProject(proId, status))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 项目卡片删除
   *
   * @author suwen
   * @date 2020/2/6 2:53 下午
   */
  @DeleteMapping(value = "/deleteProject")
  public ResponseEntity<ResultDto> deleteProject(
      @NonNull @ApiParam(value = "项目卡片编号", required = true) @RequestParam String proId) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20006.getCode())
            .message("删除项目卡片成功")
            .data(expProjectService.removeById(proId))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获得存在学期列表
   *
   * @return 学期列表
   * @author suwen
   * @date 2020/6/1 下午10:06
   */
  @GetMapping(value = "/getTermList")
  public ResponseEntity<ResultDto> getTermList() {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获得存在学期列表成功")
            .data(expProjectService.getTermList())
            .build(),
        HttpStatus.OK);
  }
}
