package com.cqjtu.cssl.dto;

import com.cqjtu.cssl.constant.ResultCode;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 返回包装类
 *
 * @author suwen
 * @date 2020/10/25 15:13
 */
@Data
@Builder
public class Result {
  /** 返回码 */
  private Integer code;

  /** 返回消息 */
  private String message;

  /** 是否成功 */
  private boolean success;

  /** 返回数据 */
  private Object data;

  public static ResponseEntity<Result> success() {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(ResultCode.SUCCESS.getCode())
            .message(ResultCode.SUCCESS.getMessage())
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> successGet(Object data) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message(ResultCode.SUCCESS_GET_DATA.getMessage())
            .data(data)
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> successAdd(Object... data) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(ResultCode.SUCCESS_ADD_DATA.getCode())
            .message(ResultCode.SUCCESS_ADD_DATA.getMessage())
            .data(data)
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> successUpdate(Object... data) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(ResultCode.SUCCESS_UPDATE_DATA.getCode())
            .message(ResultCode.SUCCESS_ADD_DATA.getMessage())
            .data(data)
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> successDelete(Object... data) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(ResultCode.SUCCESS_DELETE_DATA.getCode())
            .message(ResultCode.SUCCESS_DELETE_DATA.getMessage())
            .data(data)
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> success(Object data) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(ResultCode.SUCCESS.getCode())
            .message(ResultCode.SUCCESS.getMessage())
            .data(data)
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> success(ResultCode resultCode) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(resultCode.getCode())
            .message(resultCode.getMessage())
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> success(Object data, ResultCode resultCode) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(resultCode.getCode())
            .message(resultCode.getMessage())
            .data(data)
            .build(),
        HttpStatus.OK);
  }

  public static ResponseEntity<Result> success(
      Object data, ResultCode resultCode, HttpStatus httpStatus) {
    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(resultCode.getCode())
            .message(resultCode.getMessage())
            .data(data)
            .build(),
        httpStatus);
  }

  public static ResponseEntity<Result> failure(ResultCode resultCode) {
    return new ResponseEntity<>(
        Result.builder().code(resultCode.getCode()).message(resultCode.getMessage()).build(),
        HttpStatus.BAD_REQUEST);
  }

  public static ResponseEntity<Result> failure(Object data, ResultCode resultCode) {
    return new ResponseEntity<>(
        Result.builder()
            .code(resultCode.getCode())
            .message(resultCode.getMessage())
            .data(data)
            .build(),
        HttpStatus.BAD_REQUEST);
  }

  public static ResponseEntity<Result> failure(
      Object data, ResultCode resultCode, HttpStatus httpStatus) {
    return new ResponseEntity<>(
        Result.builder()
            .code(resultCode.getCode())
            .message(resultCode.getMessage())
            .data(data)
            .build(),
        httpStatus);
  }
}
