package com.zycus.emailpractice.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import model.Mail;

@Service
public class Emailsenderimpl {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;


    public ResponseEntity<String> sendEmail(Mail mail) {
        try{
        MimeMessage message = emailSender.createMimeMessage();
  
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Context context = new Context();
        context.setVariables(mail.getProps());
    
        String html = templateEngine.process("registration", context);

        helper.setTo(mail.getTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());
        FileSystemResource filesystem=new FileSystemResource("C:\\Projects\\emailpractice\\src\\main\\resources\\static\\"+mail.getImg());
        helper.addAttachment(filesystem.getFilename(),filesystem);

        emailSender.send(message);
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
       return ResponseEntity.status(HttpStatus.OK).body("Email send to " + mail.getTo());
    }

}