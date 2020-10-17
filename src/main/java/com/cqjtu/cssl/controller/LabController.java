package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.service.LabInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实验室信息控制器
 *
 * @author suwen
 * @since 2020/5/29 9:30 上午
 */
@Log4j2
@Api(tags = "实验室信息-控制器")
@RestController
@RequestMapping("/lab")
public class LabController {

  private final LabInfoService labInfoService;

  @Autowired
  public LabController(LabInfoService labInfoService) {
    this.labInfoService = labInfoService;
  }

  /**
   * 根据实验室编号获得实验室信息
   *
   * @param labId 实验室编号
   * @return 实验室信息
   * @author suwen
   * @date 2020/5/29 上午9:41
   */
  @GetMapping("/getLab")
  public ResponseEntity<ResultDto> getLabById(
      @NonNull @ApiParam(value = "实验室编号", required = true) @RequestParam Integer labId) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取实验室信息成功")
            .data(labInfoService.getById(labId))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据实验室编号获得实验室信息
   *
   * @param typeId 实验室类型编号
   * @return 实验室信息
   * @author suwen
   * @date 2020/5/29 上午9:41
   */
  @GetMapping("/getLabByTypeId")
  public ResponseEntity<ResultDto> getLabByTypeId(
      @NonNull @ApiParam(value = "实验室类型编号", required = true) @RequestParam Integer typeId) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取实验室信息成功")
            .data(labInfoService.getLabByTypeId(typeId))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据实验室编号获得实验室信息
   *
   * @param typeId 实验室类型编号
   * @param campus 校区
   * @return 实验室信息
   * @author suwen
   * @date 2020/5/29 上午9:41
   */
  @GetMapping("/getLabByTypeIdCampus")
  public ResponseEntity<ResultDto> getLabByTypeIdCampus(
      @NonNull @ApiParam(value = "实验室类型编号", required = true) @RequestParam Integer typeId,
      @NonNull @ApiParam(value = "校区", required = true) @RequestParam String campus) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取实验室信息成功")
            .data(labInfoService.getLabByTypeIdCampus(typeId, campus))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据实验室编号获得实验室信息
   *
   * @param proId 项目编号
   * @return 实验室信息
   * @author suwen
   * @date 2020/8/21 上午11:32
   */
  @GetMapping("/getLabByProId")
  public ResponseEntity<ResultDto> getLabByProId(
      @ApiParam(value = "项目编号", required = true) @RequestParam Integer proId) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取实验室信息成功")
            .data(labInfoService.getLabByProId(proId))
            .build(),
        HttpStatus.OK);
  }
}
