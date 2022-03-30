package com.leryn.message.model;

import javax.validation.constraints.NotEmpty;

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
  @NotEmpty(message = "To mail must be be null.")
  private String to;

  @NotEmpty(message = "From mail must be be null.")
  private String from;

  @NotEmpty(message = "Subject must be be null.")
  private String subject;
}
