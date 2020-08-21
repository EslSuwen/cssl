package com.cqjtu.cssl.exception;

import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 异常包装类
 *
 * @author guangyong.yang
 * @date 2019-01-05
 */
@ControllerAdvice
@Log4j2
public class RestExceptionHandler {

  @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
  @ResponseBody
  public ResponseEntity<ResultDto> handler(Exception ex) {

    StringBuilder sb = new StringBuilder();
    if (ex instanceof ConstraintViolationException) {
      ConstraintViolationException ex2 = (ConstraintViolationException) ex;
      for (ConstraintViolation violation : ex2.getConstraintViolations()) {
        sb.append(violation.getMessage());
      }
    } else if (ex instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException ex2 = (MethodArgumentNotValidException) ex;
      BindingResult bindingResult = ex2.getBindingResult();
      if (bindingResult.hasErrors()) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
          sb.append(error.getDefaultMessage()).append(";");
        }
      }
    }

    log.trace(ex.getMessage(), ex);
    return new ResponseEntity<>(
        ResultDto.builder()
            .code(ReturnCode.RETURN_CODE_40006.getCode())
            .message(sb.toString())
            .success(false)
            .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = CompareException.class)
  @ResponseBody
  public ResponseEntity<ResultDto> handleCompareException(CompareException e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(
        ResultDto.builder()
            .code(ReturnCode.RETURN_CODE_40007.getCode())
            .message(e.getMessage())
            .success(false)
            .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResponseEntity<ResultDto> handleOtherException(Exception e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(
        ResultDto.builder()
            .code(ReturnCode.RETURN_CODE_40099.getCode())
            .message(e.getMessage())
            .success(false)
            .build(),
        HttpStatus.BAD_REQUEST);
  }
}
