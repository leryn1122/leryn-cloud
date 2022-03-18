package com.leryn.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailMessageHeader {
  private String to;
  private String from;
  private String subject;
}
