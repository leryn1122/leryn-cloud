package com.leryn.message.service;

import java.io.File;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.leryn.message.model.EmailMessageHeader;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Service
public class EmailService {

  @Resource
  private JavaMailSender mailSender;

  public void sendEmail(EmailMessageHeader emailMessageHeader) throws MessagingException {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
    messageHelper.setFrom(emailMessageHeader.getFrom());
    messageHelper.setTo(emailMessageHeader.getTo());
    messageHelper.setSubject(emailMessageHeader.getSubject());
    messageHelper.setText("一杯茶，一根烟，一个Bug改一天！");
    messageHelper.addInline("bug.jpg", new File("D:\\SystemUtils\\Desktop\\Activity\\391DCE9C-1A65-4AE7-8685" +
      "-99712F2DE643.jpg"));
    messageHelper.addAttachment("bug.jpg", new File("D:\\SystemUtils\\Desktop\\Activity\\391DCE9C-1A65-4AE7-8685" +
      "-99712F2DE643.jpg"));
    mailSender.send(mimeMessage);
  }

}
