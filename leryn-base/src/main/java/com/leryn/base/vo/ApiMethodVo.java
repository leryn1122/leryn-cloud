package com.leryn.base.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Used for listing all the
 *
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiMethodVo {
  private String controllerName;
  private String methodName;
  private String requestType;
  private String requestUrl;
  private Class<?>[] methodParmaTypes;
}
