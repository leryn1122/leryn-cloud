package com.leryn.message.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import com.leryn.common.vo.Result;
import com.leryn.message.model.EmailMessageHeader;
import com.leryn.message.service.EmailService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class EmailController {

  @Resource
  private EmailService emailService;

  @PostMapping("/mail/send")
  public Result sendEmail(@RequestBody EmailMessageHeader emailMessageHeader) throws MessagingException {
    emailService.sendEmail(emailMessageHeader);
    return Result.onSuccess(emailMessageHeader);
  }

}

